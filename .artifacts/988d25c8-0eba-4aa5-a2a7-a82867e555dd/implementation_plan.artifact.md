# Implementation Plan - Total Full-Bleed Application Icons

The goal is to update the adaptive icon definitions so that `logo.jpg` completely fills both the background and foreground layers, ensuring the image "expands completely" and covers the entire icon area regardless of the device's mask shape.

## Proposed Changes

### Icon Assets Generation

I will use ImageMagick to ensure we have high-quality, full-bleed PNGs for both the background and foreground of the adaptive icon.

#### Full-Bleed Background Icons (`ic_launcher_background.png`)
Targeting `app/src/main/res/mipmap-<density>/`:
- **mdpi**: 108x108 px
- **hdpi**: 162x162 px
- **xhdpi**: 216x216 px
- **xxhdpi**: 324x324 px
- **xxxhdpi**: 432x432 px

#### Full-Bleed Foreground Icons (`ic_launcher_foreground.png`)
(Re-confirming or re-generating the existing ones to match the "completely expanded" requirement)
- Same dimensions as above.

### Resource Configuration

#### [MODIFY] [ic_launcher.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml)
Update to use the new `@mipmap` assets for both layers.

```xml
<adaptive-icon ...>
    <background android:drawable="@mipmap/ic_launcher_background" />
    <foreground android:drawable="@mipmap/ic_launcher_foreground" />
    <monochrome android:drawable="@mipmap/ic_launcher_foreground" />
</adaptive-icon>
```

#### [MODIFY] [ic_launcher_round.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml)
Apply the same changes as above.

## Verification Plan

### Manual Verification
- I will verify the generated file dimensions with `magick identify`.
- I will confirm the XML files correctly point to the `@mipmap` resources.
