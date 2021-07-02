package com.example.theoldladygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var count : Int = 0
    private lateinit var topLeft  : Button
    private lateinit var topMid   : Button
    private lateinit var topRight : Button
    private lateinit var midLeft  : Button
    private lateinit var midMid   : Button
    private lateinit var midRight : Button
    private lateinit var botLeft  : Button
    private lateinit var botMid   : Button
    private lateinit var botRight : Button

    private var array = arrayListOf<Button>()
    private lateinit var playAgain : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topLeft  = findViewById(R.id.topLeft)
        topMid   = findViewById(R.id.topMid)
        topRight = findViewById(R.id.topRight)
        midLeft  = findViewById(R.id.midLeft)
        midMid   = findViewById(R.id.midMid)
        midRight = findViewById(R.id.midRight)
        botLeft  = findViewById(R.id.botLeft)
        botMid   = findViewById(R.id.botMid)
        botRight = findViewById(R.id.botRight)


        array = arrayListOf(topLeft, topMid, topRight, midLeft, midMid, midRight, botLeft, botMid, botRight)

        initGame()

        playAgain = findViewById(R.id.Play)
        playAgain.setOnClickListener { restart()}
    }

    private fun game(button: Button){
        if(button.text ==  "") {
            if (count % 2 == 0) {
                button.text = "X"
                verifyWinner(1)
            } else {
                button.text = "O"
                verifyWinner(2)
            }
            count++
        }
    }

    private fun initListener(button: Button){
        button.setOnClickListener {
            game(button)
        }
    }

    private fun initGame(){
        for(x in 0 until array.size){
            initListener(array[x])
        }
    }

    private fun verifyWinner(key:Int) {
        when(count > -1) {
            (array[0].text == array[1].text && array[0].text == array[2].text && array[0].text != "") ->
                return gameWinner(key)

            (array[3].text == array[4].text && array[3].text == array[5].text && array[3].text != "") ->
                return gameWinner(key)

            (array[6].text == array[7].text && array[6].text == array[8].text && array[6].text != "") ->
                return gameWinner(key)

            (array[0].text == array[3].text && array[0].text == array[6].text && array[0].text != "") ->
                return gameWinner(key)

            (array[1].text == array[4].text && array[1].text == array[7].text && array[1].text != "") ->
                return gameWinner(key)

            (array[2].text == array[5].text && array[2].text == array[8].text && array[2].text != "") ->
                return gameWinner(key)

            (array[0].text == array[4].text && array[0].text == array[8].text && array[0].text != "") ->
                return gameWinner(key)

            (array[2].text == array[4].text && array[2].text == array[6].text && array[2].text != "") ->
                return gameWinner(key)
        }
    }

    private fun gameWinner(key:Int){
        return Toast.makeText(this, "Player $key wins", Toast.LENGTH_SHORT).show()
    }

    private fun restart(){
        count = 0
        for (x in 0 until array.size){
            array[x].text = ""
        }
    }

}

