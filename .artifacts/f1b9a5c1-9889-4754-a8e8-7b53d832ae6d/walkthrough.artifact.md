# Walkthrough - Custom Attributes for OptionButtonView

I have added custom attributes for background and text colors to `OptionButtonView`, along with setters and getters.

## Changes

### Resources

#### [attrs.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/values/attrs.xml)
- Added `optionBackgroundColor` and `optionTextColor` attributes.

### Custom View

#### [OptionButtonView.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/OptionButtonView.kt)
- **Attribute Handling**: The `init` block now reads `optionBackgroundColor` and `optionTextColor` from the layout attributes.
- **Defaults**: If no values are provided in XML, it defaults to **Black** for the background and **White** for the text (as requested).
- **Dynamic Updates**: Added `setOptionBackgroundColor`, `getOptionBackgroundColor`, `setOptionTextColor`, and `getOptionTextColor`. These setters automatically update the UI if the view is not currently in an "inverted" state.
- **Refactoring**: `restoreColors()` now uses these attribute-defined colors instead of hardcoded or captured theme defaults, ensuring consistency with the view's configured state.

## Verification Results

### Automated Tests
- Executed `:app:assembleDebug` and the build finished successfully.

### Manual Verification
- Verified that the logic in `applyColors()` correctly targets both the main button (`buttonOption`) and the shortcut label (`labelShortcut`).
