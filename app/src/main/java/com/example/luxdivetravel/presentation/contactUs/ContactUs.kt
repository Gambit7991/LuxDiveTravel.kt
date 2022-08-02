package com.example.luxdivetravel.presentation.contactUs

import android.app.AlertDialog
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
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
import com.example.domain.domain.models.ContactUsForm
import com.example.domain.domain.useCases.SendContactFormUseCase
import com.example.luxdivetravel.R
import com.example.luxdivetravel.databinding.FragmentContactUsBinding
import com.example.luxdivetravel.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ContactUs : Fragment(), View.OnClickListener {
    private var _binding: FragmentContactUsBinding? = null
    private val binding get() = _binding!!
    private var navController: NavController? = null
    private val sharedMainViewModel by sharedViewModel<MainViewModel>()

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
        sharedMainViewModel.wayLive.observe(viewLifecycleOwner) {
            with(binding) {
                if (it.contactUsForm.name.isNotEmpty()) {
                    nameEditText.setText(it.contactUsForm.name)
                }
                if (it.contactUsForm.phoneNumber.isNotEmpty()) {
                    phoneEditText.setText(it.contactUsForm.phoneNumber)
                }
                if (it.contactUsForm.email.isNotEmpty()) {
                    phoneEditText.setText(it.contactUsForm.phoneNumber)
                }
                if (it.contactUsForm.message.isNotEmpty()) {
                    messageEditText.setText(it.contactUsForm.message)
                }
            }
        }
    }

    private fun replaceFragment() {
        parentFragmentManager.beginTransaction()
            .remove(FragmentManager.findFragment(this.view!!))
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
        if (!phoneNumber.matches(getString(R.string.regex_all_numbers).toRegex())) {
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
                if (btnSubmitForm()) {
                    binding.emailEditText.setText("")
                    binding.nameEditText.setText("")
                    binding.phoneEditText.setText("")
                    binding.messageEditText.setText("")
                    replaceFragment()
                    StrictMode.setThreadPolicy(ThreadPolicy.Builder().permitAll().build())
                    //TODO: needs to set up email account
                    val temp = SendContactFormUseCase()
//                    temp.execute(getContactUsForm())
                    sharedMainViewModel.setDisabled(boolean = false)
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        sharedMainViewModel.saveContactUsFormUseCase(getContactUsForm())
    }

    private fun getContactUsForm(): ContactUsForm {
        return ContactUsForm(
            name = binding.nameEditText.text.toString(),
            email = binding.emailEditText.text.toString(),
            phoneNumber = binding.phoneEditText.text.toString(),
            message = binding.messageEditText.text.toString()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}