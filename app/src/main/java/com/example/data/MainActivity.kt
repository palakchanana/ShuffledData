package com.example.data

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private const val CHARACTER_DATA_KEY = "CHARACTER_DATA_KEY"

class MainActivity : AppCompatActivity() {

    //Here we call generate method from only one instance of object class CharacterGenerate
    var characterData = CharacterGenerator.generate() //Here assign the character data to a property called Character Data

    //This will override the saved instance and save it
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(CHARACTER_DATA_KEY,characterData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        //this call to onCreate will restore then saved state(ui)
        // and set the activity on screen
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        characterData = savedInstanceState?.let {
            it.getSerializable(CHARACTER_DATA_KEY) as CharacterGenerator.CharacterData
        } ?: CharacterGenerator.generate()

        //Generate Button On Click Listner Set here
        //So that we can perform action when user click generate button
        generateButton.setOnClickListener {
            characterData = CharacterGenerator.generate()
            displaycharacterData() //Here we call display fun, every time user click generate display retrived
        }

        //First time display function called here,
        //so that it can set the text for the first time when app start
        displaycharacterData()

    }

    private fun displaycharacterData(){

        //Here we set all the text view at once
        characterData.run {
            nameTextView.text = name
            agegroupTextView.text = age
            hobbyTextView.text = hobby
            cityTextView.text = city
            pnoTextView.text = number
        }
    }
}
