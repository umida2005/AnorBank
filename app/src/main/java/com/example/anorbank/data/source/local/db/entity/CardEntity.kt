package com.example.anorbank.data.source.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val pan: String,
    val expiredYear: String,
    val expiredMonth: String,
    val name: String,
    val cash: String = "200.000"
)