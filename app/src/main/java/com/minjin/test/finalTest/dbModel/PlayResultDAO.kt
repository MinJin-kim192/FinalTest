package com.minjin.test.finalTest.dbModel

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlayResultDAO {

    @Query("SELECT * FROM resultModel")
    fun getAll() : List<PlayResult>

    @Insert
    fun insertAll(vararg playResult : PlayResult)

    @Delete
    fun delete(playResult: PlayResult)


}