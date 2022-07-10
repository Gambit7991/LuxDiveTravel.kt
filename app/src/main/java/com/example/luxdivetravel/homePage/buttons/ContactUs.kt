package com.example.luxdivetravel.homePage.buttons

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentContactUsBinding


class ContactUs : Fragment(), View.OnClickListener {
    private var _binding: FragmentContactUsBinding? = null
    private val binding get() = _binding!!
    private var navController: NavController? = null

    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactUsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        emailTextChangeListener()
        phoneTextChangeListener()
        nameTextChangeListener()
        binding.btnSubmitForm.setOnClickListener(this)
    }

    private fun replaceFragment() {
        parentFragmentManager.beginTransaction().remove(FragmentManager.findFragment(this.view!!))
            .commit()
    }


    private fun btnSubmitForm(): Boolean {
        val validEmail = binding.emailTextContainer.helperText == null
        val validPhone = binding.phoneTextContainer.helperText == null
        val validName = binding.nameContainer.helperText == null
        return if (validName && validPhone && validEmail) {
            true
        } else {
            invalidForm()
            false
        }
    }

    private fun invalidForm() {
        var message = ""
        if (binding.nameContainer.helperText != null) {
            message += "\n\nName: ${binding.nameContainer.helperText}"
        }
        if (binding.emailTextContainer.helperText != null) {
            message += "\n\nEmail: ${binding.emailTextContainer.helperText}"
        }
        if (binding.phoneTextContainer.helperText != null) {
            message += "\n\nPhone: ${binding.phoneTextContainer.helperText}"
        }

        AlertDialog.Builder(activity).setTitle("Invalid Form").setMessage(message)
            .setPositiveButton("Okay") { _, _ ->
                //do nothing
            }.show()
    }

    private fun emailTextChangeListener() {
        binding.emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.emailTextContainer.helperText =
                    validEmail(binding.emailEditText.text.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                //do nothing
            }
        })
    }

    private fun validEmail(emailAddress: String): String? {
        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches())
            return "Invalid Email Address"
        return null
    }

    private fun phoneTextChangeListener() {
        binding.phoneEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.phoneTextContainer.helperText =
                    validPhone(binding.phoneEditText.text.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                //do nothing
            }

        })
    }

    private fun validPhone(phoneNumber: String): String? {
        if (phoneNumber.length < 10) {
            return "Invalid Phone Number(Must contains 10 digits)"
        }
        if (!phoneNumber.matches(getString(R.string.regex_phone_number_length).toRegex())) {
            return "Invalid Phone Number(Must contains digits only)"
        }
        return null
    }

    private fun nameTextChangeListener() {
        binding.nameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.nameContainer.helperText = isPresented(binding.nameEditText.text.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                //do nothing
            }
        })
    }

    private fun isPresented(str: String): String? {
        if (str.isEmpty())
            return "Name must contains at least 1 character"
        return null
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.btnSubmitForm.id -> {
                if (btnSubmitForm()) replaceFragment()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}