package timetable

data class JsonedTimetable(
    val subjects: MutableList<Subject>,
    val timelines: MutableList<Timeline>,
    val lessons: MutableList<Lessons>
)
