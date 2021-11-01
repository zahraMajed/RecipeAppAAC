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


class UpdateRecipe : AppCompatActivity() {
    //i have to declare myViewModel since i will handle it
    lateinit var myViewModelV: myViewModel

    //my views
    lateinit var btnUpdate: Button
    lateinit var edTitleUp: EditText
    lateinit var edAuthorNameUp: EditText
    lateinit var edIngredentsUp: EditText
    lateinit var edInstructionUp: EditText

    //my variables
    var title=""; var AuthorName=""; var Ingredents=""; var Instructions=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_recipe)
        //instantiate myViewModel
        myViewModelV= ViewModelProvider(this)
            .get(myViewModel::class.java)

        btnUpdate=findViewById(R.id.btnUpdate)
        edTitleUp=findViewById(R.id.edTitleUp)
        edAuthorNameUp=findViewById(R.id.edAuthorNameUp)
        edIngredentsUp=findViewById(R.id.edIngredentsUp)
        edInstructionUp=findViewById(R.id.edInstructionUp)

        btnUpdate.setOnClickListener(){
            if (edTitleUp.text.isNotEmpty() && edAuthorNameUp.text.isNotEmpty() &&
                edIngredentsUp.text.isNotEmpty() && edInstructionUp.text.isNotEmpty() ){
                title=edTitleUp.text.toString(); AuthorName=edAuthorNameUp.text.toString()
                Ingredents=edIngredentsUp.text.toString(); Instructions=edInstructionUp.text.toString()
                if (intent.extras != null){
                    var id=intent.getIntExtra("id",0)
                    myViewModelV.insertRecipe(RecipesTable(id, title, AuthorName, Ingredents, Instructions))
                    Toast.makeText(applicationContext, "data are up-to-data successfully!", Toast.LENGTH_SHORT).show()
                    clearEditText()
                    intent= Intent(this,ViewRecipes::class.java)
                    startActivity(intent)
                }else
                    Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(applicationContext, "please fill the missing entry!", Toast.LENGTH_SHORT).show()
        }//end lis
    }
    fun clearEditText(){
        edTitleUp.text.clear()
        edAuthorNameUp.text.clear()
        edIngredentsUp.text.clear()
        edInstructionUp.text.clear()
    }
}