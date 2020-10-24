package com.minjin.test.finalTest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.minjin.test.finalTest.adapter.ResultAdapter
import com.minjin.test.finalTest.dbModel.AppDatabase
import com.minjin.test.finalTest.dbModel.PlayResult
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val db = AppDatabase.getInstance(this)
        val getDb : List<PlayResult> = db!!.resultDAO().getAll()
        Log.d("로그","${getDb[0].com_value}")



        rv_result.adapter = ResultAdapter(this, getDb)

        rv_result.layoutManager = LinearLayoutManager(this)



        back_btn.setOnClickListener {
            intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }

    }
}