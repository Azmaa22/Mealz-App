package com.example.domain.usecase

import com.example.domain.repo.MealsBaseRepo

class GetMeals(private val mealsBaseRepo: MealsBaseRepo) {
    suspend operator fun invoke() = mealsBaseRepo.getAllMealsFromRemote()
}