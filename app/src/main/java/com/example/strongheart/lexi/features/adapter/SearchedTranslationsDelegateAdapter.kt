package com.example.strongheart.lexi.features.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.strongheart.lexi.R
import com.example.strongheart.lexi.commons.SearchedTranslationsItem
import com.example.strongheart.lexi.commons.adapter.ViewType
import com.example.strongheart.lexi.commons.adapter.ViewTypeDelegateAdapter
import com.example.strongheart.lexi.commons.inflate
import kotlinx.android.synthetic.main.searched_translations_layout.view.*

/**
 * Created by strongheart on 11/7/17.
 */
class SearchedTranslationsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as SearchedTranslationsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.searched_translations_layout)) {

        fun bind(item: SearchedTranslationsItem) = with(itemView) {
            translatedText.text = item.translatedText
            translationOfText.text = item.translationOfText
        }
    }
}