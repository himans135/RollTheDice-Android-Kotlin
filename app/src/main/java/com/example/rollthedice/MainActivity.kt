package com.example.rollthedice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var TAG :String = "MainActivity"
    var random_number :Int = 0

    var score_player_a: Int = 0
    var score_player_b: Int = 0
    var active_player_a : Boolean = true
    var active_player_b : Boolean = false

    var game_end_msg : String? = null
    var game_end_msg_default : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice_image_1.isEnabled = false
        btnGamePlay.setOnClickListener {
            dice_image_1.isEnabled = true
            score_player_a = 0
            score_player_b = 0
            game_player_text.text = ""
            tvplayerA.text = score_player_a.toString()
            tvplayerB.text = score_player_b.toString()
            active_player_a = true
            active_player_b = false
            dice_image_1.setImageResource(R.drawable.face_1)

        }

        dice_image_1.setOnClickListener {
            random_number =(1..6).random()

            when(random_number) {
                1 -> {
                    dice_image_1.setImageResource(R.drawable.face_1)
                }
                2 -> {
                    dice_image_1.setImageResource(R.drawable.face_2)
                }
                3 -> {
                    dice_image_1.setImageResource(R.drawable.face_3)
                }
                4 -> {
                    dice_image_1.setImageResource(R.drawable.face_4)
                }
                5 -> {
                    dice_image_1.setImageResource(R.drawable.face_5)
                }
                6 -> {
                    dice_image_1.setImageResource(R.drawable.face_6)
                }
            }

            if(active_player_a)
            {
                score_player_a += random_number
                tvplayerA.text = score_player_a.toString()
                active_player_a = false
                active_player_b = true
                if(score_player_a >= 100)
                {
                    game_end_msg_default = resources.getText(R.string.game_player).toString()
                    game_end_msg = game_end_msg_default + " Player A"
                    game_player_text.text = game_end_msg
                    dice_image_1.isEnabled = false
                }
            }
            else{
                score_player_b += random_number
                tvplayerB.text = score_player_b.toString()
                active_player_a = true
                active_player_b = false
                if(score_player_b >= 100)
                {
                    game_end_msg_default = resources.getText(R.string.game_player).toString()
                    game_end_msg = game_end_msg_default + " Player B"
                    game_player_text.text = game_end_msg
                    dice_image_1.isEnabled = false
                }
            }

        }


    }
}
