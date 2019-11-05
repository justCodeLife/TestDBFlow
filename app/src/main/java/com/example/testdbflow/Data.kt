package com.example.testdbflow

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.Database
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
object AppDatabase {
    const val NAME = "AppDatabase"
    const val VERSION = 1
}

@Table(name = "Users", database = AppDatabase::class)
data class User(@PrimaryKey var id: Int = 0, @Column var name: String? = null)