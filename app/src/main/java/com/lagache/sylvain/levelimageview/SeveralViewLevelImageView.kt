package com.lagache.sylvain.levelimageview

import android.content.Context
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.view_several_view_imageview.view.*

/**
 * Level image view with several image view.
 *
 * This view is a [LinearLayout] with 5 [ImageView] as children.
 * Each time the view model is set, a specific color filter is applied to all ImageView.
 */
class SeveralViewLevelImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    private var levelColor: Int = 0

    private var defaultColor: Int = 0

    init {
        LayoutInflater.from(context).inflate(R.layout.view_several_view_imageview, this)
        orientation = HORIZONTAL

        defaultColor = ContextCompat.getColor(context, R.color.grey_300)
        levelColor = defaultColor
    }

    /**
     * Set the view model to display.
     *
     * @param strength view model to display.
     */
    fun setViewModel(level: Int) {
        when (level) {
            1 -> {
                levelColor = ContextCompat.getColor(context, R.color.level_1)
                rec_1.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_2.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
                rec_3.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
                rec_4.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
                rec_5.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
            }
            2 -> {
                levelColor = ContextCompat.getColor(context, R.color.level_2)
                rec_1.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_2.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_3.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
                rec_4.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
                rec_5.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
            }
            3 -> {
                levelColor = ContextCompat.getColor(context, R.color.level_3)
                rec_1.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_2.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_3.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_4.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
                rec_5.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
            }
            4 -> {
                levelColor = ContextCompat.getColor(context, R.color.level_4)
                rec_1.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_2.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_3.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_4.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_5.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
            }
            5 -> {
                levelColor = ContextCompat.getColor(context, R.color.level_5)
                rec_1.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_2.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_3.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_4.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
                rec_5.setColorFilter(levelColor, PorterDuff.Mode.SRC_IN)
            }
            else -> {
                rec_1.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
                rec_2.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
                rec_3.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
                rec_4.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
                rec_5.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
            }
        }
    }
}