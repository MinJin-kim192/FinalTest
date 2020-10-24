package com.minjin.test.finalTest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title_img.setOnClickListener{

            intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }
    }
}