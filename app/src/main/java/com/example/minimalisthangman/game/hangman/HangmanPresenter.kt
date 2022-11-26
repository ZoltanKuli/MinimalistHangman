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

    fun selectStartingOutStageImageResource() {
        dyingStageIndex = DEFAULT_DYING_STAGE_INDEX
        hangmanView.onImageResourceSelected(R.drawable.hangman___stage___starting_out)
    }

    fun selectOneLifeLessStageImageResource() {
        if (dyingStageIndex < dyingStages.size) {
            hangmanView.onImageResourceSelected(dyingStages[dyingStageIndex++])
        }
    }

    fun selectDeadStageImageResource() {
        hangmanView.onImageResourceSelected(R.drawable.hangman___stage___dead)
    }

    fun selectWonStageImageResource() {
        hangmanView.onImageResourceSelected(R.drawable.hangman___stage___won)
    }
}