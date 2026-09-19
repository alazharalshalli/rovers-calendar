package om.squ.roverscalendar.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val title = intent.getStringExtra("EXTRA_TITLE") ?: "تنبيه موعد جديد"
        val ringtoneUriString = intent.getStringExtra("EXTRA_RINGTONE")

        Toast.makeText(context, "⏰ $title", Toast.LENGTH_LONG).show()

        val ringtoneUri = if (!ringtoneUriString.isNull_Empty()) {
            Uri.parse(ringtoneUriString)
        } else {
            RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }

        try {
            val ringtone = RingtoneManager.getRingtone(context, ringtoneUri)
            ringtone.play()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

private fun String?.isNull_Empty(): Boolean = this == null || this.isEmpty()
