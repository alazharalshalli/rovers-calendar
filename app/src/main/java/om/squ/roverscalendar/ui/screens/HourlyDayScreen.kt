package om.squ.roverscalendar.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import om.squ.roverscalendar.data.EventEntity
import om.squ.roverscalendar.model.AccentGold
import om.squ.roverscalendar.model.PrimaryNavy

@Composable
fun HourlyDayScreen(
    dateString: String,
    events: List<EventEntity>,
    onBack: () -> Unit,
    onAddHourClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryNavy)
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onBack,
                colors = ButtonDefaults.buttonColors(containerColor = AccentGold)
            ) {
                Text("عودة للجدول", color = PrimaryNavy, fontWeight = FontWeight.Bold)
            }
            Text(
                text = "جدول يوم: $dateString",
                color = AccentGold,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            items(24) { hour ->
                val hourEvent = events.find { it.startHour == hour }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = String.format("%02d:00", hour),
                        color = Color.White,
                        modifier = Modifier.width(50.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(
                                color = hourEvent?.let { Color(it.colorHex) } ?: Color.White.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(6.dp)
                            )
                            .clickable { onAddHourClick(hour) }
                            .padding(horizontal = 12.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = hourEvent?.title ?: "+ اضغط لإضافة موعد أو تنبيه",
                            color = if (hourEvent != null) Color.White else Color.LightGray,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
