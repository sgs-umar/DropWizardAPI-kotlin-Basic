package org.example.services

import jakarta.inject.Inject
import org.example.data.HelloWorldDao
import org.jdbi.v3.core.Jdbi

class HelloWorldServices @Inject constructor(private val jdbi: Jdbi) {

    private val db:HelloWorldDao = jdbi.onDemand(HelloWorldDao::class.java)

    fun printHelloWorld() : String{
        return db.printHelloWorld()
    }
}