package com.example.mytestapplication

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
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

    private var nested = false
    private var isCurrentlyInverted = false
    private var shortcutMatchingCount = 0
    private var rawShortcutText: String = ""

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.OptionButtonView,
            0, 0
        ).apply {
            try {
                binding.buttonOption.text = getString(R.styleable.OptionButtonView_optionText)
                rawShortcutText = getString(R.styleable.OptionButtonView_shortcutText) ?: ""
                optionBackgroundColor = getColor(R.styleable.OptionButtonView_optionBackgroundColor, Color.WHITE)
                optionTextColor = getColor(R.styleable.OptionButtonView_optionTextColor, Color.BLACK)
                applyColors()
                updateShortcutDisplay()
                updateContentDescription()
            } finally {
                recycle()
            }
        }
    }

    private fun applyColors() {
        binding.buttonOption.setTextColor(optionTextColor)
        updateShortcutDisplay()
        binding.nestedIndicator.setTextColor(optionTextColor)
        ViewCompat.setBackgroundTintList(binding.buttonOption, ColorStateList.valueOf(optionBackgroundColor))
        ViewCompat.setBackgroundTintList(binding.labelShortcut, ColorStateList.valueOf(optionBackgroundColor))
        ViewCompat.setBackgroundTintList(binding.nestedIndicator, ColorStateList.valueOf(optionBackgroundColor))
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
        rawShortcutText = text
        updateShortcutDisplay()
        updateContentDescription()
    }

    fun getShortcutText(): String = rawShortcutText

    fun getShortcutMatchingCount(): Int = shortcutMatchingCount

    fun setShortcutMatchingCount(count: Int) {
        shortcutMatchingCount = count.coerceIn(0, rawShortcutText.length)
        updateShortcutDisplay()
    }

    private fun updateShortcutDisplay() {
        val text = rawShortcutText
        if (text.isEmpty()) {
            binding.labelShortcut.text = ""
            return
        }

        val spannable = SpannableString(text)
        val matchEnd = shortcutMatchingCount.coerceAtMost(text.length)

        if (matchEnd > 0) {
            spannable.setSpan(
                ForegroundColorSpan(Color.RED),
                0, matchEnd,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        if (matchEnd < text.length) {
            val remainingColor = if (isCurrentlyInverted) invertColor(optionTextColor) else optionTextColor
            spannable.setSpan(
                ForegroundColorSpan(remainingColor),
                matchEnd, text.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        binding.labelShortcut.text = spannable
    }

    fun isNested(): Boolean = nested

    fun setNested(nested: Boolean) {
        this.nested = nested
        binding.nestedIndicator.visibility = if (nested) VISIBLE else GONE
    }

    private fun updateContentDescription() {
        val optionText = binding.buttonOption.text ?: ""
        val shortcutText = rawShortcutText
        binding.buttonOption.contentDescription = "$optionText, shortcut $shortcutText"
    }

    override fun setOnClickListener(l: OnClickListener?) {
        binding.buttonOption.setOnClickListener(l)
    }

    override fun performClick(): Boolean {
        return if (binding.buttonOption.performClick()) true else super.performClick()
    }

    fun toggleInversion() {
        if (isCurrentlyInverted) restoreColors() else invertColors()
    }

    fun invertColors() {
        if (isCurrentlyInverted) return
        isCurrentlyInverted = true

        val invertedBg = invertColor(optionBackgroundColor)
        val invertedText = invertColor(optionTextColor)

        binding.buttonOption.setTextColor(invertedText)
        updateShortcutDisplay()
        binding.nestedIndicator.setTextColor(invertedText)
        ViewCompat.setBackgroundTintList(binding.buttonOption, ColorStateList.valueOf(invertedBg))
        ViewCompat.setBackgroundTintList(binding.labelShortcut, ColorStateList.valueOf(invertedBg))
        ViewCompat.setBackgroundTintList(binding.nestedIndicator, ColorStateList.valueOf(invertedBg))
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
