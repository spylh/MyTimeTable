package jp.ac.aut.mytimetable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val walkThroughButton: Button = findViewById(R.id.walk_through_debug)
        walkThroughButton.setOnClickListener{
            val intent = Intent(application,WalkThroughActyvity::class.java)
            startActivity(intent)
        }
        val overViewButton : Button = findViewById<Button>(R.id.overview_button)
        overViewButton.setOnClickListener{
            val intent = Intent(application,overview_activity::class.java)
            startActivity(intent)
        }
    }



}