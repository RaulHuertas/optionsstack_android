# Implementation Plan - Multi-colored Shortcut Highlights

The goal is to allow highlighting the first $N$ characters of the shortcut text in an `OptionButtonView` using a different color (Red). This is typically used to show how much of a keyboard shortcut the user has already typed.

## Proposed Changes

### Custom View Logic

#### [MODIFY] [OptionButtonView.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/OptionButtonView.kt)
- Add a private field `shortcutMatchingCount` initialized to 0.
- Implement `getShortcutMatchingCount()` and `setShortcutMatchingCount(count: Int)`.
- The setter will trigger a UI update to refresh the text coloring.
- Create a private method `updateShortcutDisplay()`:
    - Retrieves the current shortcut text.
    - Uses `SpannableString` to apply a `ForegroundColorSpan(Color.RED)` to the first `shortcutMatchingCount` characters.
    - Applies `ForegroundColorSpan(optionTextColor)` (or `Color.BLACK` per request) to the remaining characters.
    - Sets the resulting spannable string to `binding.labelShortcut`.
- Update `setShortcutText()` to call `updateShortcutDisplay()` instead of setting the text directly.
- Update `applyColors()`, `invertColors()`, and `restoreColors()` to ensure the "remaining" color stays consistent with the rest of the button's theme (or the requested black).

> [!NOTE]
> I will use `optionTextColor` for the "black" part to ensure it respects the view's existing `optionTextColor` property, which is black by default but can be changed. If you strictly want `Color.BLACK`, let me know.

## Verification Plan

### Manual Verification
- I will verify the logic by temporarily setting a non-zero match count in `MainActivity.kt` or by inspecting the code.
- Ensure that if `shortcutMatchingCount` is greater than the text length, it doesn't crash (clamping).
- Verify that `invertColors` still works (though the Red highlight will likely remain Red, which is standard for "error/match" highlights).
