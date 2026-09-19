package om.squ.roverscalendar.model

import androidx.compose.ui.graphics.Color

enum class CalendarEventColor(val hex: Long, val nameAr: String, val composeColor: Color) {
    BLUE(0xFF2196F3, "أزرق", Color(0xFF2196F3)),
    RED(0xFFE53935, "أحمر", Color(0xFFE53935)),
    BLACK(0xFF212121, "أسود", Color(0xFF212121)),
    WHITE(0xFFFFFFFF, "أبيض", Color(0xFFFFFFFF)),
    GRAY(0xFF757575, "رمادي", Color(0xFF757575)),
    ORANGE(0xFFFB8C00, "برتقالي", Color(0xFFFB8C00)),
    YELLOW(0xFFFDD835, "أصفر", Color(0xFFFDD835)),
    GREEN(0xFF4CAF50, "أخضر", Color(0xFF4CAF50)),
    PURPLE(0xFF8E24AA, "بنفسجي", Color(0xFF8E24AA)),
    PINK(0xFFE91E63, "وردي", Color(0xFFE91E63)),
    BROWN(0xFF795548, "بني", Color(0xFF795548)),
    NAVY(0xFF0C2340, "بحري", Color(0xFF0C2340)),
    DARK_GREEN(0xFF1B5E20, "أخضر غامق", Color(0xFF1B5E20))
}

val PrimaryNavy = Color(0xFF0B1B3D)
val AccentGold = Color(0xFFC5A059)
val CardGold = Color(0xFFD4AF37)
val TableHeaderBlue = Color(0xFF0C2340)
