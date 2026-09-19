package om.squ.roverscalendar.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = NavyPrimary,
    secondary = GoldAccent,
    background = NavyPrimary,
    surface = TableHeaderBlue
)

@Composable
fun RoversCalendarTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
