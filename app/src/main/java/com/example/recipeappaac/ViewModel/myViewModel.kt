package com.example.recipeappaac.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.recipeappaac.Reposotory.RecipesReposotory
import com.example.recipeappaac.RoomDB.RecipesDatabase
import com.example.recipeappaac.RoomDB.RecipesTable
import kotlinx.coroutines.launch

//move to viewModel component
//this will handle repository +
//also this class store, manage and prepare UI related data in a lifecycle conscious way

//since it extends AndroidViewModel not ViewModel() we have to pass Application variable
class myViewModel (app: Application) : AndroidViewModel(app){
    //i will declare recipesReposotory object because i have to access to its function
    private val recipesReposotory: RecipesReposotory
    //ones i create object of myViewModel,recipesReposotory will initialized
    init {
        recipesReposotory= RecipesReposotory(RecipesDatabase.getInstance(app))
    }

    //create needed methods

    fun insertRecipe(Recipe: RecipesTable){
        viewModelScope.launch {
            recipesReposotory.insertRecipe(Recipe)
        }
    }

    fun updatetRecipe(Recipe:RecipesTable){
        viewModelScope.launch {
            recipesReposotory.updateRecipe(Recipe)
        }
    }

    fun delRecipe(Recipe:RecipesTable){
        viewModelScope.launch {
            recipesReposotory.delRecipe(Recipe)
        }
    }

    fun geyAllRecipes() : LiveData<List<RecipesTable>> {
        return recipesReposotory.getAllRecipes()
    }


}//end