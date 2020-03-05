package com.example.opslybackendtest.service

import com.example.opslybackendtest.dto.MessageResponseDTO

interface MessageService {
    val allMessages: MessageResponseDTO
}