package com.example.mealzapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CategoryResponse
import com.example.domain.usecase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
//  قيمة usecase مش ه pass fنفسي لا di"hilt" هو هيكون مسوؤل عن العملية دي
class MealsViewModel @Inject constructor(private val getMealsUserCase: GetMeals) : ViewModel() {
    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null);
    val categories: StateFlow<CategoryResponse?> = _categories;
    fun getMeals() {
        viewModelScope.launch {
            try {
                _categories.value = getMealsUserCase()
            } catch (e: Exception) {
                Log.i("ViewModel Meals", e.message.toString());
            }
        }
    }
}