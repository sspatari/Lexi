package com.example.strongheart.lexi

import android.content.ClipData.Item
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


/**
 * Created by strongheart on 10/30/17.
 */

class MyAdapter(private val items: Array<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                when(viewType) {
                        0 -> R.layout.select_language_button_layout
                        1 -> R.layout.input_field_layout
                        else -> R.layout.translated_word_layout
                    }, parent, false)
        view.setOnClickListener(){
                Toast.makeText(view.context, "View clicked",
                        Toast.LENGTH_LONG).show()
            }

        return when(viewType) {
            0 -> LangViewHolder(view)
            1 -> InputViewHolder(view)
            else -> TranslatedWordViewHolder(view)
        }
    }

    override fun onBindViewHolder(myViewHolder: RecyclerView.ViewHolder, i: Int) {
        when(myViewHolder.itemViewType) {
            0 -> run { var langViewHolder: LangViewHolder = myViewHolder as LangViewHolder }
            1 -> run { var inputViewHolder: InputViewHolder = myViewHolder as InputViewHolder }
            else -> run { val translatedWordViewHolder: TranslatedWordViewHolder = myViewHolder as TranslatedWordViewHolder
                            translatedWordViewHolder.translatedText.setText(items[i-2])}
        }
    }

//        myViewHolder.btnButton1.setOnClickListener(View.OnClickListener {
//            /// button click event
//        })

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> 0
            1 -> 1
            else -> 2
        }
    }

    override fun getItemCount(): Int {
        return items.size + 2
    }

    class LangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var firstLangButton: Button
        lateinit var swapLangButton: ImageButton
        lateinit var secondLangButton: Button

        init {

            firstLangButton = itemView.findViewById<Button>(R.id.firstLangButton)
            swapLangButton = itemView.findViewById<ImageButton>(R.id.swapLangButton)
            secondLangButton = itemView.findViewById<Button>(R.id.secondLangButton)
        }

    }

    class InputViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var inputText: EditText

        init {
            inputText = itemView.findViewById(R.id.inputText)
        }
    }

    class TranslatedWordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var translatedText: TextView
        var translationOfText: TextView

        init {
            translatedText = itemView.findViewById(R.id.translatedText)
            translatedText.setOnClickListener{
                Toast.makeText(translatedText.context, "TranslatedText Clicked",
                        Toast.LENGTH_LONG).show()
            }
            translationOfText = itemView.findViewById(R.id.translationOfText)

        }
    }
}