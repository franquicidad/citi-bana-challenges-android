package com.franco.gridexercise

import android.app.Activity
import android.os.Bundle
import android.widget.*


class GridActivity : Activity() {

    private var alphabets = arrayListOf(
        "A", "B", "C", "D", "E",
        "F", "G", "H", "I", "J",
        "K", "L", "M", "N", "O",
        "P", "Q", "R", "S", "T",
        "U", "V", "W", "X"
    )
    private lateinit var relativeLayout: RelativeLayout

    lateinit var arrayAdapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, alphabets)
        relativeLayout = RelativeLayout(this)
        var param: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            100
        );
        val gridView = GridView(this)

        gridView.layoutParams =
            AbsListView.LayoutParams(
                GridLayout.LayoutParams.WRAP_CONTENT,
                GridLayout.LayoutParams.WRAP_CONTENT
            )
        gridView.numColumns = 4

        gridView.adapter = arrayAdapter

        relativeLayout.addView(gridView)

        setContentView(relativeLayout, param)
    }
}