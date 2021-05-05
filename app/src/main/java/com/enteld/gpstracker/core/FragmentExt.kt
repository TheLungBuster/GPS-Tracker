package com.enteld.gpstracker.core

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.enteld.gpstracker.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

inline fun <reified T> Fragment.getArgument(key: String): T =
    (arguments?.get(key) as? T)
        ?: throw IllegalArgumentException("arguments $key not found")


inline fun Fragment.toast(@StringRes message: Int) {
    toast(getString(message))
}

inline fun Fragment.toast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

inline fun Fragment.showDialog(
    builder: MaterialAlertDialogBuilder.() -> MaterialAlertDialogBuilder
) {
    builder(MaterialAlertDialogBuilder(requireContext())).show()
}

fun Fragment.navigateOnGlobal(
    @IdRes action: Int,
    navOptions: NavOptions? = null,
    function: Bundle.() -> Unit = {},
) {
    navigate(
        hostId = R.id.host_global,
        action = action,
        navOptions = navOptions,
        function = function
    )
}

fun Fragment.navigateMain(
    @IdRes action: Int,
    navOptions: NavOptions? = null,
    function: Bundle.() -> Unit = {},
) {
    navigate(
        hostId = R.id.host_main,
        action = action,
        navOptions = navOptions,
        function = function
    )
}

fun Fragment.navigate(
    @IdRes action: Int,
    @IdRes hostId: Int? = null,
    navOptions: NavOptions? = null,
    function: Bundle.() -> Unit = {},
) {
    if (hostId == null) {
        findNavController()
    } else {
        Navigation.findNavController(requireActivity(), hostId)
    }.navigate(action, Bundle().apply(function), navOptions)
}