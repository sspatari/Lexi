package com.example.strongheart.lexi.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by strongheart on 11/5/17.
 */
interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView

    fun onBindViewHolder(holder: RecyclerView, item: ViewType)
}