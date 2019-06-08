package com.developer.allef.navigationjetcpack

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//       this@MainActivity.setSupportActionBar(bottom)
        bottom.replaceMenu(R.menu.appbar_navigation)


        val spannable = SpannableString(titleview.text)
        val typeFace: Typeface = ResourcesCompat.getFont(this, R.font.mitr_regular)!!
        spannable.setSpan(CustomTypefaceSpan("", typeFace), 0, 7, Spanned.SPAN_EXCLUSIVE_INCLUSIVE) // mudando font
        spannable.setSpan(CustomTypefaceSpan("", typeFace), 25, 31, Spanned.SPAN_EXCLUSIVE_INCLUSIVE) // mudando font
        spannable.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimaryDark)), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimaryDark)), 25, 31, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        titleview.setText(spannable, TextView.BufferType.SPANNABLE)


    }
}
