package om.squ.roverscalendar.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import om.squ.roverscalendar.model.CardGold
import om.squ.roverscalendar.model.PrimaryNavy
import om.squ.roverscalendar.model.TableHeaderBlue
import om.squ.roverscalendar.model.AccentGold

data class DayCell(val dateText: String, val fullDate: String, val cellColor: Color = Color.White)
data class WeekRow(val weekNumber: Int, val days: List<DayCell>)

@Composable
fun SemesterScreen(
    semesterTitle: String = "فصل الخريف 2026",
    weeksData: List<WeekRow>,
    onDateClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryNavy)
            .padding(8.dp)
    ) {
        // Top Header
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = CardDefaults.cardColors(containerColor = AccentGold),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "عشائر جوالة وجوالات جامعة السلطان قابوس",
                    fontSize = 12.sp,
                    color = PrimaryNavy,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = semesterTitle,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Black,
                    color = PrimaryNavy
                )
            }
        }

        // Table Headers
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(TableHeaderBlue, RoundedCornerShape(6.dp))
                .padding(vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val headers = listOf("الأسبوع", "الأحد", "الإثنين", "الثلاثاء", "الأربعاء", "الخميس", "الجمعة", "السبت")
            headers.forEach { header ->
                Text(
                    text = header,
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // 17 Weeks Table
        LazyColumn(verticalArrangement = Arrangement.spacedBy(3.dp)) {
            items(weeksData) { week ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Week Number Cell
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(36.dp)
                            .background(TableHeaderBlue, RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${week.weekNumber}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }

                    // 7 Days Cells
                    week.days.forEach { day ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(36.dp)
                                .padding(1.dp)
                                .background(day.cellColor, RoundedCornerShape(4.dp))
                                .border(1.dp, CardGold, RoundedCornerShape(4.dp))
                                .clickable { onDateClick(day.fullDate) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = day.dateText,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (day.cellColor == Color.White) Color.Black else Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
