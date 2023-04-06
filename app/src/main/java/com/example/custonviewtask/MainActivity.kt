package com.example.custonviewtask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.custonviewtask.databinding.ActivityMainBinding
import com.example.custonviewtask.databinding.CustomViewBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }


        binding.customButtonAction.setListener {
            if (it == ButtonAction.TURN_ON) {
                binding.switcherState.text = "Switcher is On"

            } else if (it == ButtonAction.TURN_OFF) {
                binding.switcherState.text = "Switcher is OFF"
            }
        }
    }
}