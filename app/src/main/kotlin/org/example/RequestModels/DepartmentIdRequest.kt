package org.example.RequestModels

import com.fasterxml.jackson.annotation.JsonProperty

data class DepartmentIdRequest(
    @JsonProperty("id")
    val id: Int
)