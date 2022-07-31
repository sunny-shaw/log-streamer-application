package com.engineerhooon.controller

import com.engineerhooon.model.Log
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class LogController {
    @MessageMapping("/log")
    @SendTo("/topic/logs")
    fun logs(@Payload log: Log) = log
}