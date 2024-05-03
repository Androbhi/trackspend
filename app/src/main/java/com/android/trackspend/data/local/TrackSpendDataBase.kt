package com.android.trackspend.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.trackspend.data.models.Spend

@Database(
    entities = [Spend::class],
    version = 1
)
abstract class TrackSpendDataBase: RoomDatabase() {
    abstract fun trackSpendDao(): TrackSpendDao
}