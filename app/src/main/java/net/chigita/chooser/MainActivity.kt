package net.chigita.chooser

import android.app.PendingIntent
import android.content.Intent
import android.graphics.drawable.Icon
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.chooser.ChooserAction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("geo:35.681382,139.766084?z=16")
        )

        val chooserAction = ChooserAction.Builder(
            Icon.createWithResource(
                this,
                R.drawable.ic_android_black_24dp
            ),
            "super util action",
            PendingIntent.getActivity(
                this,
                0,
                locationIntent, // Need to consider better example.
                PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        ).build()

        val intent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }

        val chooser = Intent.createChooser(intent, "Share").apply {
            putExtra(Intent.EXTRA_CHOOSER_CUSTOM_ACTIONS, arrayOf(chooserAction))
        }
        startActivity(chooser)
    }
}
