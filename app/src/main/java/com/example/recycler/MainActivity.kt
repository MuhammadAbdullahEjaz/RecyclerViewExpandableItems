package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        val data = ('A'..'Z').toList()
        val listData = data.map{
            ListData(it.toString())
        }
        binding.recycler.adapter = ListAdapter(listData)
        setContentView(binding.root)
    }
}