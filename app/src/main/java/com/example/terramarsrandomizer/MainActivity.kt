package com.example.terramarsrandomizer

import android.content.pm.ActivityInfo
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random

var myList: MutableList<Int> = mutableListOf<Int> (R.drawable.tm1, R.drawable.tm2, R.drawable.tm3,
    R.drawable.tm4, R.drawable.tm5, R.drawable.tm6, R.drawable.tm7, R.drawable.tm8,
    R.drawable.tm9, R.drawable.tm10, R.drawable.tm11, R.drawable.tm12, R.drawable.tm13,
    R.drawable.tm14, R.drawable.tm15, R.drawable.tm16, R.drawable.tm17, R.drawable.tm18,
    R.drawable.tm19, R.drawable.tm20, R.drawable.tm21, R.drawable.tm22, R.drawable.tm23,
    R.drawable.tm24, R.drawable.tm25, R.drawable.tm26, R.drawable.tm27, R.drawable.tm28,
    R.drawable.tm29, R.drawable.tm30, R.drawable.tm31, R.drawable.tm32, R.drawable.tm33,
    R.drawable.tm34, R.drawable.tm35)

var tempList = mutableListOf<Int>()

var imageCount = 0
var imageSize = 35

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        val btnClick = findViewById<Button>(R.id.button) as Button
        val image3Click = findViewById<ImageView>(R.id.imageView3) as ImageView
        val image4Click = findViewById<ImageView>(R.id.imageView4) as ImageView
        val image5Click = findViewById<ImageView>(R.id.imageView5) as ImageView
        val image6Click = findViewById<ImageView>(R.id.imageView6) as ImageView

        btnClick.setOnClickListener()
        {
                tempList.addAll(myList)
                DrawCards()
                tempList.clear()
                imageCount = 4
                imageSize = 35
        }

        image3Click.setOnClickListener()
        {
            if(imageCount > 2)
            {
                image3Click.setBackgroundResource(0)
                imageCount = imageCount - 1
            }
        }
        image4Click.setOnClickListener()
        {
            if(imageCount > 2)
            {
                image4Click.setBackgroundResource(0)
                imageCount = imageCount - 1
            }
        }
        image5Click.setOnClickListener()
        {
            if(imageCount > 2)
            {
                image5Click.setBackgroundResource(0)
                imageCount = imageCount - 1
            }
        }
        image6Click.setOnClickListener()
        {
            if(imageCount > 2)
            {
                image6Click.setBackgroundResource(0)
                imageCount = imageCount - 1
            }
        }

        editText.setOnClickListener()
        {
            if(editText.getText().toString() != "")
            {
                button.isEnabled = true
            }
        }

    }

    fun DrawCards()
    {
        var ranValue = 0
        val seedTxt = editText.getText().toString()
        val seed = Integer.parseInt(seedTxt)
        val playerId = spinner.selectedItem
        var drawnIndex: MutableList<Int> = mutableListOf<Int>()

        var drawnCards = 0
        while(drawnCards < 16)
        {
            ranValue = getRandomInt(Random(seed))
            drawnIndex.add(tempList[ranValue])
            tempList.removeAt(ranValue)
            imageSize = imageSize - 1
            drawnCards = drawnCards + 1
        }

        if(playerId == "Player 1")
        {
            imageView3.setBackgroundResource(drawnIndex[0])
            imageView4.setBackgroundResource(drawnIndex[1])
            imageView5.setBackgroundResource(drawnIndex[2])
            imageView6.setBackgroundResource(drawnIndex[3])
        }
        else if(playerId == "Player 2")
        {
            imageView3.setBackgroundResource(drawnIndex[4])
            imageView4.setBackgroundResource(drawnIndex[5])
            imageView5.setBackgroundResource(drawnIndex[6])
            imageView6.setBackgroundResource(drawnIndex[7])
        }
        else if(playerId == "Player 3")
        {
            imageView3.setBackgroundResource(drawnIndex[8])
            imageView4.setBackgroundResource(drawnIndex[9])
            imageView5.setBackgroundResource(drawnIndex[10])
            imageView6.setBackgroundResource(drawnIndex[11])
        }
        else
        {
            imageView3.setBackgroundResource(drawnIndex[12])
            imageView4.setBackgroundResource(drawnIndex[13])
            imageView5.setBackgroundResource(drawnIndex[14])
            imageView6.setBackgroundResource(drawnIndex[15])
        }
    }

    fun getRandomInt(random: Random): Int
    {
        return random.nextInt(1,imageSize)
    }

}
