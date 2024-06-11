package com.example.newskmp.core.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.newskmp.db.ArticleDB
import com.example.newskmp.db.DatabaseDriverFactory

class IOSDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(ArticleDB.Schema, "launch.db")
    }
}