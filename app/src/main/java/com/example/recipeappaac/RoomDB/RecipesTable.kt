package com.example.recipeappaac.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//start with Room dataBase component
//1) create DB entities

@Entity(tableName = "Recipes")
data class RecipesTable(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id : Int = 0,

    @ColumnInfo(name = "Title")
    val title: String,

    @ColumnInfo(name = "Author")
    val author: String,

    @ColumnInfo(name = "Ingredients")
    val Ingredients: String,

    @ColumnInfo(name = "Instructions")
    val Instructions: String
    )
