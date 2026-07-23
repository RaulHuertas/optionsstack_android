# Walkthrough: Registering Key Presses with optionsStack

I have implemented the keyboard shortcut logic in `MainActivity.kt` using `UIOptionsStack`. This allows the app to react to 2-character keyboard shortcuts.

## Changes Made

### [UIOptionsStack](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/UIOptionsStack.kt)
- Improved `newCharacterPressed` to reset the `currentCommand` buffer after a 2-character shortcut is attempted, ensuring more robust input handling.
- Added `executer` property with `getExecuter()` and `setExecuter()` methods to handle command execution.
- Fixed `stackPositions` to be a `MutableList` for hierarchy tracking.
- Fixed `triggerOption` to correctly check bounds, trigger the appropriate option at the current depth, and navigate into nested sub-options.
- Cleaned up redundant `level()` method in favor of `currentLevel()`.

### [UIOptions](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/UIOptions.kt)
- Added a primary constructor to initialize `displayName`, `internalName`, and `options` members.
- Added explicit getter and setter methods for all three members.

### [OptionButtonView](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/OptionButtonView.kt)
- Overrode `performClick()` to delegate to the internal `buttonOption`, ensuring that programmatic clicks (like from keyboard shortcuts) trigger the assigned `OnClickListener`.
- Added `toggleInversion()` to simplify the action for dynamic options.

### [MainActivity](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)
- Overrode `onKeyDown` to capture Unicode characters from key events.
- Registered these characters with `optionsStack`.
- When a valid shortcut index is returned, `performClick()` is called on the corresponding `OptionButtonView` in the `options` list.
- Added `printLog(message: String)` to update the status bar.
- Updated `addDynamicOption` to use `printLog` instead of console logging.

### Layout (activity_main.xml)
- Added a `tvStatus` TextView at the bottom of the screen to serve as a status bar.
- Repositioned the "Add Dynamic" button to sit above the new status bar.

## Verification

The code builds successfully and follows the logic required to map keyboard input to dynamic UI options.

> [!TIP]
> To test this, add a few dynamic options in the app, note their shortcut labels (e.g., `[ff]`, `[fj]`), and type those characters on a connected keyboard. The corresponding button should invert its colors.
