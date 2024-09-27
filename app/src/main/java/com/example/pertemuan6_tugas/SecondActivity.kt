package com.example.pertemuan6_tugas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pertemuan6_tugas.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_TIME = "extra_time"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_LOCATION = "extra_location"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val time = intent.getStringExtra(EXTRA_TIME)
        val date = intent.getStringExtra(EXTRA_DATE)
        val location = intent.getStringExtra(EXTRA_LOCATION)

        with(binding) {
            binding.txtNama.text = name
            binding.txtJam.text = time
            binding.txtTgl.text = date
            binding.txtTujuan.text = location
        }
    }
}