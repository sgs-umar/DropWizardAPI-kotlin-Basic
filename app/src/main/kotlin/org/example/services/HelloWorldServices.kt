package org.example.services

import jakarta.inject.Inject
import org.example.Constants.DesignationConstants
import org.example.RequestModels.EmployeeAddRequest
import org.example.data.HelloWorldDao
import org.example.entities.Department
import org.example.entities.Designation
import org.example.entities.Employee
import org.jdbi.v3.core.Jdbi
import java.time.LocalDateTime

class HelloWorldServices @Inject constructor(private val jdbi: Jdbi) {

    private val db: HelloWorldDao = jdbi.onDemand(HelloWorldDao::class.java)

    fun printHelloWorld(): String {
        return db.printHelloWorld()
    }

    fun getDepartments(): List<Department> {
        return db.getDepartments()
    }

    fun getDesignationsByDepartmentId(id: Int): List<Designation> {
        return db.getDesignationsByDepartmentId(id);
    }

    fun insertEmployee(request: EmployeeAddRequest): Int {
        val allowance: Double = if (request.designationId == DesignationConstants.MANAGER)  request.salary * 0.2 else request.salary * 0.1;
        val employee = Employee(
            employeeName = request.employeeName,
            ddMappingId = request.ddMappingId,
            allowance = allowance,
            salary = request.salary + allowance,
            createdOn = LocalDateTime.now(),
            modifiedOn = LocalDateTime.now()
        );
        return db.insertEmployee(employee)
    }

}