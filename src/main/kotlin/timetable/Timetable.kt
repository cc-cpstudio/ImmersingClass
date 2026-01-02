package timetable

import java.lang.IllegalStateException

import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.JsonParseException
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

    constructor(): this(null)
}