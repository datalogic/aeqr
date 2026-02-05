# Android Studio Setup Guide

## Locating the Project Files

The Android project files are located in the **`android-app/`** directory of this repository:

```
aeqr/
└── android-app/           ← Open this folder in Android Studio
    ├── app/
    │   ├── src/
    │   │   └── main/
    │   │       ├── java/
    │   │       ├── res/
    │   │       └── AndroidManifest.xml
    │   ├── build.gradle
    │   └── libs/
    ├── build.gradle
    ├── settings.gradle
    ├── gradle/
    ├── gradlew
    └── gradle.properties
```

## Opening the Project in Android Studio

### Method 1: Import Project (Recommended)

1. **Launch Android Studio**
2. Click **"Open"** or **"Import Project"** from the welcome screen
3. Navigate to the `android-app` folder in your repository
4. Select the **`android-app`** folder (not the parent `aeqr` folder)
5. Click **"OK"**
6. Android Studio will automatically detect the Gradle project and sync

### Method 2: From File Menu

1. Open Android Studio
2. Go to **File → Open**
3. Navigate to and select the `android-app` folder
4. Click **"OK"**

### First-Time Setup

After opening the project, Android Studio will:
1. Download and configure the Gradle wrapper
2. Download project dependencies
3. Build the project configuration
4. Index the project files

This may take a few minutes on first open.

## Project Structure in Android Studio

Once opened, you'll see the standard Android project structure:

```
DatalogicBarcodeScanner
├── app
│   ├── manifests
│   │   └── AndroidManifest.xml
│   ├── java
│   │   └── com.datalogic.barcodescanner
│   │       └── MainActivity.java
│   └── res
│       ├── layout
│       │   └── activity_main.xml
│       └── values
│           └── strings.xml
└── Gradle Scripts
    ├── build.gradle (Project)
    ├── build.gradle (Module: app)
    ├── settings.gradle
    └── gradle.properties
```

## Before Building: Add Datalogic SDK

The project requires the Datalogic SDK JAR file. **You must add this before building:**

### Option 1: From Datalogic Device

```bash
adb pull /system/framework/com.datalogic.device.jar app/libs/datalogic-sdk.jar
```

### Option 2: Download from Datalogic

1. Visit [Datalogic GitHub](https://github.com/datalogic)
2. Download the Datalogic SDK
3. Copy the JAR file to `android-app/app/libs/datalogic-sdk.jar`

### Option 3: Build Without SDK (for testing UI only)

The project will build without the SDK (it's a `compileOnly` dependency), but the barcode scanning functionality won't work at runtime without a Datalogic device.

## Building the Project

### In Android Studio:

1. **Sync Project**: Click the **"Sync Project with Gradle Files"** button (elephant icon) in the toolbar
2. **Build**: Go to **Build → Make Project** or press **Ctrl+F9** (Cmd+F9 on Mac)
3. **Build APK**: Go to **Build → Build Bundle(s) / APK(s) → Build APK(s)**

The generated APK will be at:
```
android-app/app/build/outputs/apk/debug/app-debug.apk
```

### From Command Line:

```bash
cd android-app
./gradlew assembleDebug
```

## Running on a Device

### Connect Datalogic Device:

1. Enable **Developer Options** and **USB Debugging** on your Datalogic device
2. Connect via USB cable
3. In Android Studio, select your device from the device dropdown
4. Click the **Run** button (green play icon) or press **Shift+F10**

### Install APK Manually:

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

## Troubleshooting

### "SDK location not found"

Create or edit `local.properties` in the `android-app` folder:
```properties
sdk.dir=/path/to/your/Android/Sdk
```

On Windows:
```properties
sdk.dir=C\:\\Users\\YourUsername\\AppData\\Local\\Android\\Sdk
```

On Mac:
```properties
sdk.dir=/Users/YourUsername/Library/Android/sdk
```

On Linux:
```properties
sdk.dir=/home/YourUsername/Android/Sdk
```

### Gradle Sync Failed

1. Go to **File → Invalidate Caches / Restart**
2. Click **Invalidate and Restart**
3. Wait for Android Studio to reindex the project

### Missing Datalogic SDK Error

If you see compilation errors about missing Datalogic classes:
1. The SDK is marked as `compileOnly`, so it won't cause build failures
2. For full compilation without errors, add a dummy SDK JAR or the actual SDK to `app/libs/`
3. The app will work on Datalogic devices where the SDK is provided by the system

### Build Tools Version

If you get errors about build tools version:
1. Open **Tools → SDK Manager**
2. Go to **SDK Tools** tab
3. Install the required build tools version (34.0.0 or latest)

## Project Configuration Details

- **Language**: Java
- **Min SDK**: API 21 (Android 5.0)
- **Target SDK**: API 34 (Android 14)
- **Compile SDK**: API 34
- **Gradle Version**: 8.0
- **Android Gradle Plugin**: 8.0.2

## Next Steps After Setup

1. **Review the Code**: Open `MainActivity.java` to understand the barcode scanning logic
2. **Customize the UI**: Edit `res/layout/activity_main.xml` in the Layout Editor
3. **Test on Device**: Run on a Datalogic terminal to test barcode scanning
4. **Build Release APK**: Go to **Build → Generate Signed Bundle / APK** for production

## Additional Resources

- **README.md**: Detailed technical documentation
- **QUICK_START.md**: User guide in Italian and English
- **Datalogic SDK**: [https://github.com/datalogic](https://github.com/datalogic)

## Support

For Android Studio issues:
- [Android Studio User Guide](https://developer.android.com/studio/intro)
- [Gradle Build Documentation](https://developer.android.com/studio/build)

For Datalogic SDK issues:
- [Datalogic Developer Portal](https://datalogic.github.io/)
