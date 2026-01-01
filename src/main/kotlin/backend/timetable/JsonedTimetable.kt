package backend.timetable

data class JsonedTimetable(
    val name: String,
    val subjects: MutableList<Subject>,
    val timelines: MutableList<Timeline>,
    val lessons: MutableList<Lessons>
)
