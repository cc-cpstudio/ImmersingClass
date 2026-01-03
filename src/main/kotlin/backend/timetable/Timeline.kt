package backend.timetable

import mu.KLogging

class Timeline(jsoned: JsonedTimeline?) {
    companion object: KLogging()

    var name = "New-Timeline"
    val nodes = mutableListOf<TimeNode>()

    init {
        try {
            val id = jsoned?.id ?: 0
            name = jsoned?.name ?: "New-Timeline"
            nodes.addAll(jsoned?.nodes ?: listOf())
            if (jsoned != null) {
                logger.debug("")
            } else {
                logger.debug("")
            }
        } catch (e: Exception) {

        } finally {

        }
    }

    constructor(): this(null)
}