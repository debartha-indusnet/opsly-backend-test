package com.example.opslybackendtest.controller

import com.example.opslybackendtest.dto.MessageResponseDTO
import com.example.opslybackendtest.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController() {

    @Autowired
    var messageService: MessageService? = null

    @get:GetMapping(value = ["/"], produces = [MediaType.APPLICATION_JSON_VALUE])
    val allMessage: ResponseEntity<MessageResponseDTO>
        get() {
            val messageResponseDTO = messageService!!.allMessages
            return ResponseEntity(messageResponseDTO, HttpStatus.OK)
        }
}

