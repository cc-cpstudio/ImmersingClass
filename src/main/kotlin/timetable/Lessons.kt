package timetable

data class Lessons(
    val id: Int,
    val timeline: Int,
    val nodes: MutableList<LessonNode>
)
