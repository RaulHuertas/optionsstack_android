package com.example.mytestapplication

class UIOptionsStack {
    var options : List<UIOptions> = emptyList()
    val stackPositions = mutableListOf<Int>()
    val shortcuts: Array<String>

    var currentCommand: String = ""

    private var executer: UIOptionExecuter? = null

    fun getExecuter(): UIOptionExecuter? = executer

    fun setExecuter(executer: UIOptionExecuter) {
        this.executer = executer
    }

    init {
        shortcuts = shortcutCharacters.flatMap { c1 ->
            shortcutCharacters.map { c2 -> "$c1$c2" }
        }.toTypedArray()
    }

    fun newCharacterPressed(newChar: Char): Int {
        currentCommand += newChar
        if (currentCommand.length == 2) {
            val index = shortcuts.indexOf(currentCommand)
            currentCommand = ""
            return index
        }
        return -1
    }

    fun currentLevel():Int{
        return stackPositions.size
    }
    fun currentOptionsAtLevel(level:Int): List<UIOptions>{
        var result: List<UIOptions> =  options
        var levelCounter = 0
        while(levelCounter<level){
            result = result[stackPositions[levelCounter]].getOptions()
            levelCounter++
        }
        return result
    }

    fun currentOptions(): List<UIOptions>{
        return currentOptionsAtLevel(currentLevel())
    }

    fun triggerOption(index: Int) {
        val currentOptions = currentOptions()
        if (index < 0 || index >= currentOptions.size) {
            return
        }
        val selectedOption = currentOptions[index]
        executer?.call_option(selectedOption.getInternalName())
        if (selectedOption.isNested()) {
            stackPositions.add(index)
        }
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