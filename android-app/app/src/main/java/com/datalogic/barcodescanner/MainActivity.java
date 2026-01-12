package com.datalogic.barcodescanner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.datalogic.decode.BarcodeManager;
import com.datalogic.decode.DecodeException;
import com.datalogic.decode.DecodeResult;
import com.datalogic.decode.ReadListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements ReadListener {

    private static final int PERMISSION_REQUEST_CODE = 100;
    
    private BarcodeManager barcodeManager;
    private TextView tvLastScan;
    private TextView tvScannedList;
    private EditText etQuantity;
    private Button btnSave;
    private Button btnClear;
    
    private List<ScanEntry> scanEntries = new ArrayList<>();
    
    private static class ScanEntry {
        String barcode;
        String quantity;
        
        ScanEntry(String barcode, String quantity) {
            this.barcode = barcode;
            this.quantity = quantity;
        }
        
        @Override
        public String toString() {
            return barcode + " - Qty: " + quantity;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        tvLastScan = findViewById(R.id.tvLastScan);
        tvScannedList = findViewById(R.id.tvScannedList);
        etQuantity = findViewById(R.id.etQuantity);
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);

        // Set default quantity
        etQuantity.setText("1");

        // Setup button listeners
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFile();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScans();
            }
        });

        // Check and request permissions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!checkPermissions()) {
                requestPermissions();
            }
        }

        // Initialize Datalogic Scanner
        initializeScanner();
    }

    private void initializeScanner() {
        try {
            barcodeManager = new BarcodeManager();
            barcodeManager.addReadListener(this);
            Toast.makeText(this, "Scanner initialized", Toast.LENGTH_SHORT).show();
        } catch (DecodeException e) {
            Toast.makeText(this, "Error initializing scanner: " + e.getMessage(), 
                Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (Exception e) {
            // Handle case when SDK is not available (for testing on non-Datalogic devices)
            Toast.makeText(this, "Datalogic SDK not available. Please run on Datalogic device.", 
                Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRead(DecodeResult decodeResult) {
        // This is called when a barcode is scanned
        final String barcode = decodeResult.getText();
        
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String quantity = etQuantity.getText().toString().trim();
                if (quantity.isEmpty()) {
                    quantity = "1";
                } else {
                    // Validate numeric input
                    try {
                        Integer.parseInt(quantity);
                    } catch (NumberFormatException e) {
                        quantity = "1";
                        etQuantity.setText("1");
                        Toast.makeText(MainActivity.this, "Invalid quantity, using 1", 
                            Toast.LENGTH_SHORT).show();
                    }
                }
                
                // Add to list
                scanEntries.add(new ScanEntry(barcode, quantity));
                
                // Update UI
                tvLastScan.setText("Last scan: " + barcode + " (Qty: " + quantity + ")");
                updateScannedList();
                
                // Play a beep or vibrate to indicate successful scan
                Toast.makeText(MainActivity.this, "Scanned: " + barcode, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateScannedList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scanEntries.size(); i++) {
            sb.append((i + 1)).append(". ").append(scanEntries.get(i).toString()).append("\n");
        }
        tvScannedList.setText(sb.toString());
    }

    private void clearScans() {
        scanEntries.clear();
        tvLastScan.setText("Last scan: -");
        tvScannedList.setText("");
        Toast.makeText(this, "List cleared", Toast.LENGTH_SHORT).show();
    }

    private void saveToFile() {
        if (scanEntries.isEmpty()) {
            Toast.makeText(this, "No scans to save", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Get the Download directory
            // For Android 10+ (API 29+), we use app-specific external storage which doesn't require permissions
            // For older versions, we use the public Downloads directory
            File downloadDir;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // Use app-specific external storage for Android 10+
                downloadDir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            } else {
                // Use public Downloads directory for older Android versions
                downloadDir = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS);
            }
            
            // Ensure directory exists
            if (downloadDir != null && !downloadDir.exists()) {
                downloadDir.mkdirs();
            }
            
            // Create filename with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
                .format(new Date());
            String filename = "barcode_scan_" + timestamp + ".txt";
            
            File file = new File(downloadDir, filename);
            
            // Write data to file using try-with-resources
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Barcode Scan Report\n");
                writer.write("Generated: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", 
                    Locale.getDefault()).format(new Date()) + "\n");
                writer.write("=====================================\n\n");
                
                for (ScanEntry entry : scanEntries) {
                    writer.write(entry.barcode + "\t" + entry.quantity + "\n");
                }
                
                writer.write("\n=====================================\n");
                writer.write("Total items: " + scanEntries.size() + "\n");
            }
            
            Toast.makeText(this, "Saved to: " + file.getAbsolutePath(), 
                Toast.LENGTH_LONG).show();
            
        } catch (IOException e) {
            Toast.makeText(this, "Error saving file: " + e.getMessage(), 
                Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private boolean checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int writePermission = ContextCompat.checkSelfPermission(this, 
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
            return writePermission == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
            PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, 
        int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission denied. Cannot save files.", 
                    Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (barcodeManager != null) {
            try {
                barcodeManager.removeReadListener(this);
                barcodeManager.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
