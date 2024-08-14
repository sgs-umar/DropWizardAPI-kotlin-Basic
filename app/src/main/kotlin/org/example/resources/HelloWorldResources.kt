package org.example.resources

import jakarta.inject.Inject
import org.example.entities.Department
import org.example.services.HelloWorldServices
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.example.RequestModels.DepartmentIdRequest
import org.example.RequestModels.EmployeeAddRequest
import org.example.entities.Designation

@Path("/api")
class HelloWorldResources @Inject constructor(private val hwServices: HelloWorldServices) {

    @GET
    @Path("/test")
    fun printHelloWorld(): String {
        return "Hii! " + hwServices.printHelloWorld()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/departments")
    fun getDepartments(): List<Department> {
        return hwServices.getDepartments();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/designations")
    fun getDesignationsByDepartmentId(request: DepartmentIdRequest): List<Designation> {
        return hwServices.getDesignationsByDepartmentId(request.id)
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add-employee")
    fun insertEmployee(request: EmployeeAddRequest): Int {
        return hwServices.insertEmployee(request)
    }
}