package timetable

import java.time.DayOfWeek

data class Lessons(
    val id: Int,
    val timeline: Int,
    val workWeekday: DayOfWeek,
    val workWeek: Pair<Int, Int>,
    val nodes: MutableList<LessonNode>
)
