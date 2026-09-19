package om.squ.roverscalendar.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val dateString: String, // YYYY-MM-DD or D.M
    val startHour: Int,    // 0 to 23
    val durationHours: Int = 1,
    val isAllDay: Boolean = false,
    val colorHex: Long,
    val ringtoneUri: String? = null
)

@Entity(tableName = "semesters")
data class SemesterEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String, // e.g. "فصل الخريف 2026"
    val startDate: String, // YYYY-MM-DD
    val totalWeeks: Int = 17,
    val isCurrent: Boolean = true
)
