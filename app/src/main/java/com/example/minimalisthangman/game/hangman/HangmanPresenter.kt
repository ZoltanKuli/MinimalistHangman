package com.example.minimalisthangman.game.hangman

import com.example.minimalisthangman.R

class HangmanPresenter(private val hangmanView: HangmanView) {

    companion object {
        const val DEFAULT_DYING_STAGE_INDEX: Int = 0
    }

    private val dyingStages: List<Int> = listOf(
        R.drawable.hangman___stage___dying_1,
        R.drawable.hangman___stage___dying_2,
        R.drawable.hangman___stage___dying_3,
        R.drawable.hangman___stage___dying_4,
        R.drawable.hangman___stage___dying_5,
        R.drawable.hangman___stage___dying_6
    )

    private var dyingStageIndex: Int = DEFAULT_DYING_STAGE_INDEX

    fun startOut() {
        dyingStageIndex = DEFAULT_DYING_STAGE_INDEX
        hangmanView.setHangmanImageResource(R.drawable.hangman___stage___starting_out)
    }

    fun loseLife() {
        if (dyingStageIndex < dyingStages.size) {
            hangmanView.setHangmanImageResource(dyingStages[dyingStageIndex++])
        }
    }

    fun die() {
        hangmanView.setHangmanImageResource(R.drawable.hangman___stage___dead)
    }

    fun win() {
        hangmanView.setHangmanImageResource(R.drawable.hangman___stage___won)
    }
}