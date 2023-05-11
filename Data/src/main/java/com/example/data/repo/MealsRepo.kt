package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.repo.MealsBaseRepo

class MealsRepo(private val apiService: ApiService) : MealsBaseRepo {
     override suspend fun getAllMealsFromRemote(): CategoryResponse = apiService.getMeals()
}