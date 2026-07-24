# Walkthrough - Center optionsGrid in activity_main.xml

The `optionsGrid` has been re-constrained to ensure it is always centered vertically between the "Go back" button and the status text view.

## Changes

### Layout

#### [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)
- Changed `app:layout_constraintTop_toBottomOf` from `@id/tvKeyboardStatus` to `@id/btnGoBack`.
- Added `app:layout_constraintBottom_toTopOf="@id/tvStatus"`.

This creates a vertical constraint chain between `btnGoBack` and `tvStatus`, and because `optionsGrid` is the only element in that chain (or rather, constrained between them with `packed` style potentially influencing it, though here it just centers it in the available space), it will remain centered in the gap.

## Verification Results

### Manual Verification
- The constraints now correctly reference `btnGoBack` (top) and `tvStatus` (bottom) while maintaining horizontal centering.
