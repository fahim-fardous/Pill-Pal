package com.example.pillpal.screens.pill.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pillpal.models.Reminder
import com.example.pillpal.repositories.ReminderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PillAddViewModel
    @Inject
    constructor(
        private val repository: ReminderRepository,
    ) : ViewModel() {
        private val _showMessage = MutableStateFlow<String?>(null)
        val showMessage: StateFlow<String?>
            get() = _showMessage

        fun addReminder(reminder: Reminder) =
            viewModelScope.launch {
                val response = repository.insertReminder(reminder)
                if(response.toString().isEmpty()){
                    _showMessage.value = "Unknown error occurs"
                }
                else{
                    _showMessage.value = "Reminder added successfully"
                }
            }

    fun clearMessage() {
        _showMessage.value = null
    }
    }
