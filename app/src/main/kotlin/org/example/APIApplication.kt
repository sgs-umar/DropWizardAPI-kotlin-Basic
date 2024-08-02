package org.example

import io.dropwizard.core.Application
import io.dropwizard.core.setup.Bootstrap
import io.dropwizard.core.setup.Environment
import io.dropwizard.jdbi3.JdbiFactory

import org.example.resources.HelloWorldResources
import org.example.services.HelloWorldServices

class APIApplication : Application<APIConfiguration>() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            APIApplication().run(*args)
        }
    }

    override fun run(config: APIConfiguration, env: Environment) {
        val factory = JdbiFactory()
        val jdbi = factory.build(env, config.database, "postgresql")
//        val helloWorldData = HelloWorldData(jdbi)
        val helloWorldService = HelloWorldServices(jdbi)
        env.jersey().register(HelloWorldResources(helloWorldService))
    }

    override fun initialize(bootstrap: Bootstrap<APIConfiguration>?) {
        super.initialize(bootstrap)
    }
}