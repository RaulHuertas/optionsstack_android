# Implementation Plan - Vertical Stack for Options

The user wants to organize `optionsGrid` and `btnGoBack` in `activity_main.xml` into a vertical stack, while ensuring no other elements are affected.

## Proposed Changes

### [Layout]

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)

- Update `btnGoBack` constraints to position it directly below `optionsGrid`.
- Ensure `btnGoBack` is centered horizontally (like `optionsGrid`).
- Remove the top constraint of `btnGoBack` that points to the parent top.
- This creates a vertical stack: `tvKeyboardStatus` -> `optionsGrid` -> `btnGoBack`.

## Verification Plan

### Manual Verification
- Deploy the app and verify that the options grid and the "Go back" button (when visible) are stacked vertically.
- Ensure `tvKeyboardStatus` remains at the top and `tvStatus` at the bottom.
- Verify that "Go back" button visibility works as expected (it should only show when in nested options).
