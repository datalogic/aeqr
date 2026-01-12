# Android App for Datalogic Terminals - Barcode Scanner

## Descrizione (Description)

Questa è un'applicazione Android nativa sviluppata specificamente per terminali Datalogic con scanner integrato. L'app permette di:

1. **Leggere codici a barre** utilizzando lo scan engine integrato dei dispositivi Datalogic
2. **Raccogliere una sequenza di codici** con le relative quantità
3. **Salvare i dati** in un file di testo nella cartella Download del dispositivo

---

This is a native Android application developed specifically for Datalogic terminals with integrated scanner. The app allows you to:

1. **Read barcodes** using the integrated scan engine of Datalogic devices
2. **Collect a sequence of codes** with their quantities
3. **Save the data** to a text file in the device's Download folder

## Struttura del Progetto (Project Structure)

```
android-app/
├── app/
│   ├── build.gradle                 # App-level Gradle configuration
│   ├── proguard-rules.pro          # ProGuard rules
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml # App manifest with permissions
│           ├── java/com/datalogic/barcodescanner/
│           │   └── MainActivity.java # Main activity with scanner logic
│           └── res/
│               ├── layout/
│               │   └── activity_main.xml # UI layout
│               ├── values/
│               │   └── strings.xml   # String resources
│               └── mipmap-*/         # App icons
├── build.gradle                     # Project-level Gradle configuration
├── settings.gradle                  # Gradle settings
├── gradle.properties               # Gradle properties
└── README.md                        # Detailed documentation
```

## Funzionalità Principali (Main Features)

### 1. Scansione Barcode (Barcode Scanning)
- Utilizza il Datalogic SDK per accedere allo scanner integrato
- Supporta tutti i formati di barcode supportati dai dispositivi Datalogic
- Feedback visivo immediato per ogni scansione

### 2. Input Quantità (Quantity Input)
- Campo editabile per specificare la quantità prima di ogni scansione
- Valore predefinito: 1
- Supporta numeri interi

### 3. Lista Scansioni (Scan List)
- Visualizzazione in tempo reale di tutte le scansioni
- Formato: "Numero. BARCODE - Qty: QUANTITÀ"
- Area scrollabile per gestire liste lunghe

### 4. Salvataggio File (File Saving)
- Salva automaticamente nella cartella Download
- Nome file con timestamp: `barcode_scan_YYYYMMDD_HHMMSS.txt`
- Formato file: valori separati da TAB (BARCODE[TAB]QUANTITÀ)

### 5. Gestione Lista (List Management)
- Pulsante "Clear All" per svuotare la lista
- Conferma visiva delle operazioni tramite Toast

## Requisiti Tecnici (Technical Requirements)

- **Dispositivo**: Terminale Datalogic con scanner integrato
- **OS**: Android 5.0 (API 21) o superiore
- **SDK**: Datalogic SDK (pre-installato sui dispositivi Datalogic)

## Istruzioni di Build (Build Instructions)

### Prerequisiti:
1. Android Studio Arctic Fox o superiore
2. Android SDK installato
3. Datalogic SDK (per sviluppo su dispositivi non-Datalogic)

### Build:
```bash
cd android-app
./gradlew assembleDebug
```

L'APK verrà generato in: `app/build/outputs/apk/debug/app-debug.apk`

### Installazione su Dispositivo:
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

## Come Usare l'App (How to Use the App)

1. **Avviare l'app** sul dispositivo Datalogic
2. **Impostare la quantità** desiderata (default: 1)
3. **Scansionare i codici a barre** premendo il pulsante scanner sul dispositivo
4. **Verificare** che ogni scansione appaia nella lista
5. **Salvare** i dati cliccando su "Save to File"
6. **Trovare il file** nella cartella Download del dispositivo
7. **Pulire la lista** con "Clear All" per iniziare una nuova sessione

## Formato File di Output (Output File Format)

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

## Permessi (Permissions)

L'app richiede:
- `WRITE_EXTERNAL_STORAGE` (solo Android 5-9)

**Comportamento dello Storage**:
- **Android 10+ (API 29+)**: Usa storage specifico dell'app. Nessun permesso richiesto.
- **Android 5-9 (API 21-28)**: Usa la cartella Download pubblica. Richiede permesso.

L'app gestisce automaticamente la posizione appropriata in base alla versione Android.

## Note di Sviluppo (Development Notes)

- **Linguaggio**: Java
- **Pattern**: Activity-based con ReadListener callback
- **UI**: LinearLayout con ScrollView per la lista
- **File I/O**: FileWriter per semplicità
- **Error Handling**: Try-catch con Toast per feedback utente

## Possibili Miglioramenti Futuri (Future Enhancements)

- [ ] Supporto per esportazione CSV
- [ ] Possibilità di modificare scansioni esistenti
- [ ] Filtri e ricerca nella lista
- [ ] Sincronizzazione cloud
- [ ] Supporto per fotocamera come scanner alternativo
- [ ] Database locale per storico scansioni
- [ ] Configurazione formati barcode supportati
- [ ] Export in multipli formati (Excel, JSON)

## Supporto (Support)

Per problemi o domande relativi all'SDK Datalogic, consultare:
- [Datalogic Developer Portal](https://datalogic.github.io/)
- Documentazione SDK inclusa con i dispositivi

## Licenza (License)

Applicazione di esempio per terminali Datalogic.
