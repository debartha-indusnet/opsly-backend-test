package com.example.opslybackendtest.dto

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Builder
class InstagramMsgDTO {
    @JsonProperty(value = "username")
    var username: String? = null
    @JsonProperty(value = "picture")
    var picture: String? = null

}