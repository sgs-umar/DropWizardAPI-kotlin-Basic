package org.example.mappers
import org.example.entities.Designation
import org.jdbi.v3.core.mapper.RowMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet
import java.sql.SQLException

class DesignationMapper : RowMapper<Designation> {
    @Throws(SQLException::class)
    override fun map(rs: ResultSet, ctx: StatementContext): Designation {
        return Designation(
            id = rs.getInt("id"),
            designationId = rs.getInt("designationid"),
            departmentId = rs.getInt("departmentid"),
            designationName = rs.getString("designationname")
        )
    }
}