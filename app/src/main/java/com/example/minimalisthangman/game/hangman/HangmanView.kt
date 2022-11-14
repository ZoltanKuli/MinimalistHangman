package com.example.minimalisthangman.game.hangman

import android.widget.ImageView
import com.example.minimalisthangman.R
import com.example.minimalisthangman.game.GameActivity

class HangmanView(gameActivity: GameActivity) {

    private val hangmanPresenter: HangmanPresenter = HangmanPresenter(this)

    private val hangmanImage: ImageView = gameActivity.findViewById(R.id.hangmanImageView)

    fun startOut() {
        hangmanPresenter.startOut()
    }

    fun loseLife() {
        hangmanPresenter.loseLife()
    }

    fun die() {
        hangmanPresenter.die()
    }

    fun win() {
        hangmanPresenter.win()
    }

    fun setHangmanImageResource(resId: Int) {
        hangmanImage.setImageResource(resId)
    }
}