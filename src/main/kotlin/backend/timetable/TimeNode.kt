package backend.timetable

import java.time.LocalTime

data class TimeNode(
    val id: Int,
    val state: TimeNodeState,
    val start: LocalTime,
    val end: LocalTime,
    val config: MutableMap<String, String>
)
