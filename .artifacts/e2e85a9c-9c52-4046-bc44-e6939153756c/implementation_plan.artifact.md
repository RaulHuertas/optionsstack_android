# Move "Go back" Button to Top-Left (Final)

Move the "Go back" button (`btnGoBack`) to the top-left corner of the screen in `activity_main.xml`, while leaving all other elements untouched.

## Proposed Changes

### [Layout](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)

- Update `btnGoBack` constraints:
    - Set `app:layout_constraintTop_toTopOf="parent"`.
    - Set `app:layout_constraintStart_toStartOf="parent"`.
    - Remove `app:layout_constraintEnd_toEndOf="parent"` and any `tools:layout_editor_absoluteY`.
    - Add `android:layout_margin="8dp"` for spacing.

```xml
    <Button
        android:id="@+id/btnGoBack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="8dp"
        android:text="Go back"
        android:visibility="gone"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:visibility="visible" />
```

## Verification Plan

### Manual Verification
1. Deploy the app.
2. Navigate to a nested level.
3. Verify that the "Go back" button appears in the top-left corner.
