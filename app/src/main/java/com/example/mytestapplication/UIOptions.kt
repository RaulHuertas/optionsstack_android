package com.example.mytestapplication

enum class OptionsType{
    Final,
    List
}
class UIOptions{
    //This is the name to display for this function
    private var displayName: String = ""
    //When this option is selected, the stack calls the executioner with 'internalName' as parameter
    private var internalName : String = ""
    //If this option redirects us to antoher options, this should be filled with those options
    private var options: List<UIOptions> = emptyList()
}
