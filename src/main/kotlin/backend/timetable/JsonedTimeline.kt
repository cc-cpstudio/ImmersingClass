package backend.timetable

data class JsonedTimeline(
    val id: Int,
    val name: String,
    val nodes: MutableList<TimeNode>
)
