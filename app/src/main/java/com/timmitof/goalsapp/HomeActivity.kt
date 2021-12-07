package com.timmitof.goalsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.timmitof.goalsapp.fragments.CalendarFragment
import com.timmitof.goalsapp.fragments.GoalsFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNav = findViewById(R.id.bottom_navigation)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_home, CalendarFragment()).commit()

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.goals -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_home, GoalsFragment()).commit()
                }

                R.id.calendar -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_home, CalendarFragment()).commit()
                }
            }
            true
        }
    }
}