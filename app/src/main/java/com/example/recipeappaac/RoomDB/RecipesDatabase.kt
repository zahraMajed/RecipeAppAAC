package com.example.recipeappaac.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//start with Room dataBase component
//3) create recipe Room database

@Database(entities= [RecipesTable::class], version = 1, exportSchema = false)
abstract class RecipesDatabase : RoomDatabase(){
    companion object{
        var instance:RecipesDatabase?=null
        fun getInstance(context: Context):RecipesDatabase {
            if(instance!=null){
                return instance as RecipesDatabase
            }
            instance= Room.databaseBuilder(context,RecipesDatabase::class.java, "data").run {allowMainThreadQueries()}.build();
            return instance as RecipesDatabase
        }
    }//end companion object

    abstract fun getRecipesDao():RecipesDao;
}