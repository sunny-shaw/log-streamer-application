package com.engineerhooon

import java.io.File

fun main() {
    for (counter in 1..100) {
        File("log.txt").appendText("Random text $counter\n")
    }
}