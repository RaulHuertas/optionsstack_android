# Implementation Plan - Vertical Stack for Options and Back Button

This plan details the changes to `activity_main.xml` to arrange `optionsGrid` and `btnGoBack` in a vertical stack.

## Proposed Changes

### [Layout]

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)

- Introduce a `LinearLayout` with `android:id="@+id/llOptionsContainer"`, `android:orientation="vertical"`, and `android:gravity="center_horizontal"`.
- Move `optionsGrid` and `btnGoBack` into this `LinearLayout`.
- Constraint the `LinearLayout` to the start and end of the parent.
- Position the `LinearLayout` vertically between `tvKeyboardStatus` and `tvStatus` by:
    - `app:layout_constraintTop_toBottomOf="@id/tvKeyboardStatus"`
    - `app:layout_constraintBottom_toTopOf="@id/tvStatus"`
- This will center the options stack vertically in the available space above the status bar.

## Verification Plan

### Manual Verification
- Deploy the app.
- Navigate to a nested option (to make "Go back" visible).
- Verify that "Go back" appears directly below the options grid.
- Verify that both are centered horizontally.
