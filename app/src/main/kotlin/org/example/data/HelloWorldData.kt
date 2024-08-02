package org.example.data

import jakarta.inject.Inject
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.statement.SqlQuery

interface HelloWorldDao{
    @SqlQuery("Select name from users")
    fun printHelloWorld(): String
}