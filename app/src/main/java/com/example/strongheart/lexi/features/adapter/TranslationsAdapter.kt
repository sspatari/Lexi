package com.example.strongheart.lexi.features.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.strongheart.lexi.commons.SearchedTranslationsItem
import com.example.strongheart.lexi.commons.adapter.AdapterConstants
import com.example.strongheart.lexi.commons.adapter.ViewType
import com.example.strongheart.lexi.commons.adapter.ViewTypeDelegateAdapter


/**
 * Created by strongheart on 10/30/17.
 */

class TranslationsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    private val languageSelectionItem = object : ViewType {
        override fun getViewType(): Int {
            return AdapterConstants.LANGUAGE_SELECTION
        }
    }

    private val textInputItem = object : ViewType {
        override fun getViewType(): Int {
            return AdapterConstants.TEXT_INPUT
        }
    }

    init {
        delegateAdapters.put(AdapterConstants.LANGUAGE_SELECTION, LanguageSelectionDelegateAdapter())
        delegateAdapters.put(AdapterConstants.TEXT_INPUT, TextInputDelegateAdapter())
        delegateAdapters.put(AdapterConstants.SEARCHED_TRANSLATION, SearchedTranslationsDelegateAdapter())

        items = ArrayList()
        items.add(languageSelectionItem)
        items.add(textInputItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return this.items.get(position).getViewType()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addSearchedTranslations(searchedTranslations: List<SearchedTranslationsItem>) {
        val initposition = items.size - 1
        items.addAll(searchedTranslations)
        notifyItemRangeInserted(initposition, initposition + searchedTranslations.size)
    }

}