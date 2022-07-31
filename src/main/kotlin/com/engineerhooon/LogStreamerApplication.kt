package com.engineerhooon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LogStreamerApplication

fun main(args: Array<String>) {
    runApplication<LogStreamerApplication>(*args)
}
