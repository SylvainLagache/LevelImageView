package com.lagache.sylvain.levelimageview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View

/**
 * Level ImageView with draw.
 *
 * This view is a [View].
 * Each time the view model is set, a color is selected and the view is invalidated to call the function [View.onDraw].
 */
class DrawLevelImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyle, defStyleRes) {

    companion object {
        private const val MAX_LEVEL = 5
    }

    private var paint: Paint

    private var dividerWidth: Int = 0

    private var level: Int = 0

    private var defaultColor: Int = 0

    private var levelColors: List<Int>

    init {
        dividerWidth = context.resources.getDimensionPixelOffset(R.dimen.divider_with)

        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.FILL

        defaultColor = ContextCompat.getColor(context, R.color.grey_300)
        levelColors = listOf(
            ContextCompat.getColor(context, R.color.grey_300),
            ContextCompat.getColor(context, R.color.level_1),
            ContextCompat.getColor(context, R.color.level_2),
            ContextCompat.getColor(context, R.color.level_3),
            ContextCompat.getColor(context, R.color.level_4),
            ContextCompat.getColor(context, R.color.level_5)
        )
    }

    /**
     * Set the view model to display.
     *
     * @param strength view model to display.
     */
    fun setViewModel(level: Int) {
        if (level > MAX_LEVEL) {
            throw IllegalStateException("Level not handled")
        }
        this.level = level
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas == null) {
            return
        }

        val height = height
        val width = width
        val cornerRadius = getHeight() / 2
        val rectWidth = width / MAX_LEVEL - dividerWidth

        for (i in 0 until MAX_LEVEL) {
            val start = (rectWidth + dividerWidth) * i //Start of the rect at the end of last rect + 1dp
            paint.color = if (level > i) levelColors[level] else defaultColor //Select current color (level or default)

            if (i == 0) {
                drawFirstRect(canvas, start, start + rectWidth, height, cornerRadius)
            } else if (i == MAX_LEVEL - 1) {
                drawLastRect(canvas, start, start + rectWidth, height, cornerRadius)
            } else {
                drawMiddleRect(canvas, start, (start + rectWidth), height)
            }
        }
    }

    /**
     * Draw the first rectangle
     *
     * @param canvas        canvas to draw on.
     * @param start         start of the rectangle.
     * @param end           end of the rectangle.
     * @param height        height of the rectangle.
     * @param cornerRadius  corner radius of the rectangle.
     */
    private fun drawFirstRect(canvas: Canvas, start: Int, end: Int, height: Int, cornerRadius: Int) {

        // Draw round rect.
        canvas.drawRoundRect(
            start.toFloat(), 0f, end.toFloat(), height.toFloat(),
            cornerRadius.toFloat(), cornerRadius.toFloat(), paint
        )

        //Draw rect at the end to make the right corner radius disappear.
        canvas.drawRect((end - cornerRadius).toFloat(), 0f, end.toFloat(), height.toFloat(), paint)
    }

    /**
     * Draw the middle rectangle
     *
     * @param canvas        canvas to draw on.
     * @param start         start of the rectangle.
     * @param end           end of the rectangle.
     * @param height        height of the rectangle.
     */
    private fun drawMiddleRect(canvas: Canvas, start: Int, end: Int, height: Int) {
        canvas.drawRect(start.toFloat(), 0f, end.toFloat(), height.toFloat(), paint)
    }

    /**
     * Draw the Last rectangle
     *
     * @param canvas        canvas to draw on.
     * @param start         start of the rectangle.
     * @param end           end of the rectangle.
     * @param height        height of the rectangle.
     * @param cornerRadius  corner radius of the rectangle.
     */
    private fun drawLastRect(canvas: Canvas, start: Int, end: Int, height: Int, cornerRadius: Int) {

        //Save the current canvas state (matrix and clip)
        canvas.save()

        //Limit the draw to the rect clipped
        canvas.clipRect(start, 0, end, height)

        //Draw round rect larger on the left but outside the clip
        canvas.drawRoundRect(
            start.toFloat() - cornerRadius * 2f, 0f, end.toFloat(), height.toFloat(),
            cornerRadius.toFloat(), cornerRadius.toFloat(), paint
        )

        //Restore the canvas state.
        canvas.restore()
    }
}