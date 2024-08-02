package org.example.resources

import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import org.example.services.HelloWorldServices

@Path("/hello")
class HelloWorldResources @Inject constructor(private val hwServices: HelloWorldServices) {

    @GET
    fun printHelloWorld() : String{
        return "Hii! " + hwServices.printHelloWorld();
    }
}