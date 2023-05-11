package com.example.mealzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mealsViewModel: MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mealsViewModel.getMeals()
        val mealsAdapter: MealsAdapter = MealsAdapter()
        val recyclerView : RecyclerView = findViewById(R.id.category_rv);

        lifecycleScope.launch {
            mealsViewModel.categories.collect {
                mealsAdapter.submitList(it?.categories)
                recyclerView.adapter = mealsAdapter
            }
        }
    }
}