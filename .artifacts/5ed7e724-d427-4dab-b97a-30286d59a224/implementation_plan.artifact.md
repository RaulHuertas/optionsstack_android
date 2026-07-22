# Implementation Plan - Center Options in a Grid Container

Refactor `activity_main.xml` to group the two `OptionButtonView` instances within a "grid container" named `optionsGrid` and center this container in the parent layout.

## Proposed Changes

### UI Layout

#### [MODIFY] [activity_main.xml](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/res/layout/activity_main.xml)
- Introduce a new container `androidx.constraintlayout.widget.ConstraintLayout` (or `GridLayout`) with `android:id="@+id/optionsGrid"`.
- Move `optionA` and `optionB` inside `optionsGrid`.
- Constraints for `optionsGrid`:
    - `app:layout_constraintTop_toTopOf="parent"`
    - `app:layout_constraintBottom_toBottomOf="parent"`
    - `app:layout_constraintStart_toStartOf="parent"`
    - `app:layout_constraintEnd_toEndOf="parent"`
    - `android:layout_width="wrap_content"`
    - `android:layout_height="wrap_content"`
- Inside `optionsGrid`, use a `androidx.constraintlayout.helper.widget.Flow` to organize the buttons in a grid:
    - `android:id="@+id/flowGrid"`
    - `app:constraint_referenced_ids="optionA,optionB"`
    - `app:flow_maxElementsWrap="1"` (for vertical grid) or `2` (for horizontal). I will assume vertical initially to match the previous look, or side-by-side if "grid" implies columns. Given the previous code had them vertically packed, I'll start with a 2nd column or a 2x1 grid.
    - Actually, I'll just use regular constraints inside `optionsGrid` if it's a `ConstraintLayout`.

> [!NOTE]
> I will use a nested `ConstraintLayout` for `optionsGrid` to physically group the elements as requested.

## Verification Plan

### Automated Tests
- `gradlew :app:assembleDebug` to ensure XML validity and ViewBinding compatibility.

### Manual Verification
- Use `render_compose_preview` (if applicable for XML, but I'll use `take_screenshot` or just rely on layout logic) to verify centering.
- Ensure buttons remain functional in `MainActivity`.
