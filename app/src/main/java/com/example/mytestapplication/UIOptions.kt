package com.example.mytestapplication

class UIOptions(
    val options: List<UIOption>
) {
    val associations: Map<UIOption, String> = options.associateWith { "" }

}
