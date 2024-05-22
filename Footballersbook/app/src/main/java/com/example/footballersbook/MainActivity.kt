package com.example.footballersbook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballersbook.databinding.ActivityDetailsBinding
import com.example.footballersbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var footballerslist: ArrayList<Footballer>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        footballerslist = ArrayList<Footballer>()


        val manaj = Footballer("Rey Manaj","Albania",26,"Forward",R.drawable.reymanaj)
        val charisis = Footballer("Charis Charisis","Greece",29,"midfield",R.drawable.charisi)
        val max = Footballer("Max Gradel","Ivory Coast",35,"left wing",R.drawable.gradel)
        val fernando = Footballer("Fernando Andrade","Brazil",33,"right wing",R.drawable.fernando)
        val saiz = Footballer("Samuel Saiz","Spain",32,"offensive midfielder",R.drawable.saiz)



        footballerslist.add(manaj)
        footballerslist.add(charisis)
        footballerslist.add(max)
        footballerslist.add(fernando)
        footballerslist.add(saiz)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val footballeradapter = FootballerAdapter(footballerslist)
        binding.recyclerview.adapter = footballeradapter

    }
}