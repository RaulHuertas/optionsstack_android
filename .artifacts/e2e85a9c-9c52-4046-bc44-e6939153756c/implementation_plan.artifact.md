# Add "Go back" Button to UI

This plan describes adding a "Go back" button to the main screen, positioned next to the "Add Dynamic" button. This button will provide a visual way to navigate back through the options hierarchy.

## Proposed Changes

### [Layout](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)

- Add a new `Button` with id `btnGoBack`.
- Use a horizontal chain to position `btnGoBack` and `btnAddDynamic` side-by-side.
- Set initial visibility of `btnGoBack` to `gone`.

### [MainActivity](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)

#### [MODIFY] [MainActivity.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)

- In `onCreate`, set the `onClickListener` for `btnGoBack` to call `optionsStack.goBack()` and `mirrorOptions()`.
- In `mirrorOptions()`, update the visibility of `btnGoBack` based on `optionsStack.currentLevel() > 0`.

## Verification Plan

### Manual Verification
1.  Deploy the app.
2.  Verify only "Add Dynamic" is visible on the home screen.
3.  Navigate into a nested menu (e.g., "Action C").
4.  Verify that the "Go back" button appears.
5.  Click the "Go back" button and verify the UI returns to the parent menu and the button disappears.
