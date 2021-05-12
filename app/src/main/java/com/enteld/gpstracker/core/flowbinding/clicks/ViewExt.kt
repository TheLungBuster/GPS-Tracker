package com.enteld.gpstracker.core.flowbinding.clicks

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.coroutineScope
import com.enteld.gpstracker.core.flowbinding.checkRunOnMain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

inline fun View.bindClick(
    crossinline action: () -> Unit
): Flow<Unit> = callbackFlow {
    checkRunOnMain()
    val listener = View.OnClickListener { offer(Unit) }
    setOnClickListener(listener)
    awaitClose { setOnClickListener(listener) }
}.onEach {
    action()
}

inline fun View.bindClick(
    viewLifecycleOwner: LifecycleOwner,
    crossinline action: () -> Unit
): Job = bindClick(action).launchIn(viewLifecycleOwner.lifecycle.coroutineScope)