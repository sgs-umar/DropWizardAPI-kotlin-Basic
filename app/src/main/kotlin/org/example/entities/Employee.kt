package org.example.entities

import java.time.LocalDateTime

data class Employee(
    val employeeName: String,
    val ddMappingId: Int,
    val salary: Double,
    val allowance: Double,
    val createdOn: LocalDateTime,
    val modifiedOn: LocalDateTime,
)