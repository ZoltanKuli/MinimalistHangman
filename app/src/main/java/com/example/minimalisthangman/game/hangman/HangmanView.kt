package com.example.minimalisthangman.game.hangman

import android.widget.ImageView
import com.example.minimalisthangman.R
import com.example.minimalisthangman.game.GameActivity

class HangmanView(gameActivity: GameActivity) {

    private val hangmanImage: ImageView = gameActivity.findViewById(R.id.hangmanImageView)

    private val hangmanPresenter: HangmanPresenter = HangmanPresenter(this)

    fun onImageResourceSelected(resId: Int) {
        hangmanImage.setImageResource(resId)
    }

    fun displayStartingOutStage() {
        hangmanPresenter.selectStartingOutStageImageResource()
    }

    fun displayOneLifeLessStage() {
        hangmanPresenter.selectOneLifeLessStageImageResource()
    }

    fun displayDeadStage() {
        hangmanPresenter.selectDeadStageImageResource()
    }

    fun displayWonStage() {
        hangmanPresenter.selectWonStageImageResource()
    }
}