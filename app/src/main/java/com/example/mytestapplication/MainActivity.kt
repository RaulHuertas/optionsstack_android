package com.example.mytestapplication

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mytestapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isOptionAMatcha = false
    private var isOptionBMaroon = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAddDynamic.setOnClickListener {
            addDynamicOption()
        }
    }

    private fun addDynamicOption() {
        val dynamicOption = OptionButtonView(this).apply {
            layoutParams = android.widget.GridLayout.LayoutParams().apply {
                width = resources.getDimensionPixelSize(R.dimen.option_button_width)
                height = android.widget.GridLayout.LayoutParams.WRAP_CONTENT
            }
            setOptionText("Dynamic")
            setShortcutText("[dy]")
        }
        binding.optionsGrid.addView(dynamicOption)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return when (keyCode) {
            KeyEvent.KEYCODE_R -> {
                binding.optionA.invertColors()
                true
            }
            KeyEvent.KEYCODE_U -> {
                binding.optionB.invertColors()
                true
            }
            else -> super.onKeyUp(keyCode, event)
        }
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
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
    }

}
