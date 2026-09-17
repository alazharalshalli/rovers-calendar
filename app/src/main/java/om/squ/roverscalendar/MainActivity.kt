package om.squ.roverscalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import om.squ.roverscalendar.data.AppDatabase
import om.squ.roverscalendar.data.EventEntity
import om.squ.roverscalendar.model.CalendarEventColor
import om.squ.roverscalendar.ui.screens.*
import om.squ.roverscalendar.ui.theme.RoversCalendarTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getDatabase(this)
        val eventDao = db.eventDao()

        setContent {
            RoversCalendarTheme {
                var currentScreen by remember { mutableStateOf("SEMESTER") }
                var selectedDate by remember { mutableStateOf("13.9") }
                val scope = rememberCoroutineScope()

                // Generate dummy 17-week semester table based on Fall Semester design
                val weeks = remember {
                    listOf(
                        WeekRow(1, listOf(DayCell("13.9", "13.9"), DayCell("14.9", "14.9"), DayCell("15.9", "15.9"), DayCell("16.9", "16.9"), DayCell("17.9", "17.9"), DayCell("18.9", "18.9"), DayCell("19.9", "19.9"))),
                        WeekRow(2, listOf(DayCell("20.9", "20.9"), DayCell("21.9", "21.9"), DayCell("22.9", "22.9"), DayCell("23.9", "23.9"), DayCell("24.9", "24.9"), DayCell("25.9", "25.9"), DayCell("26.9", "26.9"))),
                        WeekRow(3, listOf(DayCell("27.9", "27.9"), DayCell("28.9", "28.9"), DayCell("29.9", "29.9"), DayCell("30.9", "30.9"), DayCell("1.10", "1.10"), DayCell("2.10", "2.10"), DayCell("3.10", "3.10"))),
                        WeekRow(4, listOf(DayCell("4.10", "4.10"), DayCell("5.10", "5.10"), DayCell("6.10", "6.10"), DayCell("7.10", "7.10"), DayCell("8.10", "8.10"), DayCell("9.10", "9.10"), DayCell("10.10", "10.10"))),
                        WeekRow(5, listOf(DayCell("11.10", "11.10"), DayCell("12.10", "12.10"), DayCell("13.10", "13.10"), DayCell("14.10", "14.10"), DayCell("15.10", "15.10"), DayCell("16.10", "16.10"), DayCell("17.10", "17.10"))),
                        WeekRow(6, listOf(DayCell("18.10", "18.10"), DayCell("19.10", "19.10"), DayCell("20.10", "20.10"), DayCell("21.10", "21.10"), DayCell("22.10", "22.10"), DayCell("23.10", "23.10"), DayCell("24.10", "24.10"))),
                        WeekRow(7, listOf(DayCell("25.10", "25.10"), DayCell("26.10", "26.10"), DayCell("27.10", "27.10"), DayCell("28.10", "28.10"), DayCell("29.10", "29.10"), DayCell("30.10", "30.10"), DayCell("31.10", "31.10"))),
                        WeekRow(8, listOf(DayCell("1.11", "1.11"), DayCell("2.11", "2.11"), DayCell("3.11", "3.11"), DayCell("4.11", "4.11"), DayCell("5.11", "5.11"), DayCell("6.11", "6.11"), DayCell("7.11", "7.11"))),
                        WeekRow(9, listOf(DayCell("8.11", "8.11"), DayCell("9.11", "9.11"), DayCell("10.11", "10.11"), DayCell("11.11", "11.11"), DayCell("12.11", "12.11"), DayCell("13.11", "13.11"), DayCell("14.11", "14.11"))),
                        WeekRow(10, listOf(DayCell("15.11", "15.11"), DayCell("16.11", "16.11"), DayCell("17.11", "17.11"), DayCell("18.11", "18.11"), DayCell("19.11", "19.11"), DayCell("20.11", "20.11"), DayCell("21.11", "21.11"))),
                        WeekRow(11, listOf(DayCell("22.11", "22.11"), DayCell("23.11", "23.11"), DayCell("24.11", "24.11"), DayCell("25.11", "25.11"), DayCell("26.11", "26.11"), DayCell("27.11", "27.11"), DayCell("28.11", "28.11"))),
                        WeekRow(12, listOf(DayCell("29.11", "29.11"), DayCell("30.11", "30.11"), DayCell("1.12", "1.12"), DayCell("2.12", "2.12"), DayCell("3.12", "3.12"), DayCell("4.12", "4.12"), DayCell("5.12", "5.12"))),
                        WeekRow(13, listOf(DayCell("6.12", "6.12"), DayCell("7.12", "7.12"), DayCell("8.12", "8.12"), DayCell("9.12", "9.12"), DayCell("10.12", "10.12"), DayCell("11.12", "11.12"), DayCell("12.12", "12.12"))),
                        WeekRow(14, listOf(DayCell("13.12", "13.12"), DayCell("14.12", "14.12"), DayCell("15.12", "15.12"), DayCell("16.12", "16.12"), DayCell("17.12", "17.12"), DayCell("18.12", "18.12"), DayCell("19.12", "19.12"))),
                        WeekRow(15, listOf(DayCell("20.12", "20.12"), DayCell("21.12", "21.12"), DayCell("22.12", "22.12"), DayCell("23.12", "23.12"), DayCell("24.12", "24.12"), DayCell("25.12", "25.12"), DayCell("26.12", "26.12"))),
                        WeekRow(16, listOf(DayCell("27.12", "27.12"), DayCell("28.12", "28.12"), DayCell("29.12", "29.12"), DayCell("30.12", "30.12"), DayCell("31.12", "31.12"), DayCell("1.1", "1.1"), DayCell("2.1", "2.1"))),
                        WeekRow(17, listOf(DayCell("3.1", "3.1"), DayCell("4.1", "4.1"), DayCell("5.1", "5.1"), DayCell("6.1", "6.1"), DayCell("7.1", "7.1"), DayCell("8.1", "8.1"), DayCell("9.1", "9.1")))
                    )
                }

                if (currentScreen == "SEMESTER") {
                    Semester
