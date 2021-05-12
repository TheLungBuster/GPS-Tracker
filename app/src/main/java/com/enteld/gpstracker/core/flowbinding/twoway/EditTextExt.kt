package com.enteld.gpstracker.core.flowbinding.twoway

import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.coroutineScope
import com.enteld.gpstracker.core.flowbinding.checkRunOnMain
import com.enteld.gpstracker.core.flowbinding.converters.asFlow
import kotlinx.coroutines.flow.*

inline fun EditText.bindTextTwoWay(
    viewLifecycleOwner: LifecycleOwner,
    flow: MutableStateFlow<String>,
    crossinline take: (CharSequence) -> Unit = {}
) {
    checkRunOnMain()
    flow.filter { it != text?.toString() }
        .onEach {
            setText(it)
        }.launchIn(viewLifecycleOwner.lifecycle.coroutineScope)
    asFlow()
        .filterNotNull()
        .filter {
            it.trim() != flow.value
        }.onEach {
            flow.value = it.trim()
            take(it)
        }.launchIn(viewLifecycleOwner.lifecycle.coroutineScope)
}