package com.example.opslybackendtest.dto

import com.example.opslybackendtest.dto.TwitterMsgDTO
import com.fasterxml.jackson.annotation.JsonInclude
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
class TwitterDTO {
    var twitterMsg: List<TwitterMsgDTO>? = null
    var errorMsg: String? = null

}