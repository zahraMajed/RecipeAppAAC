package com.example.recipeappaac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.recipeappaac.RoomDB.RecipesTable
import com.example.recipeappaac.ViewModel.myViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//finally return to Activity and display LiveData
//this will get UI data from ViewModel

class AddRecipe : AppCompatActivity() {
    //i have to declare myViewModel since i will handle it
    lateinit var myViewModelV: myViewModel
    //my views
    lateinit var btnSaveInsert: Button
    lateinit var btnViewInsert: Button
    lateinit var edTitleInsert: EditText
    lateinit var edAuthorNameInsert: EditText
    lateinit var edIngredentsInsert: EditText
    lateinit var edInstructionInsert: EditText
    //my variables
    var title=""; var AuthorName=""; var Ingredents=""; var Instructions=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        //instantiate myViewModel
        myViewModelV= ViewModelProvider(this)
            .get(myViewModel::class.java)

        btnSaveInsert=findViewById(R.id.btnSaveInsert)
        btnViewInsert=findViewById(R.id.btnViewInsert)
        edTitleInsert=findViewById(R.id.edTitleInsert)
        edAuthorNameInsert=findViewById(R.id.edAuthorNameInsert)
        edIngredentsInsert=findViewById(R.id.edIngredentsInsert)
        edInstructionInsert=findViewById(R.id.edInstructionInsert)

        btnSaveInsert.setOnClickListener(){
            if (edTitleInsert.text.isNotEmpty() && edAuthorNameInsert.text.isNotEmpty() &&
                edIngredentsInsert.text.isNotEmpty() && edInstructionInsert.text.isNotEmpty() ){
                title=edTitleInsert.text.toString()
                AuthorName=edAuthorNameInsert.text.toString()
                Ingredents=edIngredentsInsert.text.toString()
                Instructions=edInstructionInsert.text.toString()
                myViewModelV.insertRecipe(RecipesTable(0, title, AuthorName, Ingredents, Instructions))
                Toast.makeText(applicationContext, "data saved successfully!", Toast.LENGTH_SHORT).show()
                clearEditText()
            }else
                Toast.makeText(applicationContext, "please fill the missing entry!", Toast.LENGTH_SHORT).show()
        }//end btnSave lis

        btnViewInsert.setOnClickListener(){
            intent= Intent(this,ViewRecipes::class.java)
            startActivity(intent)
        }//end btnView lis

    }//end onCreate()

    fun clearEditText(){
        edTitleInsert.text.clear()
        edAuthorNameInsert.text.clear()
        edIngredentsInsert.text.clear()
        edInstructionInsert.text.clear()
    }
}