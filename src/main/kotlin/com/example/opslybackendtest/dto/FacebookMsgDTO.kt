package com.example.opslybackendtest.dto

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Builder
class FacebookMsgDTO {
    @JsonProperty(value = "name")
    var name: String? = null
    @JsonProperty(value = "status")
    var status: String? = null

}