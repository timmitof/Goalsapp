package com.timmitof.goalsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.timmitof.goalsapp.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, LoginFragment()).commit()
    }
}