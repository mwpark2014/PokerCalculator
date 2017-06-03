package com.example.pokercalculator.controller

import android.util.Log
import com.example.pokercalculator.model.Card
import com.example.pokercalculator.model.Hand
import com.example.pokercalculator.model.SharedHand

/**
 * Created by Mason Park on 5/28/2017.
 */

//Construct round of Texas Hold'Em from parsing inputString:string
class Round(inputString: String?) {
    private var cardsDealt: Array<Array<Card>>? = null
    val mHands = ArrayList<Hand>()
    var mShared: SharedHand? = null

    init {
        Log.i(LOG_TAG, "Initiated with " + inputString)
        parseInput(inputString)
    }

    private fun parseInput(str: String?): Array<String>? {
        val cleanString = sanitizeString(str);
        if(cleanString == null)
            return null

        //List of all input strings corresponding to Hands separated by '-'
        val hands = cleanString.split("-")
        for(i:String in hands.iterator()) {
            if(i[0] == 's')
                mShared = parseSharedCards(i)
            else
                mHands.add(parseHoleCards(i))
        }
        return null
    }

    //Create Hand from str
    private fun parseHoleCards(str: String): Hand
    {
        val cardOne = Card(str[0], str[1])
        val cardTwo = Card(str[2], str[3])
        val hand = Hand(cardOne, cardTwo)
        return hand
    }

    //Create SharedHand from str
    private fun parseSharedCards(str: String): SharedHand
    {
        val cardOne = Card(str[1], str[2])
        val cardTwo = Card(str[3], str[4])
        val cardThree = Card(str[5], str[6])
        val hand = SharedHand(cardOne, cardTwo, cardThree, null, null)
        return hand
    }

    //Take in inputString and get rid of white spaces. If invalid input, throw exception
    //Capitalize string
    private fun sanitizeString(input: String?): String? {
        //TODO: Throw exception if invalid string
        //TODO: Uppercase string
        val output = input?.trim()
        return output
    }

    private fun setHands() {

    }

    companion object {
        private const val NUM_SUITS = 4
        private const val NUM_RANKS = 13
        private const val LOG_TAG = "Round tag:"
    }
}
