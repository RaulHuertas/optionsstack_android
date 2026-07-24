# Keyboard and Mouse Navigation Demo

This is an example of how to create a UI that can be navigated with a keyboard and a touch display as well.

## Features
- **Hybrid Navigation**: Interact with the UI using standard touch gestures or keyboard shortcuts.
- **Dynamic Shortcuts**: Option buttons display keyboard shortcuts that adapt based on the current context.
- **Shortcut Highlighting**: As you type on the keyboard, matching shortcuts are highlighted in real-time using `SpannableString`.
- **Nested Options**: Supports hierarchical navigation levels (drill-down menus).
- **Scrollable Interface**: A scrollable grid ensures the UI remains functional even with a large number of options.
- **Device Awareness**: Automatically detects and displays the status of connected hardware keyboards.

## How it Works
- The app uses a `UIOptionsStack` to manage nested levels of navigation.
- Keyboard input is captured via `onKeyUp` in `MainActivity`, which triggers logical actions or updates the visual state of the shortcuts.
- `OptionButtonView` is a custom component that handles both the display of the action and its associated keyboard shortcut.
