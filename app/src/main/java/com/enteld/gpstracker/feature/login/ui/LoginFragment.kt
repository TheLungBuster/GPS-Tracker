package com.enteld.gpstracker.feature.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.enteld.gpstracker.R
import com.enteld.gpstracker.core.BindingFragment
import com.enteld.gpstracker.core.navigate
import com.enteld.gpstracker.core.navigateOnGlobal
import com.enteld.gpstracker.core.toast
import com.enteld.gpstracker.databinding.FragmentLoginBinding
import com.enteld.gpstracker.feature.login.presentation.LoginViewModel
import com.enteld.gpstracker.feature.login.ui.bind.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment: BindingFragment<FragmentLoginBinding>(), LoginViewModel.EventListener {

    private val viewModel by viewModel<LoginViewModel>()

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)

    override fun otherSetups(savedInstanceState: Bundle?) {
        viewModel.eventsDispatcher.bind(viewLifecycleOwner, this)
        binding.bind(viewLifecycleOwner, viewModel)
    }

    override fun navigateToMain() {
        navigateOnGlobal(R.id.action_login_to_main)
    }

    override fun showToast(message: Int) {
        toast(message)
    }
}