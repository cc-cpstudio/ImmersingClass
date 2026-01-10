package backend.timetable

import mu.KLogging
import java.time.DayOfWeek

class Lessons(jsoned: JsonedLessons?) {

    companion object: KLogging()

    val id: Int = jsoned?.id ?: 0
    val name: String = jsoned?.name ?: "New-Lessons"
    val enabled: Boolean = jsoned?.enabled ?: false
    val timeline: Int = jsoned?.timeline ?: 0
    val workWeekday: DayOfWeek = jsoned?.workWeekday ?: DayOfWeek.MONDAY
    val workWeek: Pair<Int, Int> = jsoned?.workWeek ?: Pair(1, 1)
    val nodes: MutableList<LessonNode> = jsoned?.nodes ?: mutableListOf()

    constructor(): this(null)
}