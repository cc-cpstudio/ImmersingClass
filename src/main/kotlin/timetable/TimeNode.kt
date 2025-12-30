package timetable

import java.time.LocalTime

data class TimeNode(
    val id: Int,
    val type: String,
    val start: LocalTime,
    val end: LocalTime,
    val config: MutableMap<String, String>
)
