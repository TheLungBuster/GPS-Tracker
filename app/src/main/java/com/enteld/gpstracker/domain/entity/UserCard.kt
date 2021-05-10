package com.enteld.gpstracker.domain.entity

data class UserCard(
    val name: String,
    val hasPermission: Boolean,
    val isShown: Boolean,
    val followRequest: Boolean
)