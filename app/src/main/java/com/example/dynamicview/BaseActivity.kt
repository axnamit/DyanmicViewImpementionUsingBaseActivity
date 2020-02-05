package com.example.dynamicview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity : AppCompatActivity() {

    var bottomNavigation: BottomNavigationView? = null

    abstract val layoutRes: Int
    // get() = R.layout.activity_base
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        rootLayout.let {
            it.addView(layoutInflater.inflate(layoutRes, null, false))
        }
        bottomNavigation = findViewById(R.id.bottom_navigation)

        bottomNavigation?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }


    //rootLayout.addView(layoutInflater.inflate(layoutRes,null,false))



private val mOnNavigationItemSelectedListener =
    BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.navigation_home -> {
                Toast.makeText(
                    this
                    , "homeclicked", Toast.LENGTH_SHORT
                ).show()

            }
            R.id.navigation_sms -> {
                Toast.makeText(
                    this
                    , "navigation_sms", Toast.LENGTH_SHORT
                ).show()

            }
            R.id.navigation_notifications -> {
                Toast.makeText(
                    this
                    , "navigation_notifications", Toast.LENGTH_SHORT
                ).show()
            }
        }
        false
    }
}