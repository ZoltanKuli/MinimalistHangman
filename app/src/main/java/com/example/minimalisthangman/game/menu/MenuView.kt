package com.example.minimalisthangman.game.menu

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import com.example.minimalisthangman.R
import com.example.minimalisthangman.game.GameActivity


class MenuView(private val gameActivity: GameActivity) : View.OnClickListener {

    private val newGameButton: ImageButton = gameActivity.findViewById(R.id.newGameButton)
    private val newGameButtonAnimation: Animation =
        AnimationUtils.loadAnimation(gameActivity.applicationContext, R.anim.new_game_button_rotate)

    init {
        newGameButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        newGameButton.startAnimation(newGameButtonAnimation)
        gameActivity.startNewGame()
    }
}