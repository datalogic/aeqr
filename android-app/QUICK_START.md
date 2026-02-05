# Quick Start Guide - Barcode Scanner App

## Per Utenti Italiani / For Italian Users

### Installazione Rapida

1. **Prerequisiti**:
   - Terminale Datalogic Android
   - Connessione USB o WiFi per trasferimento APK

2. **Installazione**:
   - Scaricare l'APK sul dispositivo
   - Abilitare "Sorgenti sconosciute" nelle impostazioni
   - Installare l'APK
   - Avviare l'app

3. **Primo Utilizzo**:
   - L'app chiederà i permessi per salvare file
   - Accettare i permessi
   - Iniziare a scansionare

### Uso Quotidiano

1. Avviare l'app
2. Impostare la quantità desiderata (campo "Quantity")
3. Premere il pulsante scanner fisico sul terminale Datalogic
4. Il codice apparirà nella lista con la quantità
5. Ripetere per tutti i codici
6. Premere "Save to File" per salvare
7. Il file sarà nella cartella Download

### Esempio di Utilizzo

**Scenario**: Inventario magazzino

1. Aprire l'app
2. Impostare quantità = 5
3. Scansionare codice prodotto A → aggiunto "A - Qty: 5"
4. Cambiare quantità = 10
5. Scansionare codice prodotto B → aggiunto "B - Qty: 10"
6. Salvare → file creato: `barcode_scan_20260112_143022.txt`

Il file conterrà:
```
Barcode Scan Report
Generated: 2026-01-12 14:30:22
=====================================

CODICE_PRODOTTO_A	5
CODICE_PRODOTTO_B	10

=====================================
Total items: 2
```

---

## For English Users

### Quick Installation

1. **Prerequisites**:
   - Datalogic Android terminal
   - USB or WiFi connection for APK transfer

2. **Installation**:
   - Download the APK to the device
   - Enable "Unknown sources" in settings
   - Install the APK
   - Launch the app

3. **First Use**:
   - The app will request file storage permissions
   - Accept the permissions
   - Start scanning

### Daily Usage

1. Launch the app
2. Set the desired quantity (Quantity field)
3. Press the physical scanner button on the Datalogic terminal
4. The code will appear in the list with the quantity
5. Repeat for all codes
6. Press "Save to File" to save
7. The file will be in the Download folder

### Usage Example

**Scenario**: Warehouse inventory

1. Open the app
2. Set quantity = 5
3. Scan product code A → added "A - Qty: 5"
4. Change quantity = 10
5. Scan product code B → added "B - Qty: 10"
6. Save → file created: `barcode_scan_20260112_143022.txt`

The file will contain:
```
Barcode Scan Report
Generated: 2026-01-12 14:30:22
=====================================

PRODUCT_CODE_A	5
PRODUCT_CODE_B	10

=====================================
Total items: 2
```

## Troubleshooting / Risoluzione Problemi

### L'app non si avvia / App doesn't start
- Verificare che il dispositivo sia Android 5.0 o superiore
- Check that the device is Android 5.0 or higher

### Lo scanner non funziona / Scanner doesn't work
- Verificare che sia un dispositivo Datalogic con scanner integrato
- Riavviare l'app
- Check that it's a Datalogic device with integrated scanner
- Restart the app

### Impossibile salvare il file / Cannot save file
- Verificare di aver accettato i permessi
- Controllare che ci sia spazio disponibile
- Check that you accepted the permissions
- Check that there is available storage space

### Dove trovo il file salvato? / Where is the saved file?
- Aprire l'app "File Manager" o "Files"
- Navigare a "Download" o "Downloads"
- Cercare file che iniziano con "barcode_scan_"
- Open the "File Manager" or "Files" app
- Navigate to "Download" or "Downloads"
- Look for files starting with "barcode_scan_"

## Supporto / Support

Per assistenza tecnica o segnalare problemi:
For technical support or to report issues:

- Repository: https://github.com/datalogic/aeqr
- Issues: https://github.com/datalogic/aeqr/issues
