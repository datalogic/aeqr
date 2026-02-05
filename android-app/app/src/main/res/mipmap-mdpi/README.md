# App Icons

The app requires launcher icons in different resolutions. These should be placed in the respective mipmap directories:

## Required Icons:

- `mipmap-mdpi/ic_launcher.png` - 48x48 px
- `mipmap-hdpi/ic_launcher.png` - 72x72 px
- `mipmap-xhdpi/ic_launcher.png` - 96x96 px
- `mipmap-xxhdpi/ic_launcher.png` - 144x144 px
- `mipmap-xxxhdpi/ic_launcher.png` - 192x192 px

## Icon Design Suggestions:

The icon should represent barcode scanning. Recommended design elements:
- Barcode symbol
- Scanner beam or laser
- Datalogic colors (if following brand guidelines)

## How to Generate Icons:

1. Use Android Studio's Asset Studio:
   - Right-click on `res` folder
   - New > Image Asset
   - Configure icon type as "Launcher Icons"
   - Choose your icon image or clipart
   - Generate all densities

2. Use online tools:
   - [Android Asset Studio](http://romannurik.github.io/AndroidAssetStudio/)
   - [App Icon Generator](https://appicon.co/)

3. Manual creation:
   - Create PNG files at the required resolutions
   - Place them in the appropriate mipmap directories
   - Ensure the files are named `ic_launcher.png`

## Placeholder Note:

For development and testing, Android will use a default icon if none is provided. However, for production deployment, proper icons should be created and added to the mipmap directories.
