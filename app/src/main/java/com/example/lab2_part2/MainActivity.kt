package com.example.lab2_part2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2_part2.ui.theme.Lab2_part2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        val numberText = findViewById<EditText>(R.id.editTextStartNumber)
        val buttonSelectedEx = findViewById<Button>(R.id.buttonCommonEx)
        val buttonFul = findViewById<Button>(R.id.buttonAllNumbers)
        buttonSelectedEx.setOnClickListener{
            val flag = false
            val num = numberText.text.toString().toInt()
            val intent = Intent(this, ExersizeActivity::class.java)
            intent.putExtra("number", num)
            intent.putExtra("flag", flag)
            startActivity(intent)
        }
        buttonFul.setOnClickListener{
            val flag = true
            val num = 0
            val intent = Intent(this, ExersizeActivity::class.java)
            intent.putExtra("number", num)
            intent.putExtra("flag", flag)
            startActivity(intent)
        }

    }
}
