@file:JvmName("ExtensionsUtils")
// Use it in this way in Java:
// ExtensionsUtils.inflate(container, R.layout.news_fragment);

package com.example.strongheart.lexi.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by strongheart on 11/5/17.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}