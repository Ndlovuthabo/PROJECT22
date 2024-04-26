package com.example.myapplication22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class TamagotchiApp : AppCompatActivity() {

    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tamagotchi_app)

        //Get the button and Text view
        val btnFeed = findViewById<Button>(R.id.btn_feed)
        val btnClean = findViewById<Button>(R.id.btn_clean)
        val btnPlay = findViewById<Button>(R.id.btn_play)
        val txtHunger = findViewById<EditText>(R.id.petHungry)
        val txtClean = findViewById<EditText>(R.id.petClean)
        val txtHappy = findViewById<EditText>(R.id.petHappy)
        val petImage = findViewById<ImageView>(R.id.pet_image)

        //Set the initial text values
        txtHunger.setText(petHealth.toString())
        txtClean.setText(petHunger.toString())
        txtHappy.setText(petCleanliness.toString())

        //Handle button clicks
        petHunger -= 10
        petHealth += 10
        petCleanliness += 5
        txtHunger.setText(petHunger.toString())
        animateImageChange(petImage, R.drawable.dog_eating)

        btnClean.setOnClickListener {
            petCleanliness += 10
            petHealth += 10

            txtClean.setText(petCleanliness.toString())
            animateImageChange(petImage, R.drawable.dog_cleaning_icon)
        }

        btnPlay.setOnClickListener {
            petHealth += 10
            petHunger += 5
            petCleanliness -= 5
            txtHappy.setText(petHealth.toString())
            animateImageChange(petImage, R.drawable.happy_dog_icon)
        }
    }

    private fun animateImageChange(imageView: ImageView, newImageResource: Int) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)

    }
}