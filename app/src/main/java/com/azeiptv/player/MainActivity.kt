
package com.azeiptv.player

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {

    private val bg = Color.rgb(12, 14, 22)
    private val accent = Color.rgb(115, 75, 255)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(22, 35, 22, 20)
            setBackgroundColor(bg)
        }

        val title = TextView(this).apply {
            text = "AZE IPTV"
            textSize = 30f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(0, 15, 0, 25)
        }
        root.addView(title)

        val subtitle = TextView(this).apply {
            text = "Televiziya dünyasına xoş gəlmisiniz"
            textSize = 16f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }
        root.addView(subtitle)

        val button = Button(this).apply {
            text = "M3U PLAYLIST ƏLAVƏ ET"
            setTextColor(Color.WHITE)
            setBackgroundColor(accent)
            setOnClickListener {
                val input = EditText(this@MainActivity)
                input.hint = "M3U linkini daxil et"

                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Playlist əlavə et")
                    .setView(input)
                    .setPositiveButton("Əlavə et") { _, _ ->
                        Toast.makeText(
                            this@MainActivity,
                            "Link daxil edildi",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .setNegativeButton("Ləğv et", null)
                    .show()
            }
        }

        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            60
        )
        params.topMargin = 35
        root.addView(button, params)

        val channels = TextView(this).apply {
            text = "📺  CANLI TV\n\n❤️  SEVİMLİLƏR\n\n⚽  İDMAN\n\n🎬  FİLM VƏ SERİALLAR"
            textSize = 19f
            setTextColor(Color.WHITE)
            setPadding(10, 35, 10, 10)
        }
        root.addView(channels)

        setContentView(root)
    }
}
