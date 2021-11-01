package com.example.recipeappaac.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.*


//start with Room dataBase component
//2) create Dao -consider LiveData-

@Dao
interface RecipesDao {
    //whenever there is data will be shown on activity should be LiveData
    @Query("SELECT * FROM Recipes")
    fun getAll(): LiveData<List<RecipesTable>>

    //insert a row into the table
    @Insert
    fun insertRec(recipe:RecipesTable)

    //update note
    @Update
    fun updateRec(recipe: RecipesTable)

    //delete note row
    @Delete
    fun delRec(recipe: RecipesTable)
}