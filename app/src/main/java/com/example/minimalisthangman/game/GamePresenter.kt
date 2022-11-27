package com.example.minimalisthangman.game

import kotlin.properties.Delegates

class GamePresenter(private val gameActivity: GameActivity) {

    companion object {
        val DEFAULT_CHARACTER_TO_DISPLAY: (Int) -> Char = { '.' }
        const val MAXIMUM_NUMBER_OF_LIVES : Int = 7
    }

    private val gameDomain: GameDomain = GameDomain(gameActivity.applicationContext)

    private lateinit var wordToGuess: String
    private lateinit var wordToDisplay: CharArray
    private var charactersGuessed by Delegates.notNull<Int>()
    private var livesLeft by Delegates.notNull<Int>()

    fun startNewGame() {
        wordToGuess = gameDomain.getRandomWord()
        wordToDisplay = CharArray(wordToGuess.length, DEFAULT_CHARACTER_TO_DISPLAY)
        charactersGuessed = 0
        livesLeft = MAXIMUM_NUMBER_OF_LIVES

        gameActivity.onNewGame(String(wordToDisplay))
    }

    fun guessLetter(guessedLetter: Char) {
        if (0 < livesLeft && charactersGuessed < wordToGuess.length) {
            if (wordToGuess.contains(guessedLetter)) {
                updateWordToDisplay(guessedLetter)
                setGameActivityStateWhenGuessIsRight()
            } else {
                livesLeft--
                setGameActivityStateWhenGuessIsWrong()
            }
        }
    }

    private fun updateWordToDisplay(guessedLetter: Char) {
        wordToGuess.asSequence().forEachIndexed { index, c ->
            if (c == guessedLetter) {
                wordToDisplay[index] = guessedLetter
                charactersGuessed++
            }
        }
    }

    private fun setGameActivityStateWhenGuessIsRight() {
        if (charactersGuessed == wordToGuess.length) {
            gameActivity.onWordGuessed(String(wordToDisplay))
        } else {
            gameActivity.onRightGuess(String(wordToDisplay))
        }
    }

    private fun setGameActivityStateWhenGuessIsWrong() {
        if (0 < livesLeft) {
            gameActivity.onWrongGuess()
        } else {
            gameActivity.onFatalGuess(wordToGuess)
        }
    }
}