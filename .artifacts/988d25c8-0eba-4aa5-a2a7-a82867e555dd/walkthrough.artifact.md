# Walkthrough - Full-Bleed Application Icons from logo.jpg

I have re-generated all application icons to use the full-bleed style, where `logo.jpg` expands to fill the entire icon area.

## Changes Made

### Full-Bleed Asset Generation
I used ImageMagick with a "resize and crop" strategy to ensure the image covers 100% of the icon area for every density:
- **Legacy Icons**: 48dp to 192dp range, all square and filled.
- **Adaptive Foreground**: 108dp to 432dp range, all square and filled.

### Verification Results

#### Dimensions Verification
I verified that the output files are exactly the required sizes and in PNG format.
- `xhdpi/ic_launcher.png`: 96x96 px (Full-bleed)
- `xhdpi/ic_launcher_foreground.png`: 216x216 px (Full-bleed)

> [!IMPORTANT]
> **Mask Clipping**: Because the adaptive foreground layer (108x108 dp) is now full-bleed, the system mask (circle, squircle, etc.) will clip the outer edges of your logo. This is the intended "full-bleed" behavior.

> [!TIP]
> All assets are in **PNG** format as requested. Legacy `.webp` files were previously removed and have not been recreated.
