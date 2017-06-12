package com.example.pokercalculator.controller

/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pokercalculator.R
import com.example.pokercalculator.model.Hand
import com.example.pokercalculator.ui.ReviewFragment

import java.util.ArrayList

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
//TODO: Work on what to display at each list item
class HandAdapter : RecyclerView.Adapter<HandAdapter.ViewHolder>() {

    private var mDataSet: ArrayList<Hand>? = null

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener { Log.i(TAG, "Element $adapterPosition clicked.") }
            textView = v.findViewById(R.id.textView) as TextView
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     */
    init {
        mDataSet = null
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item, viewGroup, false)

        return ViewHolder(v)
    }

    //Update the data, which is mDataset: Hand[]
    fun swap(round: Round) {
        mDataSet = round.mHands
        notifyDataSetChanged()
    }

    //Update the data, which is mDataset: Hand[]
    fun removeItem(position: Int) {
        notifyItemRemoved(position)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the contents of the view
        // with that element
//        val arrayString = mDataSet?.map { value -> value.toString() }
//        Log.d(TAG, arrayString?.reduce { total, f -> total + " " + f })

        viewHolder.textView.setText(mDataSet?.let { it[position].toString() })
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return mDataSet?.size ?: 0
    }

    companion object {
        private val TAG = "HandAdapter"
    }
}