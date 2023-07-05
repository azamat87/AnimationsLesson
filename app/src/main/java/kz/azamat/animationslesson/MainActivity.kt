package kz.azamat.animationslesson

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.CycleInterpolator
import android.view.animation.LinearInterpolator
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = findViewById<CircleView>(R.id.circle_view)
        val icon = findViewById<ImageView>(R.id.icon)

        icon.setOnClickListener {
            (icon.drawable as Animatable).start()
        }

////        1
//        val animator = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, view.width/2f, view.width/2f + 400).apply {
//            interpolator = LinearInterpolator()
//            duration = 2500
//        }

////        2
//        val animator2 = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, view.width/2f, view.width/2f - 400).apply {
//            interpolator = LinearInterpolator()
//            duration = 2500
//        }

////        3
//        val animatorSet = AnimatorSet()
//        animatorSet.playSequentially(animator, animator2)
//

        view.setOnClickListener {
//            animatorSet.start()
//            animator.start()
//            animator2.start()
//            animator3.start()
        }

//        4
//        view.setOnClickListener {
//            it.animate()
//                .setInterpolator(BounceInterpolator())
//                .setDuration(2000)
//                .translationXBy(300f)
//                .translationYBy(-400f)
//                .start()
//        }

//        5
        view.setOnClickListener {
//            it.animate()
//                .alpha(0f)
//                .setDuration(3000)
//                .start()
        }
    }
}