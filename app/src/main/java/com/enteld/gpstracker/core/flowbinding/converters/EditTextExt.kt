package com.enteld.gpstracker.core.flowbinding.converters

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import com.enteld.gpstracker.core.flowbinding.checkRunOnMain
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

/***
 * поток для отслеживания изменениц текста
 **/
fun EditText.asFlow(): Flow<String?> = callbackFlow {
    checkRunOnMain()
    val watcher = doAfterTextChanged { offer(it?.toString()) }
    awaitClose { removeTextChangedListener(watcher) }
}