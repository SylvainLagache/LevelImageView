package com.lagache.sylvain.levelimageview

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Level image view which uses several drawables.
 *
 * This view is an [ImageView].
 * Each time the view model is set, a new drawable is set to the imageview.
 */
class SeveralDrawableLevelImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ImageView(context, attrs, defStyle, defStyleRes) {

    init {
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.layer_rect_lev_0))
    }

    /**
     * Set the view model to display.
     *
     * @param strength view model to display.
     */
    fun setViewModel(level: Int) {
        when (level) {
            1 -> {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.layer_rect_lev_1))
            }
            2 -> {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.layer_rect_lev_2))
            }
            3 -> {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.layer_rect_lev_3))
            }
            4 -> {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.layer_rect_lev_4))
            }
            5 -> {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.layer_rect_lev_5))
            }
            else -> {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.layer_rect_lev_0))
            }
        }
    }
}