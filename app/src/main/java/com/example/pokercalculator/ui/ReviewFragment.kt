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

package com.example.pokercalculator.ui

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

import com.example.pokercalculator.R
import com.example.pokercalculator.controller.HandAdapter
import com.example.pokercalculator.controller.Round
import com.example.pokercalculator.model.Hand

/**
 * Demonstrates the use of [RecyclerView] with a [LinearLayoutManager]
 */
class ReviewFragment : Fragment() {

    lateinit private var mRecyclerView: RecyclerView
    lateinit private var mAdapter: HandAdapter
    lateinit private var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //TODO: organize into methods or paragraphs for readability
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.review_fragment, container, false)
        rootView.tag = TAG

        initRecyclerView(rootView)

        //This is the EditText view that is used for input string
        val editTextBox = rootView.findViewById(R.id.inputTextField) as EditText
        editTextBox.setOnEditorActionListener {_, _, _ ->
            enterAction(editTextBox.getText().toString())}

        //This is the bottom right floating action button
        val fab = rootView.findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            run {
                val focus = activity.currentFocus
                if (focus != null) {
                    val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(focus.windowToken, 0)
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
        }

        //TODO: Make it so virtual keyboard goes away when not in focus
        //TODO: Make it so virtual keyboard does not autocorrect
        //TODO: Create transition when typing in editfield
        //TODO: Ensure no memory leaks when activities and fragments are killed
        return rootView
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle?) {
        // Save currently selected layout manager.
        super.onSaveInstanceState(savedInstanceState)
    }

    private fun initRecyclerView(view: View) {
        mRecyclerView = view.findViewById(R.id.recyclerView) as RecyclerView

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = LinearLayoutManager(activity)
        mRecyclerView.layoutManager = mLayoutManager
        // Set HandAdapter as the adapter for RecyclerView.
        mAdapter = HandAdapter()
        mRecyclerView.adapter = mAdapter

        // Create Dividers for each list item
        val dividerItemDecoration = DividerItemDecoration(mRecyclerView.context,
                mLayoutManager.orientation)
        mRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    private fun enterAction(input: String):Boolean {
        //Create new Round that represents game state
        updateAdapter(Round(input))
        return true
    }

    private fun updateAdapter(round: Round) {
        mAdapter.swap(round)
    }

    companion object{
        private val TAG = "ReviewFragment"
        private val DATASET_COUNT = 9
        @JvmStatic fun newInstance(text: String): ReviewFragment {
            val f = ReviewFragment()
            val b = Bundle()
            b.putString("msg", text)

            f.setArguments(b)
            return f
        }
    }
}