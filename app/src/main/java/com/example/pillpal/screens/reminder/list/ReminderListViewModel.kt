package com.example.pillpal.screens.reminder.list

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
class ReminderListViewModel
    @Inject
    constructor(
        private val repository: ReminderRepository,
    ) : ViewModel() {
        private val _reminders = MutableStateFlow<List<Reminder>>(emptyList())
        val reminders: StateFlow<List<Reminder>>
            get() = _reminders

        fun getReminders() =
            viewModelScope.launch {
                val response = repository.getAllReminders()
                if (response.isNotEmpty()) {
                    println(response.first().pillName)
                    _reminders.value = response
                }
            }
    }
