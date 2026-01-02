package backend.timetable

data class Subject(
    val id: Int,
    val name: String,
    val simple: String,
    val outside: Boolean,
    val teacher: String
)