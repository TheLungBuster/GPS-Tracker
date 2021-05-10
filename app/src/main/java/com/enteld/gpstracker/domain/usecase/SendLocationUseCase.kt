package com.enteld.gpstracker.domain.usecase

import android.util.Log
import com.enteld.gpstracker.domain.entity.Coordinates

class SendLocationUseCase {

    operator fun invoke(coordinates: Coordinates) {
        Log.d("Coordinates", "$coordinates")
    }
}