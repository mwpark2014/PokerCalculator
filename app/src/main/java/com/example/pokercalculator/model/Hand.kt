package com.example.pokercalculator.model

/**
 * Created by Mason Park on 5/28/2017.
 */

//Hand is a collection of Cards.
//Each Hand must have two cards
data class Hand(val cardOne: Card, val cardTwo: Card) : HandInterface {
    private val cardArray: Array<Card>

    init {
        this.cardArray = arrayOf(cardOne, cardTwo)
    }
    override fun getHand(): Array<Card>? {
        return cardArray;
    }
}
