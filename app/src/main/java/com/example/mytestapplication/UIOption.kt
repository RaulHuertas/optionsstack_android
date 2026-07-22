package com.example.mytestapplication

abstract class UIOption {
    abstract fun getDisplayText(): String
    abstract fun getShortcutCharacter(): Char
    abstract fun nestedOptions(): Int
}
