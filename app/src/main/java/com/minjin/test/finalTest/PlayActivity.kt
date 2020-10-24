package com.minjin.test.finalTest

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.minjin.test.finalTest.dbModel.AppDatabase
import com.minjin.test.finalTest.dbModel.PlayResult
import kotlinx.android.synthetic.main.activity_play.*
import java.text.SimpleDateFormat
import java.util.*

class PlayActivity : AppCompatActivity() {


    var scoreCheck = false
    val currentDateTime = Calendar.getInstance().time

    var db: AppDatabase? = null
    var savedDb : List<PlayResult>? = null

    var resultTxt = "0"
    var user1: Int = 0
    var user2: Int = 0
    var com1: Int = 0
    var com2: Int = 0

    var gameResult = mutableListOf<PlayResult>()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val random = Random()


        dice_img.setOnClickListener {

            user1 = (random.nextInt(6) + 1)
            user2 = (random.nextInt(6) + 1)

            user_1_value.text = user1.toString()
            user_2_value.text = user2.toString()


            com1 = (random.nextInt(6) + 1)
            com2 = (random.nextInt(6) + 1)

            com_1_value.text = com1.toString()
            com_2_value.text = com2.toString()

            result((user1 + user2), (com1 + com2))

            scoreCheck = true

        }

        save.setOnClickListener {

            if (!scoreCheck) {
                Toast.makeText(applicationContext, "게임을 플레이 후 저장해주세요", Toast.LENGTH_SHORT).show()
            } else {
                scoreCheck = false

                val dateFormat =
                    SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA).format(currentDateTime)

                db = AppDatabase.getInstance(this)
                savedDb = db!!.resultDAO().getAll()
                if (savedDb!!.isNotEmpty()) {
                    gameResult.addAll(savedDb!!)
                }


                val resultSave = PlayResult(0 ,resultTxt, dateFormat, (user1 + user2), (com1 + com2))
                db?.resultDAO()?.insertAll(resultSave)
                gameResult.add(resultSave)


                Toast.makeText(applicationContext, "저장되었습니다", Toast.LENGTH_SHORT).show()

                Log.d("로그", "디비 조회 ${gameResult[0].result}")
                Log.d("로그", "디비 조회 ${gameResult[0].user_value}")
                Log.d("로그", "디비 조회 ${gameResult[0].com_value}")
                Log.d("로그", "디비 조회 ${gameResult[0].date}")

            }

        }


        next.setOnClickListener {

            intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)

        }


    }

    private fun result(user: Int, com: Int) {

        when {
            user > com -> {

                result_tv.text = "유저 승리"
                resultTxt = "승"

            }
            user < com -> {

                result_tv.text = "컴퓨터 승리"
                resultTxt = "패"


            }
            else -> {

                result_tv.text = "무승부"
                resultTxt = "무"
            }
        }

    }

}