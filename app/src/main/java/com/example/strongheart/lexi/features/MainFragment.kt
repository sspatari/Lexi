package com.example.strongheart.lexi.features

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.strongheart.lexi.MyAdapter
import com.example.strongheart.lexi.R
import com.example.strongheart.lexi.commons.inflate
import kotlinx.android.synthetic.main.main_fragment.*

/**
 * Created by strongheart on 11/5/17.
 */
class MainFragment: Fragment() {
    private var itemsList: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.main_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        my_recycler_view.layoutManager = LinearLayoutManager(context)
        my_recycler_view.setHasFixedSize(true)

        val myDataset= Array(100, {x -> x.toString()})
        my_recycler_view.adapter = MyAdapter(myDataset)
    }
}