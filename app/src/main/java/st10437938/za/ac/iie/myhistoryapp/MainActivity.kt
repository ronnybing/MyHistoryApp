package st10437938.za.ac.iie.myhistoryapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import st10437938.za.ac.iie.myhistoryapp.R.id.ageEditView

//ass MainActivity : AppCompatActivity() {
  //override fun onCreate(savedInstanceState: Bundle?) {
   //   super.onCreate(savedInstanceState)
  //    setContentView(R.layout.activity_main)

class MainActivity : AppCompatActivity() {

            @SuppressLint("SetText", "MissingInflatedId")
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                val compareButton = findViewById<Button>(R.id.compareButton)
                val clearButton = findViewById<Button>(R.id.clearButton)
                val ageEditText = findViewById<EditText>(ageEditView)
                val resultTextView = findViewById<TextView>(R.id.resultTextView)

// add code to the button when it is clicked

                compareButton.setOnClickListener {
//assign the text in the ageEditText to variable userInput
                    val userInput = ageEditText.text.toString()
//check if the user typed in an age
                    if (userInput.isEmpty()) {
                        resultTextView.text = "Please enter a valid age – it must be a whole number without any decimals or text."}
//check if the age is a valid integer
//In Kotlin, toIntOrNull() is a function that belongs to the String class. It attempts to parse the string //representation of an integer and converts it into an Int value. If the string can be successfully //parsed as an integer, the function returns the corresponding Int value. If the string cannot be //parsed as an integer (for example, if it contains non-numeric characters or exceeds the range of //representable integers), the function returns null.

//Store age in a variable
                    val userAge = userInput.toIntOrNull()

//check if the age is not a valid integer
                    if (userAge == null) {
                        resultTextView.text = "Please enter a valid age – it must be a whole number without any decimals or text."
                    } else {
//check if the age is in the correct range
                        if (userAge < 20 || userAge > 100) {
                            resultTextView.text = "Please enter an age between 20 and 100."
                            ageEditText.text.clear()
                        } else {

                            val result = when (userAge) {
                                28 -> "Some Body, famous for something, died at this age."
                                35 -> "Some Body Else, famous for something else, died at this age"
                                47 -> "was the 35th president of the United States (1961–63) He died at the age of 47"
                                75 -> "was the 35th president of the United States (1961–63) He died at the age of 75"
                                57 -> "Ruth First was a South African activist, scholar, and journalist known for her relentless opposition to South Africa’s discriminatory policy of apartheid. She died at the age of 57"
                                50 -> "Bernie Mac was an American comedian and actor He died at the age of 50"
                                84 -> "Isaac Newton was an English physicist and mathematician who was the culminating figure of the Scientific Revolution of the 17th century.He died at the age of 87"
                                56 -> "Abraham Lincoln was the 16th president of the United States (1861–65), who preserved the Union during the American Civil War and brought about the emancipation of enslaved people in the United States.He died at the age of 56"
                                62 -> "Another Some Body, famous for something, died at this age"
                                else -> "Nobody known to me died at this age"
                             }
                            resultTextView.text = result
                        }
                    }
                }
//clear out the resultTextView and the ageEditText on the Clear button click
                clearButton.setOnClickListener {
                    ageEditText.text.clear()
                    resultTextView.text = ""
                }
            }
}

