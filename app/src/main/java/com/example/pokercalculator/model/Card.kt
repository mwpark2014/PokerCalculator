package com.example.pokercalculator.model

/**
 * Created by Mason Park on 5/28/2017.
 */

data class Card(val rankChar: Char, val suitChar: Char) {
    private val rank: Int
    private val suit: Int

    //Initialization, throw error if invalid
    init {
        when(rankChar) {
            in '2'..'9' -> this.rank = rankChar.toInt()
            't' -> this.rank = TEN;
            'j' -> this.rank = JACK;
            'q' -> this.rank = QUEEN;
            'k' -> this.rank = KING;
            'a' -> this.rank = ACE;
            else -> throw IllegalArgumentException("Invalid Hand Rank")
        }
        when(suitChar) {
            'd' -> this.suit = DIAMOND;
            's' -> this.suit = SPADE;
            'c' -> this.suit = CLUB;
            'h' -> this.suit = HEART;
            else -> throw IllegalArgumentException("Invalid Suit Rank")
        }
    }

    companion object {
        //Rank Constants
        private const val TEN = 10
        private const val JACK = 11
        private const val QUEEN = 12
        private const val KING = 13
        private const val ACE = 14
        //Suit Constants
        private const val DIAMOND = 0
        private const val SPADE = 1
        private const val CLUB = 2
        private const val HEART = 3
    }

}
