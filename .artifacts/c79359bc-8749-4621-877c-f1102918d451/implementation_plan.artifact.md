# Implementation Plan - Center optionsGrid in activity_main.xml

Modify `activity_main.xml` to ensure `optionsGrid` is centered between `btnGoBack` and `tvStatus`.

## Proposed Changes

### Layout

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)
- Update `optionsGrid` constraints:
    - Set `app:layout_constraintTop_toBottomOf="@id/btnGoBack"`.
    - Set `app:layout_constraintBottom_toTopOf="@id/tvStatus"`.
    - Keep `app:layout_constraintStart_toStartOf="parent"` and `app:layout_constraintEnd_toEndOf="parent"`.
    - Remove `app:layout_constraintTop_toBottomOf="@id/tvKeyboardStatus"`.

## Verification Plan

### Manual Verification
- Render the layout preview to verify that `optionsGrid` is vertically centered between the "Go back" button and the status bar at the bottom.
