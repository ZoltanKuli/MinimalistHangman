package com.example.minimalisthangman.game

import kotlin.properties.Delegates

class GamePresenter(private val gameActivity: GameActivity) {

    companion object {
        val WORD_TO_DISPLAY_INIT: (Int) -> Char = { '.' }
        const val VALUE_TO_DISPLAY_BY_DEFAULT: Char = '-'
        const val MAXIMUM_NUMBER_OF_LIVES: Int = 7
    }

    private val gameDomain: GameDomain = GameDomain(gameActivity.applicationContext)

    private lateinit var wordToGuess: String
    private lateinit var wordToDisplay: CharArray
    private var charactersGuessed by Delegates.notNull<Int>()
    private var livesLeft by Delegates.notNull<Int>()

    fun startNewGame() {
        wordToGuess = gameDomain.getRandomWord(
            if (this::wordToGuess.isInitialized) wordToGuess else null
        )
        wordToDisplay = CharArray(wordToGuess.length, WORD_TO_DISPLAY_INIT)
        charactersGuessed = 0
        livesLeft = MAXIMUM_NUMBER_OF_LIVES

        updateWordToDisplay(VALUE_TO_DISPLAY_BY_DEFAULT)

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

    private fun updateWordToDisplay(valueToAdd: Char) {
        wordToGuess.asSequence().forEachIndexed { index, c ->
            if (c == valueToAdd) {
                wordToDisplay[index] = valueToAdd
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