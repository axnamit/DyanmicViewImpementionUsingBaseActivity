package com.example.dynamicview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView

class CustumView : View {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    // Some colors for the face background, eyes and mouth.
    private var faceColor = Color.YELLOW
    private var eyesColor = Color.BLACK
    private var mouthColor = Color.BLACK
    private var borderColor = Color.BLACK

    private var shadowColor= Color.parseColor("#626BA2")
    // Face border width in pixels
    private var borderWidth = 14.0f
    // View size in pixels
    private var size = 320
    private val mouthPath = Path()

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    private fun drawMouth(canvas: Canvas?) {
        mouthPath.moveTo(size * 0.22f, size * 0.7f)
// 2
        mouthPath.quadTo(size * 0.50f, size * 0.80f, size * 0.78f, size * 0.70f)
// 3
        mouthPath.quadTo(size * 0.50f, size * 0.90f, size * 0.22f, size * 0.70f)
// 4
        paint.color = mouthColor
        paint.style = Paint.Style.FILL
// 5
        canvas?.drawPath(mouthPath, paint)
    }

    private fun drawEyes(canvas: Canvas?) {

        paint.color = eyesColor
        paint.style = Paint.Style.FILL

// 2
        val leftEyeRect = RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f)

        canvas?.drawOval(leftEyeRect, paint)

// 3
        val rightEyeRect = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)

        canvas?.drawOval(rightEyeRect, paint)
    }

    private fun drawFaceBackground(canvas: Canvas?) {
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        // 2
        val radius = size / 2f


        // 3
        canvas?.drawCircle(size / 2f, size / 2f, radius, paint)
        var rectF = RectF(10.0f, 10.0f, 10.0f, 10.0f)

        //canvas?.drawRoundRect(rectF, 10.0f, 10.0f, paint)

        //canvas?.drawRoundRect(10.0f,10.0f,10.0f,10.0f,10.0f,10.0f ,paint)

        // 4
        paint.color = shadowColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        // 5
        canvas?.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)
        //canvas?.drawRoundRect(10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, paint)
        //canvas?.drawColor(resources.getColor(R.color.design_default_color_primary_variant))
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = Math.min(measuredWidth, measuredHeight)
// 2
        setMeasuredDimension(size, size)
    }
}