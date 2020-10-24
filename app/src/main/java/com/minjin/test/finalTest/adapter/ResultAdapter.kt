package com.minjin.test.finalTest.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.minjin.test.finalTest.R
import com.minjin.test.finalTest.dbModel.PlayResult
import kotlinx.android.synthetic.main.item_rv.view.*

class ResultAdapter(
    val context: Context,
    val resultList: List<PlayResult>
) : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false)

        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {

        holder.bind(resultList[position])

    }

    override fun getItemCount(): Int {

        return resultList.size
    }

    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var rv_bg = itemView.rv_layout
        var user: TextView = itemView.user_value
        var com: TextView = itemView.com_value
        var date: TextView = itemView.play_date
        var result: TextView = itemView.result_rv_tv


        fun bind(resultData: PlayResult) {


            if (resultData.result == "승") {
                rv_bg.setBackgroundColor(Color.rgb(143, 197, 239))

                user.setTextColor(Color.BLACK)
                com.setTextColor(Color.BLACK)
                date.setTextColor(Color.BLACK)
                result.setTextColor(Color.BLACK)

            } else if (resultData.result == "패") {
                rv_bg.setBackgroundColor(Color.rgb(250, 67, 129))
                user.setTextColor(Color.WHITE)
                com.setTextColor(Color.WHITE)
                date.setTextColor(Color.WHITE)
                result.setTextColor(Color.WHITE)

            } else {

                rv_bg.setBackgroundColor(Color.rgb(243, 226, 84))
                user.setTextColor(Color.GRAY)
                com.setTextColor(Color.GRAY)
                date.setTextColor(Color.GRAY)
                result.setTextColor(Color.GRAY)
            }


            user.text = "유저 주사위 합 ${resultData.user_value}"
            com.text = "컴퓨터 주사위 합 ${resultData.com_value}"
            date.text = resultData.date
            result.text = resultData.result


        }

    }


}