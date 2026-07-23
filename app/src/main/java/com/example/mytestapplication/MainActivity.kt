package com.example.mytestapplication

import android.content.Context
import android.hardware.input.InputManager
import android.os.Bundle
import android.view.InputDevice
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mytestapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isOptionAMatcha = false
    private var isOptionBMaroon = false
    private val optionsStack = UIOptionsStack()
    private val options = ArrayList<OptionButtonView>()

    private val inputDeviceListener = object : InputManager.InputDeviceListener {
        override fun onInputDeviceAdded(deviceId: Int) = updateKeyboardStatus()
        override fun onInputDeviceRemoved(deviceId: Int) = updateKeyboardStatus()
        override fun onInputDeviceChanged(deviceId: Int) = updateKeyboardStatus()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.optionA.visibility = View.GONE
        binding.optionB.visibility = View.GONE

        binding.btnAddDynamic.setOnClickListener {
            addDynamicOption()
        }

        val inputManager = getSystemService(INPUT_SERVICE) as InputManager
        inputManager.registerInputDeviceListener(inputDeviceListener, null)
        updateKeyboardStatus()
    }

    override fun onDestroy() {
        super.onDestroy()
        val inputManager = getSystemService(INPUT_SERVICE) as InputManager
        inputManager.unregisterInputDeviceListener(inputDeviceListener)
    }

    private fun updateKeyboardStatus() {
        var isKeyboardConnected = false
        val deviceIds = InputDevice.getDeviceIds()
        for (id in deviceIds) {
            val device = InputDevice.getDevice(id)
            if (device != null) {
                val sources = device.sources
                // Check for full keyboard support
                if ((sources and InputDevice.SOURCE_KEYBOARD) == InputDevice.SOURCE_KEYBOARD &&
                    device.keyboardType == InputDevice.KEYBOARD_TYPE_ALPHABETIC
                ) {
                    isKeyboardConnected = true
                    break
                }
            }
        }
        binding.tvKeyboardStatus.text = if (isKeyboardConnected) {
            "Keyboard Connected"
        } else {
            "No Keyboard Connected"
        }
    }

    private fun addDynamicOption() {
        val index = options.size
        val dynamicOption = OptionButtonView(this).apply {
            layoutParams = android.widget.GridLayout.LayoutParams().apply {
                width = resources.getDimensionPixelSize(R.dimen.option_button_width)
                height = android.widget.GridLayout.LayoutParams.WRAP_CONTENT
            }
            setOptionText("Dynamic $index")
            setShortcutText("[${optionsStack.shortcutAtIndex(index)}]")
            setOnClickListener {
                printLog("Option clicked: $index")
            }
        }
        binding.optionsGrid.addView(dynamicOption)
        options.add(dynamicOption)
    }

    private fun printLog(message: String) {
        binding.tvStatus.text = message
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        event?.let {
            val unicodeChar = it.getUnicodeChar(it.metaState)
            if (unicodeChar != 0) {
                val char = unicodeChar.toChar()
                val index = optionsStack.newCharacterPressed(char)
                if (index != -1 && index < options.size) {
                    options[index].performClick()
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        /*
        return when (keyCode) {
            KeyEvent.KEYCODE_R -> {
                binding.optionA.restoreColors()
                true
            }
            KeyEvent.KEYCODE_U -> {
                binding.optionB.restoreColors()
                true
            }
            else -> super.onKeyUp(keyCode, event)
        }
        */
        return super.onKeyUp(keyCode, event)
    }

}
