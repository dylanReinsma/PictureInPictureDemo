package com.dylanreinsma.pictureinpicturedemo

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun pip(view : View) {
        enterPictureInPictureMode()
    }

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration?
    ) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)

        var textView = findViewById<TextView>(R.id.textView)
        var button = findViewById<Button>(R.id.button)

        if (isInPictureInPictureMode) {
            //GOING IN
            textView.setText("PiP True")
            button.visibility = View.INVISIBLE
            supportActionBar?.hide()
        } else {
            //GOING OUT
            textView.setText("Full Screen True")
            button.visibility = View.VISIBLE
            supportActionBar?.show()
        }
    }
}
