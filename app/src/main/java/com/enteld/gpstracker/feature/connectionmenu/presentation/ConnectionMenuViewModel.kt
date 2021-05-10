package com.enteld.gpstracker.feature.connectionmenu.presentation

import androidx.lifecycle.ViewModel
import com.enteld.gpstracker.domain.entity.UserCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ConnectionMenuViewModel: ViewModel() {

    private val followedList = listOf(
        UserCard(name = "Andrey", hasPermission = true, isShown = true, followRequest = true),
        UserCard(name = "Dmitri", hasPermission = false, isShown = true, followRequest = false),
        UserCard(name = "Ivan", hasPermission = true, isShown = false, followRequest = true),
        UserCard(name = "Daniil", hasPermission = false, isShown = false, followRequest = false),
        UserCard(name = "Alex", hasPermission = true, isShown = false, followRequest = true)
    )

    val followersFlow: StateFlow<List<UserCard>> = MutableStateFlow(followedList)
    val followedFlow: StateFlow<List<UserCard>> = MutableStateFlow(followedList.filter { it.followRequest })
}