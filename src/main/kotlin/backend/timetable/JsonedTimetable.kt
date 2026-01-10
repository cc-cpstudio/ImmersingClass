package backend.timetable

import java.time.LocalDate

data class JsonedTimetable(
    val name: String,
    val subjects: MutableList<Subject>,
    val jsonedTimelines: MutableList<JsonedTimeline>,
    val lessons: MutableList<JsonedLessons>,
    val schoolOpenDate: LocalDate,
)
