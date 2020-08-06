package com.github.livingwithhippos.androidtemplate.start.model

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.livingwithhippos.androidtemplate.model.network.api.Position
import com.github.livingwithhippos.androidtemplate.model.repository.PositionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivityViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val positionRepository: PositionRepository
) : ViewModel() {

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.Default + job)

    val positionsLiveData = MutableLiveData<List<Position>?>()

    fun fetchPositionsInfo(
        description: String,
        location: String?,
        lat: String? = null,
        long: String? = null,
        full_time: Boolean? = true,
        page: Int? = 0
    ) {
        scope.launch {
            val positions =
                positionRepository.getPositions(description, location, lat, long, full_time, page)
            positionsLiveData.postValue(positions)
        }
    }

    fun cancelRequests() = job.cancel()
}