package com.example.minimalisthangman.game.menu

import android.view.View
import android.widget.ImageButton
import com.example.minimalisthangman.R
import com.example.minimalisthangman.game.GameActivity

class MenuView(private val gameActivity: GameActivity) : View.OnClickListener {

    private val newGameButton: ImageButton = gameActivity.findViewById(R.id.newGameButton)

    init {
        newGameButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        gameActivity.startNewGame()
    }
}