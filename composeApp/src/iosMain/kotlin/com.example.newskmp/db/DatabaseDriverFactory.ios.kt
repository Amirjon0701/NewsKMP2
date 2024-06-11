package com.example.newskmp.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver


class IOSDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(ArticleDB.Schema, "articledb.db")
    }
}

actual fun provideDatabaseDriverFactory(): DatabaseDriverFactory {
    return IOSDatabaseDriverFactory()
}