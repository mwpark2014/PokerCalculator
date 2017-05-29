package com.example.pokercalculator

import android.util.Log

/**
 * Created by Mason Park on 5/28/2017.
 */

//Construct round of Texas Hold'Em from parsing inputString:string
class Round(inputString: String?) {
    private var cardsDealt: Array<Array<Card>>? = null
    private val mHands: ArrayList<Hand> = ArrayList<Hand>()

    init {
        Log.i(LOG_TAG, "Initiated with " + inputString)
        parseInput(inputString)
    }

    private fun parseInput(inputString: String?): Array<String>? {
        val cleanString = sanitizeString(inputString);
        if(cleanString == null)
            return null;
        val hands = cleanString.split("-")
        for(i:String in hands.iterator()) {
            val playerHand = Hand();
            mHands.add(playerHand);
            for(c in i) {
                Log.i(LOG_TAG, "" + c)
                playerHand.mCardOne;
            }
        }
        return null;
    }

    //Take in inputString and get rid of white spaces. If invalid input, throw exception
    private fun sanitizeString(inputString: String?): String? {
        //TODO: Throw exception if invalid string
        val outputString = inputString?.trim();
        return inputString;
    }

    private fun setHands() {

    }

    companion object {
        private val NUM_SUITS = 4
        private val NUM_RANKS = 13
        private val LOG_TAG = "Round tag:"
    }
}
