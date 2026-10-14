package com.example.mood_sasuke

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button

//    private lateinit var mood_question: TextView

    private lateinit var mood_response: TextView

    private lateinit var mood_percent: TextView

    private lateinit var lottie1: LottieAnimationView
    private lateinit var lottie2: LottieAnimationView
    private lateinit var lottie3: LottieAnimationView

    private var number: Int = 5

    private var ResponseText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.generate_button)
        mood_response = findViewById(R.id.mood_response)
        mood_percent = findViewById(R.id.mood_percent)

        lottie1 = findViewById(R.id.lottie1)
        lottie2 = findViewById(R.id.lottie2)
        lottie3 = findViewById(R.id.lottie3)

        lottie1.setAnimation(R.raw.morty_cry_loader)
        lottie2.setAnimation(R.raw.face_app)
        lottie3.setAnimation(R.raw.morty_dancing)

        btn.setOnClickListener {
            lottie1.visibility = View.INVISIBLE
            lottie2.visibility = View.INVISIBLE
            lottie3.visibility = View.INVISIBLE

            number = (Math.random() * 100).toInt()
            mood_percent.text = "$number %"

            when (number) {
                in 0..30 -> {
                    ResponseText = "You are in a bad mood"
                    lottie1.visibility = View.VISIBLE
                }
                in 31..67 -> {
                    ResponseText = "You are in a normal mood"
                    lottie2.visibility = View.VISIBLE
                }
                else -> {
                    ResponseText = "You are in a good mood"
                    lottie3.visibility = View.VISIBLE
                }
            }
        mood_response.text = ResponseText
        }
    }
}