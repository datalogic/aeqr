# Datalogic Barcode Scanner Android App

This is an Android mobile application designed for Datalogic terminals with integrated barcode scanners.

## Features

- **Barcode Scanning**: Uses Datalogic's integrated scan engine to read barcodes
- **Quantity Input**: Allows setting a quantity for each scanned barcode
- **Data Collection**: Collects a sequence of barcodes and their quantities
- **File Export**: Saves the collected data to a text file in the Download folder

## Requirements

- Datalogic Android device with integrated scanner
- Android OS version 5.0 (API 21) or higher
- Datalogic SDK (included with Datalogic devices)

## Installation

1. Build the APK using Android Studio or Gradle:
   ```bash
   cd android-app
   ./gradlew assembleDebug
   ```

2. Install the APK on your Datalogic device:
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

## Usage

1. Launch the app on your Datalogic device
2. Set the desired quantity in the "Quantity" field (default is 1)
3. Scan barcodes using the integrated scanner (press the scan button on the device)
4. Each scan will be added to the list with the specified quantity
5. Click "Save to File" to export the data to a text file in the Download folder
6. Click "Clear All" to reset the list and start over

## File Format

The exported text file contains:
- Header with generation timestamp
- Tab-separated values: `BARCODE [TAB] QUANTITY`
- Footer with total item count

Example:
```
Barcode Scan Report
Generated: 2026-01-12 12:30:45
=====================================

1234567890123	5
9876543210987	2
1111111111111	10

=====================================
Total items: 3
```

## Datalogic SDK

This app requires the Datalogic SDK to function properly. The SDK is typically pre-installed on Datalogic devices. For development purposes:

1. Download the Datalogic SDK from [Datalogic's developer portal](https://datalogic.github.io/)
2. Place the `datalogic-sdk.jar` file in the `app/libs/` directory
3. The SDK is included as a `compileOnly` dependency since it's provided by the device at runtime

## Permissions

The app requests the following permissions based on Android version:
- `WRITE_EXTERNAL_STORAGE`: To save files to the public Download folder (Android 5-9 only)

**Storage Behavior**:
- **Android 10+ (API 29+)**: Uses app-specific external storage (`/Android/data/com.datalogic.barcodescanner/files/Download/`). No permissions required.
- **Android 5-9 (API 21-28)**: Uses public Downloads directory (`/storage/emulated/0/Download/`). Requires `WRITE_EXTERNAL_STORAGE` permission.

The app automatically handles the appropriate storage location based on the Android version.

## Technical Details

- **Language**: Java
- **Minimum SDK**: API 21 (Android 5.0)
- **Target SDK**: API 34 (Android 14)
- **SDK Integration**: Datalogic SDK for barcode scanning

## Development Notes

- The app implements `ReadListener` to receive barcode scan events from the Datalogic SDK
- The UI is designed to be simple and functional for warehouse/inventory use cases
- The app handles permission requests for file writing on different Android versions
- Error handling is included for cases where the SDK is not available (non-Datalogic devices)

## Testing

For testing on non-Datalogic devices, the app will display a message indicating the SDK is not available. Full functionality requires a Datalogic device with the integrated scanner.

## License

This is a sample application for Datalogic terminals.
