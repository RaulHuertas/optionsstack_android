# Implementation Plan - Dynamic Grid Option Addition

Add a button to `MainActivity` that dynamically adds new `OptionButtonView` instances into `optionsGrid`, which will be configured as a 3-column grid.

## Proposed Changes

### UI Layout

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)
- Change `optionsGrid` from `ConstraintLayout` to `android.widget.GridLayout`.
    - Set `android:columnCount="3"`.
    - Set `android:alignmentMode="alignBounds"`.
    - Set `android:useDefaultMargins="true"`.
- Add a new `Button` with ID `btnAddDynamic` at the bottom of the screen, outside `optionsGrid`.

### Activity Logic

#### [MODIFY] [MainActivity.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)
- Set up a click listener for `binding.btnAddDynamic`.
- In the listener:
    1. Instantiate `OptionButtonView`.
    2. Set layout parameters for `GridLayout`.
    3. Call `setOptionText("Dynamic")` and `setShortcutText("[dy]")`.
    4. Add the view to `binding.optionsGrid`.

> [!NOTE]
> Since `GridLayout` is used, the buttons will automatically wrap after 3 items. I will ensure they are properly sized to fit.

## Verification Plan

### Automated Tests
- `gradlew :app:assembleDebug` to ensure the build remains stable.

### Manual Verification
- Launch the app.
- Click "Add Dynamic" multiple times.
- Verify that buttons are added in a grid format with a maximum of 3 columns.
- Verify that the grid remains centered in the screen.
