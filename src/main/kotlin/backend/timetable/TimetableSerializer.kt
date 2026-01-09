package backend.timetable

import backend.basicfunc.get_userdata_location

import java.io.File
import java.time.LocalTime

import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import mu.KotlinLogging

import timetable.LocalTimeAdapter

fun serializeTimetable(tt: Timetable) {
    val logger = KotlinLogging.logger("serializeTimetable")
    try {
        val gson = GsonBuilder()
            .registerTypeAdapter(LocalTime::class.java, LocalTimeAdapter())
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .create()
        logger.debug("创建Gson实例完成")
        val file = File("${get_userdata_location()}\\timetable\\${tt.name}.json")
        logger.debug("准备创建JsonedTimetable对象，时间表名称: ${tt.name}")
        val jsoned = JsonedTimetable(
            tt.name,
            tt.subjects,
            tt.timelines,
            tt.lessons
        )
        logger.debug("JsonedTimetable对象创建完成，开始转换为JSON字符串")
        val res = gson.toJson(jsoned, JsonedTimetable::class.java)
        logger.debug("JSON字符串生成完成，长度为: ${res.length} 字符")
        file.writeText(res)
        logger.info("时间表 ${tt.name} 已成功序列化并保存到文件: ${file.absolutePath}")
    } catch (e: JsonSyntaxException) {
        logger.error("序列化时间表时发生JSON语法错误: ${e.message}")
        e.printStackTrace()
    } catch (e: Exception) {
        logger.error("序列化时间表时发生未知错误: ${e.message}")
        e.printStackTrace()
    } finally {
        logger.debug("函数执行完毕。")
    }
}