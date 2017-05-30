package com.example.pokercalculator.model

/**
 * Created by Mason Park on 5/29/2017.
 */

//SharedHand is a collection of Cards.
//Cards 1-3 are required. Cards 4-5 can be null.
data class SharedHand(val cardOne: Card, val cardTwo: Card, val cardThree: Card,
                 val cardFour: Card?, val cardFive: Card?) : HandInterface {
    private val cardArray: Array<Card>;

    init {
        //@Test cardFive == null
        if (cardFour == null)
            this.cardArray = arrayOf(cardOne, cardTwo, cardThree)
        else if (cardFive == null)
            this.cardArray = arrayOf(cardOne, cardTwo, cardThree, cardFour)
        else
            this.cardArray = arrayOf(cardOne, cardTwo, cardThree, cardFour, cardFive)
    }
    override fun getHand(): Array<Card>? {
        return cardArray;
    }
}
