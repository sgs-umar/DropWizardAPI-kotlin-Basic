package org.example

import io.dropwizard.core.Application
import io.dropwizard.core.setup.Bootstrap
import io.dropwizard.core.setup.Environment
import io.dropwizard.jdbi3.JdbiFactory
import jakarta.servlet.DispatcherType
import org.eclipse.jetty.servlets.CrossOriginFilter
import org.example.resources.HelloWorldResources
import org.example.services.HelloWorldServices
import java.util.*

class APIApplication : Application<APIConfiguration>() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            APIApplication().run(*args)
        }
    }

    override fun run(config: APIConfiguration, env: Environment) {
        val cors = env.servlets().addFilter("CORS", CrossOriginFilter::class.java)
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*") // Replace with your React app's URL
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin")
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD")
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType::class.java), true, "/*")

        val factory = JdbiFactory()
        val jdbi = factory.build(env, config.database, "postgresql")
        val helloWorldService = HelloWorldServices(jdbi)

        env.jersey().register(HelloWorldResources(helloWorldService))
    }

    override fun initialize(bootstrap: Bootstrap<APIConfiguration>?) {
        super.initialize(bootstrap)
    }
}