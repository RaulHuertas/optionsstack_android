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

        binding.optionA.setOnClickListener {
            toggleOptionA()
        }

        binding.optionB.setOnClickListener {
            toggleOptionB()
        }

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

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        return when (keyCode) {
            KeyEvent.KEYCODE_F -> {
                toggleOptionA()
                true
            }
            KeyEvent.KEYCODE_J -> {
                toggleOptionB()
                true
            }
            else -> super.onKeyUp(keyCode, event)
        }
    }

    private fun toggleOptionA() {
        isOptionAMatcha = !isOptionAMatcha
        val colorRes = if (isOptionAMatcha) R.color.matcha else R.color.white
        binding.optionA.setButtonBackgroundTint(ContextCompat.getColorStateList(this, colorRes))
    }

    private fun toggleOptionB() {
        isOptionBMaroon = !isOptionBMaroon
        val colorRes = if (isOptionBMaroon) R.color.maroon else R.color.white
        binding.optionB.setButtonBackgroundTint(ContextCompat.getColorStateList(this, colorRes))
    }
}
