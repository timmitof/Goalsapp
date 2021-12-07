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

class RegisterFragment : Fragment() {
    lateinit var btnLog: Button
    lateinit var nameReg: EditText
    lateinit var logReg: EditText
    lateinit var passReg: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        btnLog = view.findViewById(R.id.btnLogin2)
        nameReg = view.findViewById(R.id.nameReg)
        logReg = view.findViewById(R.id.logReg)
        passReg = view.findViewById(R.id.passReg)
        val replaceLog: Button = view.findViewById(R.id.replaceLog)

        replaceLog.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left)
                ?.replace(R.id.fragment_container, LoginFragment())?.commit()
        }

        btnLog.setOnClickListener {
            val name = nameReg.text
            val login = logReg.text
            val pass = passReg.text

            when {
                name.isEmpty() -> {
                    nameReg.error = "Введите имя"
                    return@setOnClickListener
                }
                login.isEmpty() -> {
                    logReg.error = "Введите логин"
                    return@setOnClickListener
                }
                pass.isEmpty() -> {
                    passReg.error = "Введите пароль"
                    return@setOnClickListener
                }
                name.isBlank() -> {
                    nameReg.error = "Введите имя"
                    return@setOnClickListener
                }
                login.isBlank() -> {
                    logReg.error = "Введите логин"
                    return@setOnClickListener
                }
                pass.isBlank() -> {
                    passReg.error = "Введите пароль"
                    return@setOnClickListener
                }
                name != null && login != null && pass != null -> {
                    val intent = Intent(requireActivity(), HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        return view
    }
}