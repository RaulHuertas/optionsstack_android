package com.example.mytestapplication
class UIOptions(
    private var displayName: String = "",
    private var internalName: String = "",
    private var options: List<UIOptions> = emptyList()
) {
    fun getDisplayName(): String = displayName
    fun setDisplayName(name: String) {
        displayName = name
    }

    fun getInternalName(): String = internalName
    fun setInternalName(name: String) {
        internalName = name
    }

    fun getOptions(): List<UIOptions> = options
    fun setOptions(options: List<UIOptions>) {
        this.options = options
    }
    fun isNested(): Boolean{
        return options.isNotEmpty()
    }
}
