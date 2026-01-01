package timetable

import java.io.File
import java.io.FileNotFoundException
import java.lang.IllegalStateException

import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import mu.KotlinLogging

import basicfunc.get_userdata_location

fun resolveJsonedString(str: String): JsonedTimetable? {
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
fun resolveJsonedTimetable(ttName: String): Timetable? {
    val logger = KotlinLogging.logger("resolveJsonedTimetable")
    try {
        val filePath = "${get_userdata_location()}\\ImmersingClassData\\timetable\\${ttName}.json"
        if (File(filePath).exists() && File(filePath).isFile) {
            logger.debug("找到文件 ${ttName}.json！")
            var jsoned = ""
            val file = File(filePath)
            logger.debug("成功创建 $ttName.json 的文件对象！")
            file.forEachLine {
                jsoned += it
            }
            val res = resolveJsonedString(jsoned)
            res?.let {
                if (it.name != ttName) {
                    logger.warn("时间表文件名称 $ttName 与表内名称 ${it.name} 不一致！")
                }
            }
            return Timetable(res)
        } else {
            throw FileNotFoundException("路径 $filePath 不存在或是一个目录！")
        }
    } catch(e: FileNotFoundException) {
        logger.error("文件 ${ttName}.json 不存在！")
        e.printStackTrace()
        return null
    } catch(e: Exception) {
        logger.error("解析文件 ${ttName}.json 时出错：未知错误！")
        e.printStackTrace()
        return null
    } finally {
        logger.debug("函数执行完毕。")
    }
}