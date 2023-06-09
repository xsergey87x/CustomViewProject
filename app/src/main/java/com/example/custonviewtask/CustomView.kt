package com.example.custonviewtask

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.custonviewtask.databinding.CustomViewBinding

enum class ButtonAction {
    TURN_ON, TURN_OFF
}

typealias OnButtonsActionListener = (ButtonAction) -> Unit

class CustomView(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    desStyleRes: Int
) : ConstraintLayout(context, attrs, defStyleAttr, desStyleRes) {

    private val binding: CustomViewBinding
    private var listener: OnButtonsActionListener? = null

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0
    )

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.custom_view, this, true)
        binding = CustomViewBinding.bind(this)
        initializeAttributes(attrs, defStyleAttr, desStyleRes)
        initListeners()
    }

    private fun initializeAttributes(attrs: AttributeSet?, defStyleAttr: Int, desStyleRes: Int) {
        if (attrs == null) return
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, desStyleRes)

        with(binding) {
            val positiveButtonText =
                typedArray.getString(R.styleable.CustomView_customViewPositiveButtonText)
            setPositiveButtonText(positiveButtonText)

            val negativeButtonText =
                typedArray.getString(R.styleable.CustomView_customViewNegativeButtonText)
            setNegativeButtonText(negativeButtonText)

            val positiveButtonColour = typedArray.getColor(
                R.styleable.CustomView_customViewPositiveButtonColour,
                Color.GREEN
            )
            positiveButton.backgroundTintList = ColorStateList.valueOf(positiveButtonColour)

            val negativeButtonColour = typedArray.getColor(
                R.styleable.CustomView_customViewNegativeButtonColour,
                Color.RED
            )
            negativeButton.backgroundTintList = ColorStateList.valueOf(negativeButtonColour)

            val isSwitchOn =
                typedArray.getBoolean(R.styleable.CustomView_customViewSwitchOnState, false)
            correctSwitcherPosition(isSwitchOn)
        }
        typedArray.recycle()
    }

    private fun correctSwitcherPosition(position: Boolean) {
        when (position) {
            true -> if (!binding.switcher.isChecked) binding.switcher.toggle()
            false -> if (binding.switcher.isChecked) binding.switcher.toggle()
        }
    }

    private fun initListeners() {
        binding.positiveButton.setOnClickListener {
            this.listener?.invoke(ButtonAction.TURN_ON)
            correctSwitcherPosition(true)
        }
        binding.negativeButton.setOnClickListener {
            this.listener?.invoke(ButtonAction.TURN_OFF)
            correctSwitcherPosition(false)
        }
    }

    fun setListener(listener: OnButtonsActionListener?) {
        this.listener = listener
    }

    fun getSwitcherPosition(): Boolean {
        return binding.switcher.isChecked
    }

    fun setPositiveButtonText(namePositiveButton: String?) {
        binding.positiveButton.text = namePositiveButton ?: "Turn On"
    }

    fun setNegativeButtonText(nameNegativeButton: String?) {
        binding.negativeButton.text = nameNegativeButton ?: "Turn OFF"
    }
}