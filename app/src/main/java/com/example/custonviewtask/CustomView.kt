package com.example.custonviewtask

import android.content.Context
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


}