package com.android.trackspend.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spends")
data class Spend(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val category: String,
    val amount: Double,
    val date: Long,
    val particulars: List<Particular>
)

data class Particular(
    val name: String,
    val amount: Double,
)