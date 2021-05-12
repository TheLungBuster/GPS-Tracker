package com.enteld.gpstracker.feature.login.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.enteld.gpstracker.R
import com.enteld.gpstracker.core.presentation.EventsDispatcher
import com.enteld.gpstracker.core.presentation.EventsDispatcherOwner
import com.enteld.gpstracker.domain.usecase.IsLoggedInUseCase
import com.enteld.gpstracker.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val isLoggedInUseCase: IsLoggedInUseCase
) : ViewModel(), EventsDispatcherOwner<LoginViewModel.EventListener> {

    interface EventListener {
        fun navigateToMain()
        fun showToast(message: Int)
    }

    override val eventsDispatcher = EventsDispatcher<EventListener>()

    val userNameStateFlow = MutableStateFlow("")

    init {
        navigateOnInit()
    }

    private fun navigateOnInit() {
        if (isLoggedInUseCase()) {
            eventsDispatcher.dispatchEvent {
                navigateToMain()
            }
        }
    }

    fun navigateToMain() {
        Log.d("NAV", "ENTERED WITH '${userNameStateFlow.value}'")
        if (userNameStateFlow.value.isEmpty()) {
            Log.d("NAV", "ENTERED EMPTY USER NAME")
            eventsDispatcher.dispatchEvent {
                showToast(R.string.toast_login_empty_input)
            }
            return
        }

        Log.d("NAV", "ENTERED IN LOGIN")
        eventsDispatcher.dispatchEvent {
            loginUseCase(userNameStateFlow.value)
            navigateToMain()
        }
    }
}