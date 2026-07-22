# Implementation Plan - Reusable Option Button

Refactor the manual button and label combinations in `MainActivity` into a separate reusable `OptionButtonView` component.

## Proposed Changes

### UI Components

#### [NEW] [attrs.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/values/attrs.xml)
- Define `OptionButtonView` styleable attributes:
    - `optionText` (string): The main text of the button.
    - `shortcutText` (string): The text for the shortcut label (e.g., "[F]").

#### [NEW] [view_option_button.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/view_option_button.xml)
- Create a layout that mirrors the existing button + label structure using `ConstraintLayout`.
- The `Button` and `TextView` (label) will be contained within this layout.

#### [NEW] [OptionButtonView.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/OptionButtonView.kt)
- Create a custom view class extending `ConstraintLayout`.
- Implement attribute parsing to set the button text and shortcut label.
- Expose methods to:
    - Set the button text.
    - Set the shortcut label.
    - Set a click listener.
    - Change the button's background tint.

### Main Activity Refactoring

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)
- Remove the individual `Button` and `TextView` pairs.
- Add two instances of `OptionButtonView` (one for Option A, one for Option B).
- Set the `optionText` and `shortcutText` attributes in XML.

#### [MODIFY] [MainActivity.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)
- Update the binding usages to interact with the new `OptionButtonView` instances.
- Maintain the existing toggle logic and keyboard shortcut handling.

## Verification Plan

### Automated Tests
- Run `gradlew :app:assembleDebug` to ensure the project builds with the new custom view and resource files.

### Manual Verification
- Deploy to a device/emulator.
- Verify that both buttons display the correct text and labels.
- Verify that clicking the buttons or pressing the keys ('F' and 'J') toggles the background color as before.
