package org.example.data

import jakarta.inject.Inject
import org.example.entities.Department
import org.example.entities.Designation
import org.example.entities.Employee
import org.example.mappers.DepartmentMapper
import org.example.mappers.DesignationMapper
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.config.RegisterRowMapper
import org.jdbi.v3.sqlobject.customizer.Bind
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

@RegisterRowMapper(DepartmentMapper::class)
@RegisterRowMapper(DesignationMapper::class)

interface HelloWorldDao{
    @SqlQuery("Select name from users")
    fun printHelloWorld(): String

    @SqlQuery("Select * from departmentmaster")
    fun getDepartments(): List<Department>

    @SqlQuery("select a.id, a.designationid, a.departmentid ,b.designationname from departdesignationmapping a\n" +
            "\tJoin designationmaster b\n" +
            "\ton a.designationid = b.designationid\n" +
            "\twhere departmentid = :depId;")
    fun getDesignationsByDepartmentId(@Bind("depId") id:Int): List<Designation>

    @SqlUpdate("INSERT INTO public.employeemaster (employeename, ddmappingid, salary, allowance, createdon, modifiedon)\n" +
            "VALUES (:employeeName, :ddMappingId, :salary, :allowance, :createdOn , :modifiedOn );")
    fun insertEmployee(@BindBean employee: Employee): Int
}