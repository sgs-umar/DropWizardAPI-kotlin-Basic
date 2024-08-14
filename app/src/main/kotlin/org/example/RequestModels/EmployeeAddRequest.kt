package org.example.RequestModels

import com.fasterxml.jackson.annotation.JsonProperty

data class EmployeeAddRequest(
    @JsonProperty("employeeName")
    val employeeName: String,
    @JsonProperty("ddMappingId")
    val ddMappingId : Int,
    @JsonProperty("designationId")
    val designationId : Int,
    @JsonProperty("salary")
    val salary: Double,
)