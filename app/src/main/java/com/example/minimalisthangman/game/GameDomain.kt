package com.example.minimalisthangman.game

import android.content.Context
import com.google.gson.Gson
import java.io.InputStreamReader
import kotlin.random.Random

class GameDomain(private val context: Context) {

    companion object {
        const val WORDS_JSON_FILE_NAME: String = "words.json"
    }

    private val words: List<String> = loadWords()

    fun getRandomWord(previousWord: String? = null): String {
        while (true) {
            val word = words[Random.nextInt(0, words.size)]
            if (words.size <= 1 || previousWord != word) {
                return word
            }
        }
    }

    private fun loadWords(): List<String> {
        InputStreamReader(context.assets.open(WORDS_JSON_FILE_NAME)).use {
            return Gson().fromJson(it, Words::class.java).words
        }
    }

    private data class Words(val words: List<String>)
}