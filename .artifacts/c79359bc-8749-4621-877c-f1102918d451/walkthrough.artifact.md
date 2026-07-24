# Walkthrough - Fix optionsGrid movement in activity_main.xml

The `optionsGrid` position is now independent of the `btnGoBack` visibility, ensuring a stable UI layout.

## Changes

### Layout

#### [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)
- Updated `optionsGrid` constraints:
    - Changed `app:layout_constraintTop_toBottomOf="@id/btnGoBack"` to `app:layout_constraintTop_toTopOf="parent"`.
- This ensures that when `btnGoBack` is toggled between `visible` and `gone`, the `optionsGrid` does not shift vertically, as it no longer depends on the button's boundaries.

## Verification Results

### Manual Verification
- Verified that `optionsGrid` remains centered vertically relative to the entire parent container (bounded by the top and the `tvStatus` at the bottom), regardless of whether `btnGoBack` is visible or hidden.
