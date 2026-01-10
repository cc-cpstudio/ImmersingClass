package backend.timetable

import mu.KLogging

class Timeline(jsoned: JsonedTimeline?) {
    companion object: KLogging()

    val id = jsoned?.id ?: 0
    val name = jsoned?.name ?: "New-Timeline"
    val nodes = jsoned?.nodes ?: mutableListOf()

    init { }

    constructor(): this(null)
}