package com.lagache.sylvain.levelimageview

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Level image view which uses drawable level-list.
 *
 * This view is an [ImageView].
 * This view has a level list as drawable.
 * Each time the view model is set, [ImageView.setImageLevel] is called.
 */
class LevelDrawableLevelImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ImageView(context, attrs, defStyle, defStyleRes) {

    init {
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.level_rect))
    }

    /**
     * Set the view model to display.
     *
     * @param strength view model to display.
     */
    fun setViewModel(level: Int) {
        setImageLevel(level)
        invalidate()
    }
}