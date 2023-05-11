package com.example.domain.repo

import com.example.domain.entity.CategoryResponse

interface MealsBaseRepo {
  suspend  fun getAllMealsFromRemote():CategoryResponse
}