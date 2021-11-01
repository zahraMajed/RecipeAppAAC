package com.example.recipeappaac.Reposotory

import androidx.lifecycle.LiveData
import com.example.recipeappaac.RoomDB.RecipesDatabase
import com.example.recipeappaac.RoomDB.RecipesTable


//move to repository component
//this will handle database Dao

class RecipesReposotory (val db:RecipesDatabase) {

    //this will return List<RecipesTable> and should be type of LiveData
    //as we gonna pass it to activity through layer (in all layer should ne LiveData)
    fun getAllRecipes(): LiveData<List<RecipesTable>> {
        return db.getRecipesDao().getAll()
    }

    //these method should be suspend as we will use CoroutineScope in viewModel
    suspend fun insertRecipe(Recipe:RecipesTable){
        db.getRecipesDao().insertRec(Recipe)
    }


    suspend fun delRecipe(Recipe:RecipesTable){
        db.getRecipesDao().delRec(Recipe)
    }

    suspend fun updateRecipe(Recipe:RecipesTable){
        db.getRecipesDao().updateRec(Recipe)
    }

}