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
    constructor(): this(null)

    fun toJsoned(): JsonedTimetable? {
        try {
            logger.debug("成功创建 JsonedTimetable！")
            return JsonedTimetable(
                name = name,
                subjects = subjects,
                timelines = timelines,
                lessons = lessons
            )
        } catch (e: Exception) {
            logger.error("创建 JsonedTimetable 时出错：未知错误！")
            e.printStackTrace()
            return null
        } finally {
            logger.debug("函数执行完毕。")
        }
    }

    fun toJson(): String? {
        try {
            val gson = GsonBuilder()
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create()
            logger.debug("成功创建 Gson 对象！")

            val jsonedTimetable = toJsoned()
            logger.debug("成功转换为 JsonedTimetable！")

            return gson.toJson(jsonedTimetable)
        } catch (e: JsonSyntaxException) {
            logger.error("转换 JsonedTimetable 到 Json 时出错：无参构造函数缺失！")
            e.printStackTrace()
            return null
        } catch (e: IllegalStateException) {
            logger.error("转换 JsonedTimetable 到 Json 时出错：字段访问失败！")
            e.printStackTrace()
            return null
        } catch (e: JsonParseException) {
            logger.error("转换 JsonedTimetable 到 Json 时出错：非空类型遇到null值！")
            e.printStackTrace()
            return null
        } finally {
            logger.debug("函数执行完毕。")
        }
    }
}