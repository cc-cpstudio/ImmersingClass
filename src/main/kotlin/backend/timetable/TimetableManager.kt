package backend.timetable

import java.io.File
import java.io.FileNotFoundException

import mu.KotlinLogging

import backend.basicfunc.get_userdata_location

object TimetableManager {
    class TooLessTimetableException: Exception("时间表太少以至于不能执行后续操作")

    private val logger = KotlinLogging.logger("TimetableManager")

    val timetableNames = mutableListOf<String>()
    var currentTimetable: Timetable? = null

    fun refreshTimetables() {
        try {
            timetableNames.clear()
            logger.debug("已清空 timetableNames 列表！")

            val dir = File("${get_userdata_location()}\\timetable")
            if (dir.exists() && dir.isDirectory) {
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
        } catch (e: Exception) {
            logger.error("刷新文件名列表时出错：未知错误！")
            e.printStackTrace()
        } finally {
            logger.debug("函数执行完毕。")
        }
    }

    fun connect(ttName: String) {
        try {
            if (currentTimetable != null) {
                logger.debug("已连接其他时间表，正在尝试保存")
                serializeTimetable(currentTimetable!!)
            } else {
                logger.debug("未连接时间表，即将开始连接新时间表")
            }
            currentTimetable = resolveTimetable(ttName)
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

    fun disconnect() {
        try {
            if (currentTimetable != null) {
                logger.debug("正在断开连接并保存当前时间表: ${currentTimetable?.name}")
                currentTimetable?.let { serializeTimetable(it) }
                currentTimetable = null
                logger.debug("成功断开时间表连接")
            } else {
                logger.debug("没有连接到任何时间表，无需断开连接")
            }
        } catch (e: Exception) {
            logger.error("断开时间表连接时出错")
            e.printStackTrace()
        } finally {
            logger.debug("函数执行完毕")
        }
    }

    fun create(name: String) {
        try {
            logger.debug("正在创建新的时间表: $name")
            val tmpTt = Timetable()
            tmpTt.name = name
            tmpTt.save()
            timetableNames.add(name)
            logger.info("已成功创建时间表: $name")
        } catch (e: Exception) {
            logger.error("创建时间表时出错: ${e.message}")
            e.printStackTrace()
        }
    }

    fun delete(ttName: String) {
        try {
            if (timetableNames.size <= 1) {
                logger.error("尝试删除时间表 $ttName 失败：时间表数量不足以删除该表")
                throw TooLessTimetableException()
            }
            currentTimetable?.let { 
                if (it.name == ttName) {
                    logger.debug("要删除的时间表 $ttName 正在被使用，正在断开连接")
                    disconnect()
                }
            }
            val file = File("${get_userdata_location()}\\timetable\\$ttName.json")
            if (file.exists()) {
                val result = file.delete()
                if (result) {
                    timetableNames.remove(ttName)
                    logger.debug("已成功删除时间表文件: $ttName.json")
                } else {
                    logger.error("删除时间表文件失败: $ttName.json")
                    throw Exception("无法删除文件: $ttName.json")
                }
            } else {
                logger.warn("要删除的时间表文件不存在: $ttName.json")
                throw FileNotFoundException("时间表文件不存在: $ttName.json")
            }
        } catch (e: TooLessTimetableException) {
            logger.error("删除时间表时出错：时间表数量太少")
            throw e
        } catch (e: FileNotFoundException) {
            logger.error("删除时间表时出错：未找到文件")
            throw e
        } catch (e: Exception) {
            logger.error("删除时间表时出错：未知错误")
            throw e
        } finally {
            logger.debug("函数执行完毕。")
        }
    }

    // Here's APIs:

    fun currentTimetableName(): String? = currentTimetable?.name
    fun allTimetableNames(): List<String> = timetableNames
    fun isConnected(): Boolean = currentTimetable != null

}