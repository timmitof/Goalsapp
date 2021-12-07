package com.timmitof.goalsapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.timmitof.goalsapp.HomeActivity
import com.timmitof.goalsapp.R


class LoginFragment : Fragment() {
    lateinit var loginEdit: EditText
    lateinit var passwordEdit: EditText
    lateinit var buttonLog: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        loginEdit = view.findViewById(R.id.loginIn)
        passwordEdit = view.findViewById(R.id.passwordIn)
        buttonLog = view.findViewById(R.id.btnLogin)
        val replaceReg: Button = view.findViewById(R.id.replaceReg)

        replaceReg.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right)
                ?.replace(R.id.fragment_container, RegisterFragment())?.commit()

        }

        buttonLog.setOnClickListener {
            val login = loginEdit.text
            val password = passwordEdit.text

            if (login.isEmpty()) {
                loginEdit.error = "Введите логин"
                return@setOnClickListener
            } else if (password.isEmpty()) {
                passwordEdit.error = "Введите пароль"
                return@setOnClickListener
            }

            if (login != null && password != null) {
                val intent = Intent(requireActivity(), HomeActivity::class.java)
                startActivity(intent)
            }
        }

        return view
    }
}