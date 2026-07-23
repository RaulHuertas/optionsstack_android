# Mirror UIOptions to UI Buttons (Optimized)

This plan implements a more efficient mirroring system in `MainActivity.kt` that uses a preallocated pool of `OptionButtonView` components instead of recreating them on every update.

## Proposed Changes

### [MainActivity](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)

#### [MODIFY] [MainActivity.kt](file:///C:/Users/User/AndroidStudioProjects/MyTestApplication/app/src/main/java/com/example/mytestapplication/MainActivity.kt)

- **Initialization**:
    - Add a `preallocateButtons()` method called in `onCreate` that creates 100 `OptionButtonView` instances, adds them to the `optionsGrid`, sets them to `View.GONE`, and stores them in `optionsButtons`.
- **Mirroring Logic**:
    - Update `mirrorOptions()`:
        1. Get `currentOptions()` from `optionsStack`.
        2. Iterate through `optionsButtons`.
        3. For buttons at an index within `currentOptions.size`:
            - Update text, shortcut, and click listener.
            - Set visibility to `View.VISIBLE`.
        4. For buttons at an index beyond `currentOptions.size`:
            - Set visibility to `View.GONE`.
        5. If `currentOptions.size` exceeds the current `optionsButtons.size`, dynamically create and add new buttons to the pool.

```kotlin
    private fun preallocateButtons(count: Int = 100) {
        repeat(count) {
            val button = createOptionButton()
            button.visibility = View.GONE
            binding.optionsGrid.addView(button)
            optionsButtons.add(button)
        }
    }

    private fun createOptionButton(): OptionButtonView {
        return OptionButtonView(this).apply {
            layoutParams = android.widget.GridLayout.LayoutParams().apply {
                width = resources.getDimensionPixelSize(R.dimen.option_button_width)
                height = android.widget.GridLayout.LayoutParams.WRAP_CONTENT
            }
        }
    }

    private fun mirrorOptions() {
        val currentOptions = optionsStack.currentOptions()

        // Expand pool if needed
        while (optionsButtons.size < currentOptions.size) {
            val button = createOptionButton()
            binding.optionsGrid.addView(button)
            optionsButtons.add(button)
        }

        optionsButtons.forEachIndexed { index, button ->
            if (index < currentOptions.size) {
                val uiOption = currentOptions[index]
                button.apply {
                    setOptionText(uiOption.getDisplayName())
                    setShortcutText("[${optionsStack.shortcutAtIndex(index)}]")
                    setOnClickListener {
                        optionsStack.triggerOption(index)
                        if (uiOption.isNested()) {
                            mirrorOptions()
                        }
                    }
                    visibility = View.VISIBLE
                }
            } else {
                button.visibility = View.GONE
            }
        }
    }
```

## Verification Plan

### Automated Tests
- Build the project.

### Manual Verification
- Deploy the app.
- Verify initial 3 options are visible.
- Verify that triggering a sub-menu (if implemented in `UIOptions` data) updates the display without layout flickering.
- Check Logcat/Status bar for execution messages.
