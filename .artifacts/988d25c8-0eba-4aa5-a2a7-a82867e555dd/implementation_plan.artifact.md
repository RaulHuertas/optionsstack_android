# Implementation Plan - Full-Bleed Application Icons from logo.jpg

The goal is to re-generate the application icons so that the source image `logo.jpg` expands to occupy the entire area of each icon (full-bleed), without any margins or padding.

## Proposed Changes

### Icon Assets Generation (Full-Bleed)

I will use ImageMagick (`magick`) with the "resize and crop to fill" strategy (`-resize "XxY^" -gravity center -extent XxY`) to ensure the target squares are completely covered by the image.

#### Legacy Launcher Icons (`ic_launcher.png` and `ic_launcher_round.png`)
Targeting `app/src/main/res/mipmap-<density>/`:
- **mdpi**: 48x48 px
- **hdpi**: 72x72 px
- **xhdpi**: 96x96 px
- **xxhdpi**: 144x144 px
- **xxxhdpi**: 192x192 px

#### Adaptive Icon Foreground (`ic_launcher_foreground.png`)
Targeting `app/src/main/res/mipmap-<density>/`:
- **mdpi**: 108x108 px
- **hdpi**: 162x162 px
- **xhdpi**: 216x216 px
- **xxhdpi**: 324x324 px
- **xxxhdpi**: 432x432 px

> [!WARNING]
> **Adaptive Icon Clipping**: Expanding the image to fill the entire 108x108 dp foreground layer means the edges of the image will be clipped by the Android system's icon mask (e.g., the corners of the squircle or the edges of the circle). This is the expected result of "occupying all of the image".

### Verification Plan

#### Manual Verification
- I will use `magick identify` to confirm the dimensions and verify that the files are PNG format.
- I will check the file list to ensure no other formats (like `.webp`) are present.
