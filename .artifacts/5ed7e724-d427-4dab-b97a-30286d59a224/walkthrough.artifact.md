# Walkthrough - Reusable Option Button

I have refactored the buttons in `MainActivity` into a reusable custom view component called `OptionButtonView`. This improves code maintainability and allows for easier addition of new options in the future.

## Changes Made

### Custom View Component

#### [NEW] [attrs.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/values/attrs.xml)
- Defined custom attributes `optionText` and `shortcutText` for the `OptionButtonView`.

#### [NEW] [view_option_button.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/view_option_button.xml)
- Created a layout using `<merge>` that contains a `Button` and a `TextView` for the shortcut label, maintaining the original design.

#### [NEW] [OptionButtonView.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/OptionButtonView.kt)
- Implemented the `OptionButtonView` class which extends `ConstraintLayout`.
- Handled attribute parsing and exposed methods like `setButtonBackgroundTint` and `setOnClickListener`.

### Activity Refactoring

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)
- Replaced the manual `Button` and `TextView` pairs with two instances of `OptionButtonView`.
- Configured them using the new custom attributes.

#### [MODIFY] [MainActivity.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)
- Updated the binding logic to interact with `OptionButtonView` objects instead of raw `Button` objects.

## Verification Results

### Automated Tests
- Ran `gradlew :app:assembleDebug`: **SUCCESS**

### Manual Verification
- Verified the layout structure in `activity_main.xml` correctly uses the custom view.
- Confirmed the logic in `MainActivity.kt` correctly toggles colors via the custom view's methods.
