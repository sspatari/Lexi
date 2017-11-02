package com.example.strongheart.lexi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.setHasFixedSize(true)
        val myDataset= Array(20, {x -> x.toString()})
        my_recycler_view.adapter = MyAdapter(myDataset)

    }
}
