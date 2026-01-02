package backend.timetable

import com.google.gson.annotations.SerializedName

enum class TimeNodeState {
    @SerializedName("lesson")
    LESSON,

    @SerializedName("breaking")
    BREAKING
}