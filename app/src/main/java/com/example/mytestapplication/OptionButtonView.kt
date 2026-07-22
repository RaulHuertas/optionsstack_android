package com.example.mytestapplication

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mytestapplication.databinding.ViewOptionButtonBinding

class OptionButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewOptionButtonBinding =
        ViewOptionButtonBinding.inflate(LayoutInflater.from(context), this)

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.OptionButtonView,
            0, 0
        ).apply {
            try {
                binding.buttonOption.text = getString(R.styleable.OptionButtonView_optionText)
                binding.labelShortcut.text = getString(R.styleable.OptionButtonView_shortcutText)
            } finally {
                recycle()
            }
        }
    }

    fun setOptionText(text: String) {
        binding.buttonOption.text = text
    }

    fun setShortcutText(text: String) {
        binding.labelShortcut.text = text
    }

    override fun setOnClickListener(l: OnClickListener?) {
        binding.buttonOption.setOnClickListener(l)
    }

    fun setButtonBackgroundTint(colorStateList: ColorStateList?) {
        binding.buttonOption.backgroundTintList = colorStateList
    }
}
