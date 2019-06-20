package com.developer.allef.navigationjetcpack.navigation_component.bottomnavigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.developer.allef.navigationjetcpack.R
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {
    private lateinit var navController : NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        setNavigationController()
    }
    private fun setNavigationController() {
        //Usando a helper class Navigation podemos encontrar o componente do NavController
        //Baseado no NavHostFragment que está hospedado em nosso Layout Principal
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        //Instanciamos o BottomNavigationView e setamos o controlador
        bottomNavigationView = findViewById(R.id.navigation)
        bottomNavigationView.setupWithNavController(navController)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Caso o Menu não seja navegável pelo Controlador, utilize o Listener padrão
        //Do menu.
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment))
                || super.onOptionsItemSelected(item)
    }
}
