package com.example.recipeappaac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.recipeappaac.ViewModel.myViewModel

//finally return to Activity and display LiveData
//this will get UI data from ViewModel

class MainActivity : AppCompatActivity() {

    //i have to declare myViewModel since i will handle it
    lateinit var myViewModelV: myViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //instantiate myViewModel
        myViewModelV=ViewModelProvider(this)
            .get(myViewModel::class.java)

        //my UI
        val btnInsertMain=findViewById<Button>(R.id.btnInsertMain)
        val btnViewRecMain=findViewById<Button>(R.id.btnViewRecMain)

        btnInsertMain.setOnClickListener(){
            intent= Intent(this,AddRecipe::class.java)
            startActivity(intent)
        }

       btnViewRecMain.setOnClickListener(){
           intent= Intent(this,ViewRecipes::class.java)
           startActivity(intent)
        }

    }//end

}//end