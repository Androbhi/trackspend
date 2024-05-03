package com.android.trackspend.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.trackspend.data.models.Spend

@Dao
interface TrackSpendDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpend(spend: Spend)

    @Query("SELECT * FROM spends ORDER BY date DESC")
    fun getAllSpends(): List<Spend>

    @Delete
    suspend fun deleteSpend(spend: Spend)
}