package com.enteld.gpstracker.core

import android.view.MenuItem
import androidx.core.view.forEach
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.ref.WeakReference

fun BottomNavigationView.setupWithKeepStateNavController(navController: NavController, keepStateNavigator: KeepStateNavigator) {

    setOnNavigationItemSelectedListener { navController.onNavDestinationSelected(it) }

    val weakBottomNavigationView = WeakReference(this)

    navController.addOnDestinationChangedListener { _, _, _ ->
        val backStackId = keepStateNavigator.popBackStackId.last()
        weakBottomNavigationView.get()?.menu?.forEach { menuItem ->
            if (backStackId == menuItem.itemId) {
                menuItem.isChecked = true
            }
        }
    }

    keepStateNavigator.updateListener = weakBottomNavigationView
}

private fun NavController.onNavDestinationSelected(item: MenuItem): Boolean {
    return try {
        navigate(item.itemId, null, null)
        true
    } catch (e: IllegalArgumentException) {
        false
    }
}