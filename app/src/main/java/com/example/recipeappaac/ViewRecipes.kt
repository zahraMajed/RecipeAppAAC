package com.example.recipeappaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeappaac.ViewModel.myViewModel
import kotlinx.android.synthetic.main.activity_view_recipes.*

//finally return to Activity and display LiveData
//this will get UI data from ViewModel

class ViewRecipes : AppCompatActivity() {
    //i have to declare myViewModel since i will handle it
    lateinit var myViewModelV: myViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_recipes)

        //instantiate myViewModel
        myViewModelV= ViewModelProvider(this)
            .get(myViewModel::class.java)

        myViewModelV.geyAllRecipes().observe(this, {
            rv_main.adapter=ReyclerAdapter(this,it)
            rv_main.layoutManager=LinearLayoutManager(this)
        })

    }//end onCreate()
}