package com.example.strongheart.lexi.features

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.strongheart.lexi.R
import com.example.strongheart.lexi.commons.SearchedTranslationsItem
import com.example.strongheart.lexi.commons.inflate
import com.example.strongheart.lexi.features.adapter.TranslationsAdapter
import kotlinx.android.synthetic.main.main_fragment.*

/**
 * Created by strongheart on 11/5/17.
 */
class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.main_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_list.layoutManager = LinearLayoutManager(context)
        recycler_list.setHasFixedSize(true)

        initAdapter()

        if(savedInstanceState == null) {
            val searchedTranslations = mutableListOf<SearchedTranslationsItem>()
            for(i in 1..100) {
                searchedTranslations.add(SearchedTranslationsItem(
                        "text$i",
                        "translation$i"
                ))
            }
            (recycler_list.adapter as TranslationsAdapter).addSearchedTranslations(searchedTranslations)
        }
    }

    private fun initAdapter() {
        if(recycler_list.adapter == null) {
//            val myDataset= Array(100, {x -> x.toString()})
            recycler_list.adapter = TranslationsAdapter()
        }
    }
}