package timetable

import com.google.gson.Gson
import kotlin.io.path.*

fun timetable_resolve(tt_name: String) {
    val resolver = Gson()

    val jsonStr = ""
    val res = resolver.fromJson(jsonStr, JsonedTimetable::class.java)
}