package backend.timetable

import java.time.Duration

import mu.KLogging

class Timetable(jsoned: JsonedTimetable?) {

    companion object: KLogging()

    var name: String = ""
    val subjects = mutableListOf<Subject>()
    val timelines = mutableListOf<Timeline>()
    val lessons = mutableListOf<Lessons>()

    init {
        try {
            name = jsoned?.name ?: "New-Timetable"
            subjects.addAll(jsoned?.subjects ?: listOf())
            timelines.addAll(jsoned?.timelines ?: listOf())
            lessons.addAll(jsoned?.lessons ?: listOf())
            if (jsoned != null) {
                logger.debug("成功转换 JsonedTimetable 到 Timetable！")
            } else {
                logger.debug("成功创建 Timetable！")
            }
        } catch (e: Exception) {
            logger.error("转换 JsonedTimetable 到 Timetable 时出错：未知错误！")
            e.printStackTrace()
            name = "New Timetable"
            subjects.clear()
            timelines.clear()
            lessons.clear()
            logger.debug("已清空 Timetable 的数据！")
        } finally {
            logger.debug("Timetable 创建完毕！")
        }
    }

    fun save() {
        logger.debug("开始保存时间表: $name")
        try {
            serializeTimetable(this)
            logger.debug("时间表保存成功: $name")
        } catch (e: Exception) {
            logger.error("保存时间表时出错: $name", e)
            throw e
        }
    }

    // Here's APIs:

    fun currNode(): TimeNode? = null                                                // 当前时间节点，若未配置可用课程表或已放学则为null
    fun currState(): TimeNodeState? = currNode()?.state                             // 当前时间节点状态，若currNode()为null则为null
    fun currSubject(): Subject? = null                                              // 当前科目，若不处于上课节点则为null
    fun currLessons(): Lessons? = null                                              //当前启用的课程表，若没有可用课程表则为null
    fun nextNode(): TimeNode? = null                                                // 下一个时间节点，若未配置可用课程表或位于时间线最后一个节点则为null
    fun leftTime(): Duration? = null                                                // 距离下一个时间节点的时间，若未配置可用课程表或位于时间线最后一个节点则为null
    fun isAvailableLessonsEnabled(): Boolean = false                                // 是否已启用可用课程表
    fun isSchoolOver(): Boolean = currNode() == null && isAvailableLessonsEnabled() // 是否已经放学


    constructor(): this(null)
}