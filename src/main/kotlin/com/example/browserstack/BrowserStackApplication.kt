package com.example.browserstack

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BrowserStackApplication

fun main(args: Array<String>) {
    runApplication<BrowserStackApplication>(*args)
}
