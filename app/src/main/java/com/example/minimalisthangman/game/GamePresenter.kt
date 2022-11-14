package com.example.minimalisthangman.game

class GamePresenter(private val gameActivity: GameActivity) {

    private val gameDomain: GameDomain = GameDomain(gameActivity.applicationContext)

    private var wordToGuess: String = gameDomain.getRandomWord()

    init {
        println("The word to guess is: $wordToGuess")
    }
}