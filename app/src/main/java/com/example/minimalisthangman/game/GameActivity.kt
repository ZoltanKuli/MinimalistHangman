package com.example.minimalisthangman.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minimalisthangman.R
import com.example.minimalisthangman.game.hangman.HangmanView
import com.example.minimalisthangman.game.keyboard.KeyboardView
import com.example.minimalisthangman.game.word.WordView

class GameActivity : AppCompatActivity() {

    private lateinit var keyboardView: KeyboardView
    private lateinit var wordView: WordView
    private lateinit var hangmanView: HangmanView
    private lateinit var gamePresenter: GamePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        keyboardView = KeyboardView(this)
        wordView = WordView(this)
        hangmanView = HangmanView(this)
        gamePresenter = GamePresenter(this)

        gamePresenter.startNewGame()
    }

    fun onNewGame(wordToDisplay: String) {
        wordView.displayWord(wordToDisplay)
        hangmanView.displayStartingOutStage()
    }

    fun onWrongGuess() {
        hangmanView.displayOneLifeLessStage()
    }

    fun onFatalGuess(wordToDisplay: String) {
        keyboardView.disableEveryButton()
        wordView.displayWord(wordToDisplay)
        hangmanView.displayDeadStage()
    }

    fun onRightGuess(wordToDisplay: String) {
        wordView.displayWord(wordToDisplay)
    }

    fun onWordGuessed(wordToDisplay: String) {
        keyboardView.disableEveryButton()
        wordView.displayWord(wordToDisplay)
        hangmanView.displayWonStage()
    }

    fun startNewGame() {
        keyboardView.enableEveryButton()
        gamePresenter.startNewGame()
    }

    fun guessLetter(guessedLetter: Char) {
        gamePresenter.guessLetter(guessedLetter)
    }
}