package timetable

import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import kotlin.IllegalStateException
import mu.KotlinLogging
private fun resolveJsonedString(str: String): JsonedTimetable? {
    val logger = KotlinLogging.logger("resolveJsonedString")
    try {
        val gson = GsonBuilder()
            .disableHtmlEscaping()
            .create()
        logger.debug("成功创建Gson对象！")
        val res = gson.fromJson(str, JsonedTimetable::class.java)
        logger.debug("成功解析JSON字符串到JsonedTimetable！")
        return res
    } catch (e: JsonSyntaxException) {
        logger.error("解析JSON字符串时出错：JSON格式异常或字段格式错误！")
        e.printStackTrace()
        return null
    } catch (e: IllegalStateException) {
        logger.error("解析JSON字符串时出错：缺失必要字段或无法实例化对象！")
        e.printStackTrace()
        return null
    } catch (e: Exception) {
        logger.error("解析JSON字符串时出错：未知错误！")
        e.printStackTrace()
        return null
    } finally {
        logger.debug("函数执行完毕。")
    }
}
fun resolve(ttName: String) {

}