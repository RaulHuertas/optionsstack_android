# Walkthrough - Dynamic 3-Column Grid for Options

I have updated the layout and logic to support a dynamic grid of option buttons, limited to 3 columns.

## Changes Made

### UI Layout Updates

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)
- Replaced the nested `ConstraintLayout` for `optionsGrid` with a `android.widget.GridLayout`.
- Configured `GridLayout` with `android:columnCount="3"` and `android:useDefaultMargins="true"`.
- Added a "Add Dynamic" button (`btnAddDynamic`) below the grid.
- Used a new dimension resource `@dimen/option_button_width` for consistent button widths.

#### [NEW] [dimens.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/values/dimens.xml)
- Defined `option_button_width` as `150dp`.

### Activity Logic Updates

#### [MODIFY] [MainActivity.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)
- Added a click listener for `btnAddDynamic`.
- Implemented `addDynamicOption()` which:
    - Instantiates a new `OptionButtonView`.
    - Sets its width using the shared dimension.
    - Configures it with "Dynamic" text and "[dy]" shortcut.
    - Adds it to the `GridLayout`.

```kotlin
private fun addDynamicOption() {
    val dynamicOption = OptionButtonView(this).apply {
        layoutParams = android.widget.GridLayout.LayoutParams().apply {
            width = resources.getDimensionPixelSize(R.dimen.option_button_width)
            height = android.widget.GridLayout.LayoutParams.WRAP_CONTENT
        }
        setOptionText("Dynamic")
        setShortcutText("[dy]")
    }
    binding.optionsGrid.addView(dynamicOption)
}
```

## Verification Results

### Automated Tests
- Ran `gradlew :app:assembleDebug`: **SUCCESS**

### Manual Verification
- Verified the `GridLayout` structure correctly wraps items after 3 columns.
- Confirmed that clicking "Add Dynamic" injects new buttons into the centered grid.
- Confirmed that the `btnAddDynamic` button stays positioned below the grid.
