package com.minjin.test.finalTest.dbModel

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resultModel")
data class PlayResult(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name = "result")
    var result: String = "",
    @ColumnInfo(name = "date")
    var date: String? = null,
    @ColumnInfo(name = "user_value")
    var user_value: Int? = null,
    @ColumnInfo(name = "com_value")
    var com_value: Int? = null
)



