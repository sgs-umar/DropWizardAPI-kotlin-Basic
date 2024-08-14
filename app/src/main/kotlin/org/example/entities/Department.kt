package org.example.entities

import java.time.LocalDateTime

data class Department(
    val departmentId: Int,
    val departmentName: String,
    val createdOn: LocalDateTime,
    val modifiedOn: LocalDateTime,
    val createdBy: String,
    val modifiedBy: String
)