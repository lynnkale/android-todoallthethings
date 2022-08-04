package com.lynnkale.todoallthethings.completed.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lynnkale.todoallthethings.completed.domain.GetCompletedItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompletedListViewModel @Inject constructor(
    private val getItems: GetCompletedItemsUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(CompletedListState())
    val state: State<CompletedListState>
        get() = _state

    init {
        listenToItems()
    }

    private fun listenToItems() {
        viewModelScope.launch {
            val items = getItems.invoke()
            _state.value = _state.value.copy(completedItems = items)
        }
    }
}
