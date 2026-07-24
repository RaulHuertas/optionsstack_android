# Change App Name to 'Keyboard and Mouse Navigation Demo'

This plan outlines the steps to change the application's display name and the project's root name.

## Proposed Changes

### [Resources]

#### [MODIFY] [strings.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/values/strings.xml)
- Update the `app_name` string to "Keyboard and Mouse Navigation Demo".

### [Project Configuration]

#### [MODIFY] [settings.gradle.kts](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/settings.gradle.kts)
- Update `rootProject.name` to "Keyboard and Mouse Navigation Demo".

### [Documentation]

#### [MODIFY] [README.md](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/README.md)
- Update the main heading to "Keyboard and Mouse Navigation Demo".

## Verification Plan

### Automated Tests
- Run `gradlew help` to ensure the project name is correctly updated in Gradle.
- Run `gradlew assembleDebug` to ensure the app builds correctly.

### Manual Verification
- Deploy the app to a device and verify the name on the launcher and in the title bar.
