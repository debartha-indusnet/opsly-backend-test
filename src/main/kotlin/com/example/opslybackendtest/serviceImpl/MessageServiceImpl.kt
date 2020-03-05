package com.example.opslybackendtest.serviceImpl

import com.example.opslybackendtest.dto.*
import com.example.opslybackendtest.service.MessageService
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.client.RestTemplate
import java.io.IOException

@Service
class MessageServiceImpl : MessageService {

    @Autowired
    var messageService: MessageService? = null
    /**RestTemplate for FaceBook */
    /**RestTemplate for Instagram */
    /**RestTemplate for Twitter */

    override val allMessages: MessageResponseDTO
        get() {
            val messageResponseDTO = MessageResponseDTO()
            /**RestTemplate for Twitter */
            val restTemplate = RestTemplate()
            restTemplate.errorHandler = object : ResponseErrorHandler {
                @Throws(IOException::class)
                override fun hasError(response: ClientHttpResponse): Boolean {
                    return false
                }

                @Throws(IOException::class)
                override fun handleError(response: ClientHttpResponse) {
                }
            }
            val twitterUri = "https://takehome.io/twitter"
            var responseTwitter: ResponseEntity<String?>? = null
            val twitterDTO = TwitterDTO()
            responseTwitter = restTemplate.exchange(twitterUri, HttpMethod.GET, null, String::class.java)
            try {
                val mapper = ObjectMapper()
                val twitterMsgDTO: List<TwitterMsgDTO> = mapper.readValue(responseTwitter.body, object : TypeReference<List<TwitterMsgDTO>>() {})
                twitterDTO.twitterMsg = twitterMsgDTO
            } catch (ex: Exception) {
                twitterDTO.errorMsg = responseTwitter.body
            }
            /**RestTemplate for Instagram */
            val restTemplateInstagram = RestTemplate()
            restTemplateInstagram.errorHandler = object : ResponseErrorHandler {
                @Throws(IOException::class)
                override fun hasError(response: ClientHttpResponse): Boolean {
                    return false
                }

                @Throws(IOException::class)
                override fun handleError(response: ClientHttpResponse) {
                }
            }
            val instagramUri = "https://takehome.io/instagram"
            val instagramDTO = InstagramDTO()
            var responseInstagram: ResponseEntity<String?>? = null
            responseInstagram = restTemplateInstagram.exchange(instagramUri, HttpMethod.GET, null, String::class.java)
            try {
                val mapper = ObjectMapper()
                val instagramMsgDTO: List<InstagramMsgDTO> = mapper.readValue(responseInstagram.body, object : TypeReference<List<InstagramMsgDTO>>() {})
                instagramDTO.instagramMsg = instagramMsgDTO
            } catch (ex: Exception) {
                instagramDTO.errorMsg = responseInstagram.body
            }
            /**RestTemplate for FaceBook */
            val restTemplateFaceBook = RestTemplate()
            restTemplateFaceBook.errorHandler = object : ResponseErrorHandler {
                @Throws(IOException::class)
                override fun hasError(response: ClientHttpResponse): Boolean {
                    return false
                }

                @Throws(IOException::class)
                override fun handleError(response: ClientHttpResponse) {
                }
            }
            val faceBookUri = "https://takehome.io/facebook"
            val facebookDTO = FacebookDTO()
            var responseFaceBook: ResponseEntity<String?>? = null
            responseFaceBook = restTemplate.exchange(faceBookUri, HttpMethod.GET, null, String::class.java)
            try {
                val mapper = ObjectMapper()
                val facebookMsgDTO: List<FacebookMsgDTO> = mapper.readValue(responseFaceBook.body, object : TypeReference<List<FacebookMsgDTO>>() {})
                facebookDTO.facebookMsg = facebookMsgDTO
            } catch (ex: Exception) {
                facebookDTO.errorMsg = responseFaceBook.body
            }
            messageResponseDTO.twitter = twitterDTO.twitterMsg?.map{ it.tweet.toString() } ?: emptyList()
            messageResponseDTO.instagram = instagramDTO.instagramMsg?.map {it.picture.toString()} ?: emptyList()
            messageResponseDTO.facebook = facebookDTO.facebookMsg?.map { it.status.toString() } ?: emptyList()
            return messageResponseDTO
        }
}