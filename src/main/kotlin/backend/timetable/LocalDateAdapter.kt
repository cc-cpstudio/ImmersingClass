package backend.timetable

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LocalDateAdapter: JsonDeserializer<LocalDate>, JsonSerializer<LocalDate> {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE
    override fun serialize(src: LocalDate?, typeOfSrc: Type, content: JsonSerializationContext): JsonElement? {
        return if (src == null) {
            JsonNull.INSTANCE
        } else {
            JsonPrimitive(src.format(formatter))
        }
    }

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): LocalDate? {
        return if (json.isJsonNull) {
            null
        } else {
            LocalDate.parse(json.asString, formatter)
        }
    }
}