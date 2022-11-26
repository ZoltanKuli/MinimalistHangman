package com.example.minimalisthangman.game.keyboard

import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import com.example.minimalisthangman.R
import com.example.minimalisthangman.game.GameActivity
import java.util.stream.Collectors
import kotlin.streams.asStream

class KeyboardView(private val gameActivity: GameActivity) : OnClickListener {

    private val buttons: List<Button> = collectKeyboardButtons()

    init {
        buttons.stream().forEach { button -> button.setOnClickListener(this) }
    }

    fun enableEveryButton() {
        buttons.forEach { button ->
            button.isEnabled = true
        }
    }

    override fun onClick(view: View?) {
        val button = view as Button

        button.isEnabled = false
        gameActivity.guessLetter(button.text.first())
    }

    private fun collectKeyboardButtons(): ArrayList<Button> {
        val keyboardButtons = ArrayList<Button>()

        val keyboard = gameActivity.findViewById<ConstraintLayout>(R.id.keyboardLayout)
        keyboard.children.asStream().map { keyboardRow -> keyboardRow as LinearLayout }
            .forEach { keyboardRow ->
                keyboardButtons.addAll(
                    keyboardRow.children.asStream().map { button -> button as Button }
                        .collect(Collectors.toList())
                )
            }

        return keyboardButtons
    }
}