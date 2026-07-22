package com.example.mytestapplication

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import com.example.mytestapplication.databinding.ViewOptionButtonBinding

class OptionButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewOptionButtonBinding =
        ViewOptionButtonBinding.inflate(LayoutInflater.from(context), this)

    private var optionBackgroundColor: Int = Color.WHITE
    private var optionTextColor: Int = Color.BLACK

    private var isCurrentlyInverted = false

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.OptionButtonView,
            0, 0
        ).apply {
            try {
                binding.buttonOption.text = getString(R.styleable.OptionButtonView_optionText)
                binding.labelShortcut.text = getString(R.styleable.OptionButtonView_shortcutText)
                optionBackgroundColor = getColor(R.styleable.OptionButtonView_optionBackgroundColor, Color.WHITE)
                optionTextColor = getColor(R.styleable.OptionButtonView_optionTextColor, Color.BLACK)
                applyColors()
                updateContentDescription()
            } finally {
                recycle()
            }
        }
    }

    private fun applyColors() {
        binding.buttonOption.setTextColor(optionTextColor)
        binding.labelShortcut.setTextColor(optionTextColor)
        ViewCompat.setBackgroundTintList(binding.buttonOption, ColorStateList.valueOf(optionBackgroundColor))
        ViewCompat.setBackgroundTintList(binding.labelShortcut, ColorStateList.valueOf(optionBackgroundColor))
    }

    fun getOptionBackgroundColor(): Int = optionBackgroundColor

    fun setOptionBackgroundColor(color: Int) {
        optionBackgroundColor = color
        if (!isCurrentlyInverted) {
            applyColors()
        }
    }

    fun getOptionTextColor(): Int = optionTextColor

    fun setOptionTextColor(color: Int) {
        optionTextColor = color
        if (!isCurrentlyInverted) {
            applyColors()
        }
    }

    fun setOptionText(text: String) {
        binding.buttonOption.text = text
        updateContentDescription()
    }

    fun setShortcutText(text: String) {
        binding.labelShortcut.text = text
        updateContentDescription()
    }

    private fun updateContentDescription() {
        val optionText = binding.buttonOption.text ?: ""
        val shortcutText = binding.labelShortcut.text ?: ""
        binding.buttonOption.contentDescription = "$optionText, shortcut $shortcutText"
    }

    override fun setOnClickListener(l: OnClickListener?) {
        binding.buttonOption.setOnClickListener(l)
    }

    fun invertColors() {
        if (isCurrentlyInverted) return
        isCurrentlyInverted = true

        val invertedBg = invertColor(optionBackgroundColor)
        val invertedText = invertColor(optionTextColor)

        binding.buttonOption.setTextColor(invertedText)
        binding.labelShortcut.setTextColor(invertedText)
        ViewCompat.setBackgroundTintList(binding.buttonOption, ColorStateList.valueOf(invertedBg))
        ViewCompat.setBackgroundTintList(binding.labelShortcut, ColorStateList.valueOf(invertedBg))
    }

    private fun invertColor(color: Int): Int {
        return Color.rgb(
            255 - Color.red(color),
            255 - Color.green(color),
            255 - Color.blue(color)
        )
    }

    fun restoreColors() {
        isCurrentlyInverted = false
        applyColors()
    }


}
