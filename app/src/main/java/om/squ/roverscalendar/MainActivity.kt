package om.squ.roverscalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import om.squ.roverscalendar.data.AppDatabase
import om.squ.roverscalendar.ui.screens.DayCell
import om.squ.roverscalendar.ui.screens.SemesterScreen
import om.squ.roverscalendar.ui.screens.WeekRow
import om.squ.roverscalendar.ui.theme.RoversCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getDatabase(this)
        val eventDao = db.eventDao()

        setContent {
            RoversCalendarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var selectedDate by remember { mutableStateOf("13.9") }

                    val weeks = remember {
                        listOf(
                            WeekRow(1, listOf(DayCell("13.9", "13.9"), DayCell("14.9", "14.9"))),
                            WeekRow(2, listOf(DayCell("20.9", "20.9"), DayCell("21.9", "21.9")))
                        )
                    }

                    SemesterScreen(
                        weeks = weeks,
                        onDateSelected = { date ->
                            selectedDate = date
                        }
                    )
                }
            }
        }
    }
}
