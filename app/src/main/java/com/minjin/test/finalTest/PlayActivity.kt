package com.minjin.test.finalTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_play.*
import java.util.*

class PlayActivity : AppCompatActivity() {


    var scoreCheck = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val random = Random()
        var user1: Int = 0
        var user2: Int = 0

        var com1: Int = 0
        var com2: Int = 0

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

            if(!scoreCheck){
                Toast.makeText(applicationContext,"게임을 플레이 후 저장해주세요", Toast.LENGTH_SHORT).show()
            } else {
                scoreCheck = false
                Toast.makeText(applicationContext, "저장되었습니다", Toast.LENGTH_SHORT).show()
                // 저장 해야 할 것
                // 주사위 각각의 값
                // 승패
                // 오늘 날짜
                
            }

        }


    }

    private fun result(user: Int, com: Int) {

        when {
            user > com -> {

                result_tv.text = "유저 승리"

            }
            user < com -> {

                result_tv.text = "컴퓨터 승리"


            }
            else -> {

                result_tv.text = "무승부"

            }
        }

    }

}