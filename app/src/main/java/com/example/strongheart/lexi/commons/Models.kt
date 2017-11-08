package com.example.strongheart.lexi.commons

import com.example.strongheart.lexi.commons.adapter.AdapterConstants
import com.example.strongheart.lexi.commons.adapter.ViewType

/**
 * Created by strongheart on 11/7/17.
 */
data class SearchedTranslationsItem(
    val translatedText: String,
    val translationOfText: String
) : ViewType {
    override fun getViewType() = AdapterConstants.SEARCHED_TRANSLATION
}