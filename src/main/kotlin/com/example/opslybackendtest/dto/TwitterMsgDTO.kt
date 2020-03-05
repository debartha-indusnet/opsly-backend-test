package com.example.opslybackendtest.dto

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Builder
class TwitterMsgDTO {
    @JsonProperty(value = "username")
    var name: String? = null
    @JsonProperty(value = "tweet")
    var tweet: String? = null

}