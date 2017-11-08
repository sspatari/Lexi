package com.example.strongheart.lexi.features.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.strongheart.lexi.R
import com.example.strongheart.lexi.commons.adapter.ViewType
import com.example.strongheart.lexi.commons.adapter.ViewTypeDelegateAdapter
import com.example.strongheart.lexi.commons.inflate

/**
 * Created by strongheart on 11/6/17.
 */
class TextInputDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.text_input_layout)
    )
}