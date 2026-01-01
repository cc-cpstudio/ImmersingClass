package timetable

import java.io.File
import java.io.FileNotFoundException

import mu.KotlinLogging

import basicfunc.get_userdata_location

object TimetableManager {
    private val logger = KotlinLogging.logger("TimetableManager")

    val timetableNames =  mutableListOf<String>()
    var currentTimetable: Timetable? = null

    fun refreshTimetables() {
        try {
            timetableNames.clear()
            logger.debug("已清空 timetableNames 列表！")

            val dir = File("${get_userdata_location()}\\ImmersingClassData\\timetable")
            if (dir.exists() &&  dir.isDirectory) {
                logger.debug("找到目录 ${dir.absolutePath}！开始寻找时间表文件")
                val files = dir.listFiles()
                files?.forEach {
                     if (it.isFile && it.name.endsWith(".json")) {
                         timetableNames.add(it.nameWithoutExtension)
                         logger.debug("找到时间表文件 ${it.name}！")
                     } else {
                         logger.warn("目录不干净了！混入了${it.name}")
                     }
                }
            } else {
                dir.mkdirs()
                throw FileNotFoundException("路径 ${dir.absolutePath} 不存在或不是一个目录！")
            }
        } catch (e: FileNotFoundException) {
            logger.error("刷新文件名列表时出错：未找到目录，已自动创建")
            e.printStackTrace()
        } catch(e: Exception) {
            logger.error("刷新文件名列表时出错：未知错误！")
            e.printStackTrace()
        } finally {
            logger.debug("函数执行完毕。")
        }
    }

    fun connect (ttName: String) {
        try {
            if (currentTimetable != null) {
                logger.debug("已连接其他时间表，正在尝试保存")
                val file = File("${get_userdata_location()}\\ImmersingClassData\\timetable\\${currentTimetable!!.name}.json")
                val jsoned = JsonedTimetable(
                    currentTimetable!!.name,
                    currentTimetable!!.subjects,
                    currentTimetable!!.timelines,
                    currentTimetable!!.lessons
                )
            } else {
                logger.debug("未连接时间表，即将开始连接新时间表")
            }
            currentTimetable = resolveJsonedTimetable(ttName)
        } catch (e: FileNotFoundException) {
            logger.error("连接时间表时出错：要连接或断开的表名称不存在！")
            e.printStackTrace()
            currentTimetable = null
        } catch (e: Exception) {
            logger.error("连接时间表时出错：未知错误！")
            e.printStackTrace()
            currentTimetable = null
        } finally {
            logger.debug("函数执行完毕。")
        }
    }

    fun disconnectAll () {

    }

    // 以下是该单例类提供的API：

    fun currentTimetableName(): String? = currentTimetable?.name
    fun allTimetableNames(): List<String> = timetableNames

}