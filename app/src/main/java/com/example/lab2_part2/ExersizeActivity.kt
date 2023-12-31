package com.example.lab2_part2
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import android.widget.TextView
import kotlin.random.Random

fun generate_Ex(a: Int, flag: Boolean): Pair<String, Int>{
    val generateA = Random.nextInt(2, 9)
    val generateB = Random.nextInt(2, 9)
    var output =""
    var result = 0
    if (flag){
        output = "${generateA} * ${generateB} = "
        result = generateA * generateB
    }
    else{
        output = "${a} * ${generateB} = "
        result = a * generateB
    }
    return Pair(output, result)


}

class ExersizeActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_numbers_activity)
        val set_a = intent.getIntExtra("number", 1)
        val flag = intent.getBooleanExtra("flag", true)
        val primerview = findViewById<TextView>(R.id.textViewEx)
        val inputtext = findViewById<EditText>(R.id.editTextRes)
        val confirmbutton = findViewById<Button>(R.id.buttonConfirm)
        val retButton = findViewById<Button>(R.id.buttonReturn)
        val edittextcorrect = findViewById<TextView>(R.id.textViewCorrect)
        var successCount = 0
        var tries_count = 1
        val (st, stc) = generate_Ex(set_a, flag)
        primerview.setText("Вопрос ${tries_count}\n"+st)

        var check = stc
        confirmbutton.setOnClickListener{
            val getres = inputtext.text.toString().toInt()

            if(getres == check){
                successCount+=1
                edittextcorrect.setText("Правильно")
            }
            else{
                edittextcorrect.setText("Неправильно")
            }
            tries_count+=1
            if (tries_count >20){
                val percentage = successCount.toDouble()* 100.0 /20.0
                primerview.setText("Точность ответов ${percentage}")
                retButton.visibility = View.VISIBLE
                confirmbutton.visibility = View.INVISIBLE
            }
            else {
                val (output, kk) = generate_Ex(set_a, flag)
                primerview.setText("Вопрос ${tries_count}\n" + output)
                check = kk


            }
            inputtext.text.clear()

        }
        retButton.setOnClickListener {
            finish()
        }

    }

}