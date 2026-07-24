# Implementation Plan - Change 'optionsGrid' to a Scroll Area

The user wants to make the options grid scrollable. Currently, it's a `GridLayout` directly inside a `ConstraintLayout`, which doesn't scroll if items exceed the screen height. I will wrap it in a `ScrollView`.

## Proposed Changes

### UI Layout

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)
- Wrap the `<GridLayout android:id="@+id/optionsGrid" ...>` inside a `<ScrollView>`.
- Transfer the layout constraints from the `GridLayout` to the `ScrollView`.
- Update the `GridLayout` to have `android:layout_width="wrap_content"` and `android:layout_height="wrap_content"`.
- Set the `ScrollView` to take up the available vertical space between `tvKeyboardStatus` and `tvStatus`.

## Verification Plan

### Manual Verification
- Deploy the app to a device or emulator.
- Observe that the options are now scrollable if there are many of them.
- I will verify that `preallocateButtons(100)` correctly fills the scrollable area.
