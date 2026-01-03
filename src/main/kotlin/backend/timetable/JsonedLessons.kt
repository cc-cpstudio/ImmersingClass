package backend.timetable

import java.time.DayOfWeek

data class JsonedLessons(
    val id: Int,
    val name: String,
    val enabled: Boolean,
    val timeline: Int,
    val workWeekday: DayOfWeek,
    val workWeek: Pair<Int, Int>,
    val nodes: MutableList<LessonNode>
)
