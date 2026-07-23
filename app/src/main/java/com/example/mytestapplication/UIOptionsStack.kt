package com.example.mytestapplication

class UIOptionsStack {
    var options : List<UIOptions> = emptyList()
    var stackPositions: List<Int> = emptyList()
    val shortcuts: Array<String>
    var currentCommand: String = ""
    init {
        shortcuts = shortcutCharacters.flatMap { c1 ->
            shortcutCharacters.map { c2 -> "$c1$c2" }
        }.toTypedArray()
    }

    fun newCharacterPressed(newChar:Char):Int{
        currentCommand += newChar
        if (currentCommand.length == 2) {
            return shortcuts.indexOf(currentCommand)
        }
        if (currentCommand.length > 2) {
            currentCommand = ""
        }
        return -1
    }

    fun currentCommandProgress():String{
        return currentCommand
    }

    fun restartCommand(){
        currentCommand = ""
    }

    fun shortcutAtIndex(index:Int ): String {
        return shortcuts[index]
    }

    companion object {
        val shortcutCharacters = listOf(
            'f',
            'j',
            'd',
            'k',
            's',
            'l',
            'a',
            'g',
            'h',
            'r',
            'u',
            'e',
            'i',
            'w',
            'o',
            'q',
            'p',
            't',
            'y',
            'v',
            'n',
            'c',
            'm',
            'x',
            'b',
            'z'

        )
    }
}