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
