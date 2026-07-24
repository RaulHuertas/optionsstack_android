# Move Nested Indicator to Right Center

The goal is to move the `nestedIndicator` (">") from the left center to the right center of the `OptionButtonView`.

## Proposed Changes

### [app module](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app)

#### [MODIFY] [view_option_button.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/view_option_button.xml)

- Change horizontal constraints for `nestedIndicator` to align with the end (right) of `buttonOption`.
- Update margins accordingly.

```xml
    <TextView
        android:id="@+id/nestedIndicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="8dp"
        android:text="&gt;"
        android:textSize="18sp"
        android:textStyle="bold"
        android:elevation="4dp"
        app:layout_constraintBottom_toBottomOf="@id/buttonOption"
        app:layout_constraintEnd_toEndOf="@id/buttonOption"
        app:layout_constraintTop_toTopOf="@id/buttonOption"
        tools:visibility="visible"
        android:visibility="gone" />
```

#### [MODIFY] [OptionButtonView.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/OptionButtonView.kt)

- Add `setIsNested(isNested: Boolean)` to manage the indicator's visibility.
- Ensure the indicator's colors are updated during inversion.

## Verification Plan

### Manual Verification
- Render the layout or run the app.
- Programmatically set an option as "nested" and verify the `>` appears on the right side of the button.
