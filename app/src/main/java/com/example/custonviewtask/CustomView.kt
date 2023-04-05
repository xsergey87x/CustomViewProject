package com.example.custonviewtask

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.custonviewtask.databinding.CustomViewBinding

class CustomView(
    context: Context,
    attrs : AttributeSet?,
    defStyleAttr: Int,
    desStyleRes: Int
) : ConstraintLayout(context, attrs, defStyleAttr, desStyleRes) {

    private val binding: CustomViewBinding

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?): this(context,attrs,0)
    constructor(context: Context): this(context, null)


    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.custom_view,this,true)
        binding = CustomViewBinding.bind(this)
    }

 private fun initializeAttributes(attrs: AttributeSet?,defStyleAttr: Int,desStyleRes: Int)
 {
     if (attrs == null) return
     val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr,desStyleRes)

     with(binding){
         val positiveButtonText = typedArray.getString(R.styleable.CustomView_customViewPositiveButtonText)
         positiveButton.text = positiveButtonText ?: "Turn on"

         val negativeButtonText = typedArray.getString(R.styleable.CustomView_customViewNegativeButtonText)
         negativeButton.text = negativeButtonText ?: "Turn off"

         val positiveButtonColour = typedArray.getColor(R.styleable.CustomView_customViewPositiveButtonColour, Color.GREEN)
         positiveButton.backgroundTintList = ColorStateList.valueOf(positiveButtonColour)

         val negativeButtonColour = typedArray.getColor(R.styleable.CustomView_customViewNegativeButtonColour, Color.RED)
         negativeButton.backgroundTintList= ColorStateList.valueOf(negativeButtonColour)
     }

     typedArray.recycle()
 }
}