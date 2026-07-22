package com.example.mytestapplication

enum class OptionsType{
    Final,
    List
}
class UIOptions{
    private var displayName: String = ""
    //When this option is selected, the stack calls the executioner with 'internalName' as parameter
    private var internalName : String = ""
    private var options: List<UIOptions> = emptyList()
}
