package timetable

import java.time.LocalDateTime

import mu.KotlinLogging

object TestTermEmulator {
    val logger = KotlinLogging.logger("TestTermEmulator")
    fun start() {
        TimetableManager.refreshTimetables()
        while (true) {
            print("${LocalDateTime.now()} > ")
            val cmd = readlnOrNull()
            cmd?.let {
                val res = it.split(" ")
                when (res[0]) {
                    "connect" -> connect(res[1])
                    "create" -> create(res[1])
                    "crtt" -> currentTimetable()
                    "delete" -> delete(res[1])
                    "disconnect" -> disconnect()
                    "lstt" -> listTimetables()
                    "exit" -> break
                    "refresh" -> refresh()
                }
            }
        }
        println("Exit time: ${LocalDateTime.now()}")
    }

    private fun connect(ttName: String) {
        logger.debug("开始执行 connect ……")
        TimetableManager.connect(ttName)
    }
    private fun disconnect() {
        logger.debug("开始执行 disconnect ……")
        TimetableManager.disconnect()
    }
    private fun create(ttName: String) {
        logger.debug("开始执行 create ……")
        TimetableManager.create(ttName)
    }
    private fun delete(ttName: String) {
        logger.debug("开始执行 delete ……")
        TimetableManager.delete(ttName)
    }
    private fun refresh() {
        logger.debug("开始执行 refresh ……")
        TimetableManager.refreshTimetables()
    }
    private fun listTimetables() {
        logger.debug("开始执行 lstt ……")
        val res = TimetableManager.timetableNames
        val cur = TimetableManager.currentTimetable?.name
        res.forEach {
            if (it == cur) { print(" * ") } else { print("   ") }
            println(it)
        }
    }
    private fun currentTimetable() {
        logger.debug("开始执行 crtt ……")
        val cur = TimetableManager.currentTimetable?.name
        println(cur ?: "No timetable is connected.")
    }
}

