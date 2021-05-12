package com.enteld.gpstracker.feature.login.ui.bind

import androidx.lifecycle.LifecycleOwner
import com.enteld.gpstracker.core.flowbinding.clicks.bindClick
import com.enteld.gpstracker.core.flowbinding.twoway.bindTextTwoWay
import com.enteld.gpstracker.databinding.FragmentLoginBinding
import com.enteld.gpstracker.feature.login.presentation.LoginViewModel

fun FragmentLoginBinding.bind(
    viewLifecycleOwner: LifecycleOwner,
    viewModel: LoginViewModel
) {
    loginButton.bindClick(viewLifecycleOwner) {
        loginInput.bindTextTwoWay(viewLifecycleOwner, viewModel.userNameStateFlow)
        loginButton.bindClick(viewLifecycleOwner) { viewModel.navigateToMain() }
    }
}