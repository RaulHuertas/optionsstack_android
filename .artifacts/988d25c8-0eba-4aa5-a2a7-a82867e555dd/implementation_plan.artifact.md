# Implementation Plan - Generate Application Icons from logo.jpg

The goal is to generate high-quality PNG icons for all Android screen densities using the provided `logo.jpg` file. This includes both legacy launcher icons and foreground layers for adaptive icons.

## User Review Required

> [!IMPORTANT]
> **Transparency/Background**: `logo.jpg` is a JPEG and likely lacks transparency. When used as a foreground layer for an adaptive icon, it will be placed over the existing background. If the logo has a background itself, it might look like a "square within a shape" unless we use it as the entire icon.
> I will assume you want the logo centered in the icon.

> [!WARNING]
> **Existing WebP Files**: I will be deleting the existing `ic_launcher.webp` and `ic_launcher_round.webp` files to ensure the new PNG icons are used without conflict.

## Proposed Changes

### Icon Assets Generation

I will use ImageMagick (`magick`) to generate the following assets:

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

### Resource Configuration

#### [MODIFY] [ic_launcher.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml)
Update to point to the new `@mipmap/ic_launcher_foreground` instead of the old XML drawable.

#### [MODIFY] [ic_launcher_round.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml)
Update similarly if needed.

#### [DELETE] Existing `.webp` icons
Remove `ic_launcher.webp` and `ic_launcher_round.webp` from all `mipmap-*` folders.

## Verification Plan

### Automated Tests
- I will run `gradlew assembleDebug` (or a similar build task) to ensure the resources are correctly processed and there are no naming conflicts.

### Manual Verification
- I will list the files in the `res` directories to confirm they are all present with correct sizes.
