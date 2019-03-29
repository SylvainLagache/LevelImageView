package com.lagache.sylvain.levelimageview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main activity.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        level_seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                several_drawable_level_imageview.setViewModel(i)
                several_imageveiw_level_imageview.setViewModel(i)
                level_drawable_level_imageview.setViewModel(i)
                draw_level_imageview.setViewModel(i)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //Nothing to do
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //Nothing to do
            }
        })
    }
}
