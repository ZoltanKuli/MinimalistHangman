package com.example.minimalisthangman.game

class GamePresenter(private val gameActivity: GameActivity) {

    private val gameDomain: GameDomain = GameDomain(gameActivity.applicationContext)

    private lateinit var wordToGuess: String
    private lateinit var guessedLetters: CharArray

    fun startNewGame() {
        wordToGuess = gameDomain.getRandomWord()
        guessedLetters = CharArray(wordToGuess.length)
        println(wordToGuess)
        println(guessedLetters)
        gameActivity.onNewGame(guessedLetters.toString())
    }
}