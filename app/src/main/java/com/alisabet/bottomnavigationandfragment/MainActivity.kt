package com.alisabet.bottomnavigationandfragment

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //1.bottoms are in menu folder
    //2.design fragments
    //3.delete textview in main activity and it's layout and replace
    //4.write code below
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        //code to change fragments
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        when (item.itemId) {
            R.id.navigation_home -> {
                transaction.replace(R.id.container, HomeFragment.newInstance()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                transaction.replace(R.id.container, DashboardFragment.newInstance()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                transaction.replace(R.id.container, NotificationFragment.newInstance()).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, HomeFragment.newInstance()).commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
