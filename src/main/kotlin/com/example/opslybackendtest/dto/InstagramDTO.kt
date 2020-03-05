package com.example.opslybackendtest.dto

import com.fasterxml.jackson.annotation.JsonInclude
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
class InstagramDTO {
    var instagramMsg: List<InstagramMsgDTO>? = null
    var errorMsg: String? = null

}