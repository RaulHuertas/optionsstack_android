package com.example.mytestapplication

class UISimpleOption<T>(
    private val displayName: String,
    private val shortcutCharacter: Char,
    private val callback: (stack: List<Int>, context: T) -> Unit
) : UIOption() {
    override fun getDisplayText(): String = displayName
    override fun getShortcutCharacter(): Char = shortcutCharacter
    override fun nestedOptions(): Int = 0

    fun onClick(stack: List<Int>, context: T) {
        callback(stack, context)
    }
}
