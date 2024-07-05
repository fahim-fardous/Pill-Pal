package com.example.pillpal.screens.reminder.add

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
class ReminderAddViewModel
    @Inject
    constructor(
        private val repository: ReminderRepository,
    ) : ViewModel() {
        private val _showMessage = MutableStateFlow<String?>(null)
        val showMessage: StateFlow<String?>
            get() = _showMessage

        private fun isValid(reminder: Reminder): Boolean {
            if (reminder.pillName.isEmpty()) return false
            if (reminder.pillAmount.toString().isEmpty()) return false
            if (reminder.pillType.isEmpty()) return false
            if (reminder.interval.toString().isEmpty()) return false
            if (reminder.intervalType.isEmpty()) return false
            if (reminder.foodTiming.toString().isEmpty()) return false
            if (reminder.time.isEmpty()) return false
            return true
        }

        fun addReminder(reminder: Reminder) =
            viewModelScope.launch {
                if (!isValid(reminder)) {
                    _showMessage.value = "Fill all the field"
                    return@launch
                }
                val response = repository.insertReminder(reminder)
                if (response.toString().isEmpty()) {
                    _showMessage.value = "Unknown error occurs"
                } else {
                    _showMessage.value = "Reminder added successfully"
                }
            }

        fun clearMessage() {
            _showMessage.value = null
        }
    }
