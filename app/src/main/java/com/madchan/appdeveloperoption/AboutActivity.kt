package com.madchan.appdeveloperoption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

/**
 * 关于页面
 */
class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        findViewById<TextView>(R.id.version).setOnClickListener{
            Debugger.onQuickClick(this)
        }
    }

}