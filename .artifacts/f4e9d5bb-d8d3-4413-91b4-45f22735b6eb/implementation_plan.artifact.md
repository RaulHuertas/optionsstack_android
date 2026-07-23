# Add Keyboard Connection Status Label

This plan adds a label at the top of the `MainActivity` that indicates whether a physical keyboard (USB or Bluetooth) is connected to the device.

## Proposed Changes

### [Layout]

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)
- Add a `TextView` with ID `tvKeyboardStatus` at the top of the layout.
- Constrain it to the top of the parent.
- Adjust `optionsGrid` constraints to be below this new label.

### [Manifest]

#### [MODIFY] [AndroidManifest.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/AndroidManifest.xml)
- Add `android:configChanges="keyboard|keyboardHidden"` to `MainActivity` to ensure the activity isn't recreated on keyboard connection and we can handle it manually if needed.

### [Logic]

#### [MODIFY] [MainActivity.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)
- Add a method `updateKeyboardStatus()` to check for connected input devices with keyboard capabilities.
- Register an `InputManager.InputDeviceListener` to react to device additions or removals in real-time.
- Update the status label in `onCreate`.

## Verification Plan

### Automated Tests
- Build the project to ensure no syntax errors.

### Manual Verification
- Deploy the app to a device or emulator.
- Connect/disconnect a physical keyboard (or toggle emulator keyboard).
- Verify the label updates correctly.
