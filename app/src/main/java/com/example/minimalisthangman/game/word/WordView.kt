package com.example.minimalisthangman.game.word

import android.widget.TextView
import com.example.minimalisthangman.R
import com.example.minimalisthangman.game.GameActivity

class WordView(gameActivity: GameActivity) {

    private val hangmanImage: TextView = gameActivity.findViewById(R.id.word)

    fun displayWord(wordToDisplay: String) {
        hangmanImage.text = wordToDisplay
    }
}