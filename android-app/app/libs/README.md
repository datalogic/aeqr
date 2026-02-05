# Datalogic SDK

This directory should contain the Datalogic SDK JAR file for development purposes.

## Getting the SDK

The Datalogic SDK is typically pre-installed on Datalogic Android devices. For development purposes:

1. **Download from Datalogic**:
   - Visit [Datalogic's GitHub](https://github.com/datalogic)
   - Or check [Datalogic Developer Portal](https://datalogic.github.io/)

2. **Extract from Device**:
   If you have access to a Datalogic device, you can extract the SDK:
   ```bash
   adb pull /system/framework/com.datalogic.device.jar ./datalogic-sdk.jar
   ```

3. **Place the JAR**:
   - Download or extract `com.datalogic.device.jar`
   - Rename it to `datalogic-sdk.jar`
   - Place it in this `libs/` directory

## Note on CompileOnly Dependency

The app's build.gradle uses `compileOnly` for the SDK dependency:
```gradle
compileOnly files('libs/datalogic-sdk.jar')
```

This means:
- The SDK is needed for compilation
- At runtime, the app will use the SDK from the device's system
- You don't need to include the SDK in the APK

## Alternative: Using Maven

Datalogic may provide Maven artifacts. If available, you can replace the local JAR dependency with:
```gradle
implementation 'com.datalogic:datalogic-sdk:x.x.x'
```

Check the Datalogic documentation for the latest Maven coordinates.

## For Testing Without SDK

If you're testing on a non-Datalogic device or don't have the SDK:
- The app will compile (the SDK is compileOnly)
- At runtime, it will show an error message about the SDK not being available
- Full functionality requires a Datalogic device with the actual SDK
