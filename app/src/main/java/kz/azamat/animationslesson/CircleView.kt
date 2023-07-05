package kz.azamat.animationslesson

import android.animation.ArgbEvaluator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator

class CircleView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet ?= null,
    defStyleAttr: Int = 0
) : View(context, attr, defStyleAttr){

    private val paint = Paint().apply {
        color = Color.BLUE
        strokeWidth = 2f
    }

    private var radius = 80f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
//        setOnClickListener {
//            animationWithHolder()
//        }
    }

//1
    private fun startAnimation() {

        ValueAnimator.ofFloat(80f, 300f).apply {
            duration = 3000
            interpolator = AccelerateInterpolator()
            addUpdateListener {
                val animatedValue = it.animatedValue as Float
                radius = animatedValue
                invalidate()
            }
            start()
        }
    }

//2
//    private fun colorAnimation() {
//        ValueAnimator.ofObject(ArgbEvaluator(), Color.CYAN, Color.BLUE, Color.MAGENTA).apply {
//            duration = 4000
//            interpolator = DecelerateInterpolator()
//            addUpdateListener {
//                val animatedValue = it.animatedValue as Int
//                paint.color = animatedValue
//                invalidate()
//            }
//            start()
//        }
//    }

//3
    private fun animationWithHolder() {
        val colorHolder = PropertyValuesHolder.ofObject("color", ArgbEvaluator(), Color.CYAN, Color.BLUE, Color.MAGENTA)
        val radiusHolder = PropertyValuesHolder.ofFloat("radius", 80f, 320f, 240f)

        ValueAnimator.ofPropertyValuesHolder(colorHolder, radiusHolder).apply {
            duration = 2000
            interpolator = DecelerateInterpolator()
            addUpdateListener {
                val colorValue = it.getAnimatedValue("color") as Int
                val radiusValue = it.getAnimatedValue("radius") as Float
                paint.color = colorValue
                radius = radiusValue
                invalidate()
            }

            start()
        }

    }
}