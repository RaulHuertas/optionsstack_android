# Register Key Presses with OptionsStack

This plan details how to capture physical key events in `MainActivity` and pass them to the `UIOptionsStack` logic to trigger shortcuts.

## Proposed Changes

### [MainActivity]

#### [MODIFY] [MainActivity.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)
- Update `onKeyDown` to:
    - Extract the character from the `KeyEvent` (using `event.unicodeChar.toChar()`).
    - Pass the character to `optionsStack.newCharacterPressed(char)`.
    - If the returned index is valid (>= 0 and < `options.size`), call a new function `onShortcutTriggered(index)`.
- [NEW] Add an empty function `onShortcutTriggered(index: Int)` that will be used to handle the action when a shortcut is successfully typed.

## Verification Plan

### Automated Tests
- Build project to ensure no syntax errors.

### Manual Verification
- Deploy the app.
- Press physical keys (USB/Bluetooth keyboard).
- Verify that typing a two-character shortcut (e.g., "ff") triggers the logic (I can add a log or breakpoint in the empty function for verification).
