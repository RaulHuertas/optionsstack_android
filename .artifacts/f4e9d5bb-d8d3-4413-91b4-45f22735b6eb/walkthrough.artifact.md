# Keyboard Connection Status Feature

I have implemented a real-time keyboard connection status label at the top of the `MainActivity`.

## Changes Made

### UI Enhancements
- Added a `TextView` (`tvKeyboardStatus`) at the top of [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml).
- Adjusted the layout so the options grid remains centered but below the status label.

### System Configuration
- Updated [AndroidManifest.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/AndroidManifest.xml) to include `android:configChanges="keyboard|keyboardHidden"`. This prevents the activity from restarting when a keyboard is plugged in or unplugged.

### Detection Logic
- Implemented real-time keyboard detection in [MainActivity.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt) using `InputManager.InputDeviceListener`.
- The `updateKeyboardStatus()` method iterates through connected input devices to check for physical keyboards (`SOURCE_KEYBOARD` and `KEYBOARD_TYPE_ALPHABETIC`).

## Verification Results

> [!NOTE]
> The implementation uses `InputManager` to ensure real-time updates when devices are connected or disconnected.

- **Status Label**: Displays "Keyboard Connected" when a physical keyboard is detected and "No Keyboard Connected" otherwise.
- **Persistence**: The listener is registered in `onCreate` and properly unregistered in `onDestroy` to prevent memory leaks.
