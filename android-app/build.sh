#!/bin/bash

# Build script for Datalogic Barcode Scanner Android App

echo "======================================"
echo "Datalogic Barcode Scanner - Build Script"
echo "======================================"
echo ""

# Navigate to android-app directory
cd "$(dirname "$0")"

# Check if gradlew exists, if not, we need to create it
if [ ! -f "gradlew" ]; then
    echo "Creating Gradle wrapper..."
    gradle wrapper --gradle-version 8.0
fi

# Make gradlew executable
chmod +x gradlew

echo "Building the app..."
echo ""

# Clean previous builds
echo "Cleaning previous builds..."
./gradlew clean

# Build debug APK
echo ""
echo "Building debug APK..."
./gradlew assembleDebug

# Check if build was successful
if [ $? -eq 0 ]; then
    echo ""
    echo "======================================"
    echo "Build successful!"
    echo "======================================"
    echo ""
    echo "APK location:"
    echo "$(pwd)/app/build/outputs/apk/debug/app-debug.apk"
    echo ""
    echo "To install on connected device, run:"
    echo "adb install app/build/outputs/apk/debug/app-debug.apk"
    echo ""
else
    echo ""
    echo "======================================"
    echo "Build failed!"
    echo "======================================"
    echo ""
    echo "Please check the error messages above."
    exit 1
fi
