package com.example.dynamicview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.cardview.widget.CardView

class CardViewCustum :CardView {

    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //canvas.
    }

}

