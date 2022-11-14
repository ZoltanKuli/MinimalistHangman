package com.example.minimalisthangman.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minimalisthangman.R
import com.example.minimalisthangman.game.hangman.HangmanView
import com.example.minimalisthangman.game.keyboard.KeyboardView
import com.example.minimalisthangman.game.word.WordView

class GameActivity : AppCompatActivity() {

    private lateinit var gamePresenter: GamePresenter
    private lateinit var keyboardView: KeyboardView
    private lateinit var wordView: WordView
    private lateinit var hangmanView: HangmanView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        gamePresenter = GamePresenter(this)
        keyboardView = KeyboardView(this)
        wordView = WordView(this)
        hangmanView = HangmanView(this)
    }

    fun selectLetter(letter: Char) {
        hangmanView.loseLife()
    }
}