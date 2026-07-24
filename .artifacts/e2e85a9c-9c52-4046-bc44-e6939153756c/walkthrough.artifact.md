# Walkthrough: Registering Key Presses with optionsStack

I have implemented the keyboard shortcut logic in `MainActivity.kt` using `UIOptionsStack`. This allows the app to react to 2-character keyboard shortcuts.

## Changes Made

### [UIOptionsStack](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/UIOptionsStack.kt)
- Improved `newCharacterPressed` to reset the `currentCommand` buffer after a 2-character shortcut is attempted, ensuring more robust input handling.
- Added `executer` property with `getExecuter()` and `setExecuter()` methods to handle command execution.
- Added `options` property with `getOptions()` and `setOptions()` methods.
- Fixed `stackPositions` to be a `MutableList` for hierarchy tracking.
- Fixed `triggerOption` to correctly check bounds, trigger the appropriate option at the current depth, and navigate into nested sub-options.
- Added `goBack()` method to allow navigating up one level in the options hierarchy.
- **Back Navigation**: `MainActivity` now handles `ESC` and `BACKSPACE` keys to trigger `optionsStack.goBack()`, allowing users to navigate back up from nested menus.
- **"Go back" UI Button**: Added a physical "Go back" button in the top-left corner. Its visibility is automatically managed—it only appears when the user is navigated into a sub-menu.
- Cleaned up redundant `level()` method in favor of `currentLevel()`.

### [UIOptions](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/UIOptions.kt)
- Added a primary constructor to initialize `displayName`, `internalName`, and `options` members.
- Added explicit getter and setter methods for all three members.

### [OptionButtonView](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/OptionButtonView.kt)
- Overrode `performClick()` to delegate to the internal `buttonOption`, ensuring that programmatic clicks (like from keyboard shortcuts) trigger the assigned `OnClickListener`.
- Added `toggleInversion()` to simplify the action for dynamic options.

### [MainActivity](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)
- Implemented an optimized UI mirroring system for `UIOptions`.
- **Pool Allocation**: Preallocates 100 `OptionButtonView` instances in a hidden state on startup to prevent UI jank during navigation.
- **Dynamic Sync**: Added `mirrorOptions()` which synchronizes the visible buttons with the current level of the `UIOptionsStack`.
- **Navigation Support**: The UI now automatically refreshes whenever a shortcut is used to navigate into nested options.
- Implemented `UIOptionExecuter` interface and linked it to the activity as its executer.

### Layout Improvements
- Moved `labelShortcut` in `view_option_button.xml` to the bottom-center of the button for better symmetry and readability.
- Added a `nestedIndicator` (">") to `OptionButtonView` to visually identify options with sub-menus.
- Positioned the `nestedIndicator` at the right center of the button.
- Implemented `nested` state with `isNested()` and `setNested(Boolean)` in `OptionButtonView.kt`. Setting `nested` to true automatically shows the indicator.

### Layout (activity_main.xml)
- Added a `tvStatus` TextView at the bottom of the screen to serve as a status bar.
- Repositioned the "Add Dynamic" button to sit above the new status bar.

## Verification

The code builds successfully and follows the logic required to map keyboard input to dynamic UI options.

> [!TIP]
> To test this, add a few dynamic options in the app, note their shortcut labels (e.g., `[ff]`, `[fj]`), and type those characters on a connected keyboard. The corresponding button should invert its colors.
