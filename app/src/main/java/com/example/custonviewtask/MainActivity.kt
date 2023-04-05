package com.example.custonviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.custonviewtask.databinding.ActivityMainBinding
import com.example.custonviewtask.databinding.CustomViewBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.customButtonAction.setListener {

        }
    }
}