package com.example.newskmp.db

import app.cash.sqldelight.db.SqlDriver

interface DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

expect fun provideDatabaseDriverFactory(): DatabaseDriverFactory

