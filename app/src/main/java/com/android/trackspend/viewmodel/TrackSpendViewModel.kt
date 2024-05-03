package com.android.trackspend.viewmodel

import androidx.lifecycle.ViewModel
import com.android.trackspend.repository.TrackSpendRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrackSpendViewModel @Inject constructor(
    private val repository: TrackSpendRepository
) : ViewModel() {
}