package com.engineerhooon.monitor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.io.RandomAccessFile

@Configuration
@EnableScheduling
class MonitorService(
    @Autowired
    private val messagingTemplate: SimpMessagingTemplate
) {
    private val randomAccessFile = RandomAccessFile("log.txt", "rw")
    private var lastReadPosition = 0L

//    init {
//        lastReadPosition = randomAccessFile.length() - 10
//    }

    @Scheduled(fixedDelay = 500, initialDelay = 5000)
    fun fileWatcherWithRandomAccess() {
        val fileLength = randomAccessFile.length()

        println("Last read pos $lastReadPosition")
        println("File length $fileLength")

        randomAccessFile.seek(lastReadPosition)

        while (randomAccessFile.filePointer < fileLength) {
            messagingTemplate
                .convertAndSend("/topic/logs", "{\"content\" : \"${randomAccessFile.readLine()}\"}")

        }
        lastReadPosition = fileLength
    }
}