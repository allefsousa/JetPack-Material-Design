package com.developer.allef.navigationjetcpack

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.developer.allef.navigationjetcpack.navigation_component.bottomnavigation.BottomNavigationActivity
import com.developer.allef.navigationjetcpack.navigation_component.drawernavigation.NavigationDrawerActivity
import com.developer.allef.navigationjetcpack.utils.CustomTypefaceSpan
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom.replaceMenu(R.menu.appbar_navigation)
        setSupportActionBar(bottom)
        bottom.setNavigationOnClickListener {
            val intent = Intent(this, NavigationDrawerActivity::class.java)
            startActivity(intent)
            finish()
        }
        floatingActionButt.setOnClickListener {
            val intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
            finish()
        }



        val spannable = SpannableString(titleview.text)
        val typeFace: Typeface = ResourcesCompat.getFont(this, R.font.mitr_regular)!!
        spannable.setSpan(CustomTypefaceSpan("", typeFace), 0, 7, Spanned.SPAN_EXCLUSIVE_INCLUSIVE) // mudando font
        spannable.setSpan(CustomTypefaceSpan("", typeFace), 25, 31, Spanned.SPAN_EXCLUSIVE_INCLUSIVE) // mudando font
        spannable.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimaryDark)), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimaryDark)), 25, 31, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        titleview.setText(spannable, TextView.BufferType.SPANNABLE)




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
          R.id.navigation_favorite ->{
              Toast.makeText(this,"Click Navigation Favorite",Toast.LENGTH_LONG).show()
          }
            R.id.navigation_home-> {
                Toast.makeText(this,"Click Navigation Home",Toast.LENGTH_LONG).show()
            }
        }

        return false
    }
}
