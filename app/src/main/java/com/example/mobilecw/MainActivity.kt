package com.example.mobilecw

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aboutButton= findViewById<Button>(R.id.aboutBtn)
        val newGameButton = findViewById<Button>(R.id.newBtn)

        // Starts a new game
        newGameButton.setOnClickListener {
            val intent= Intent(this, SetTargetScore::class.java)
            startActivity(intent)
        }

        // Pop up
        aboutButton.setOnClickListener {
            val popupBinding = layoutInflater.inflate(R.layout.about_pop_up,null)

            val popDialog = Dialog(this)
            popDialog.setContentView(popupBinding)

            popDialog.setCancelable(true)
            popDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            popDialog.show()

            val submitButton = popupBinding.findViewById<Button>(R.id.popup_btn)

            submitButton.setOnClickListener {
                popDialog.dismiss()
            }
        }

    }
}