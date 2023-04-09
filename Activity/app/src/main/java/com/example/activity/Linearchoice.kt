package com.example.activity

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.RadioGroup

class Linearchoice : Activity(), RadioGroup.OnCheckedChangeListener {
    private lateinit var orientation: RadioGroup
    private lateinit var gravity: RadioGroup

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_linear_choice)
        gravity = findViewById(R.id.gravity)
        gravity.setOnCheckedChangeListener(this)
        orientation = findViewById(R.id.orientation)
        orientation.setOnCheckedChangeListener(this)

    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        if (group == orientation) {
            if (checkedId == R.id.horizontal) {
                orientation.orientation = LinearLayout.HORIZONTAL
            } else {
                orientation.orientation = LinearLayout.VERTICAL
            }
        } else if (group == gravity) {
            when (checkedId) {
                R.id.left -> gravity.gravity = Gravity.LEFT
                R.id.center -> gravity.gravity = Gravity.CENTER
                R.id.right -> gravity.gravity = Gravity.RIGHT
            }
        }
    }
}