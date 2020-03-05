package com.example.opslybackendtest.dto

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Builder
class MessageResponseDTO {
    var instagram: List<String>? = null
    var facebook: List<String>? = null
    var twitter: List<String>? = null

}