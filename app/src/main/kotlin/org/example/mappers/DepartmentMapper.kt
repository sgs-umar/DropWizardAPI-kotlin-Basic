package org.example.mappers
import org.example.entities.Department
import org.jdbi.v3.core.mapper.RowMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet
import java.sql.SQLException

class DepartmentMapper : RowMapper<Department> {
    @Throws(SQLException::class)
    override fun map(rs: ResultSet, ctx: StatementContext): Department {
        return Department(
            departmentId = rs.getInt("departmentid"),
            departmentName = rs.getString("departmentname"),
            createdOn = rs.getTimestamp("createdon").toLocalDateTime(),
            modifiedOn = rs.getTimestamp("modifiedon").toLocalDateTime(),
            createdBy = rs.getString("createdby"),
            modifiedBy = rs.getString("modifiedby")
        )
    }
}
