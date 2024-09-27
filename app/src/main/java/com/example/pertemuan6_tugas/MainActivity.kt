package com.example.pertemuan6_tugas

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pertemuan6_tugas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener ,TimePickerDialog.OnTimeSetListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var locations: Array<String>
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_TIME = "extra_time"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_LOCATION = "extra_location"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // array location
        locations = resources.getStringArray(R.array.locations)


        with(binding){
            val adapterLocation = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, locations)
            adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerLocation.adapter = adapterLocation

            // for spinnerLocation (dropdown itu dah)
            spinnerLocation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (position == 0) {
                        // Set the hint color to gray
                        (view as? TextView)?.setTextColor(Color.GRAY)
                    } else {
                        // Set the selected item color to black
                        (view as? TextView)?.setTextColor(Color.BLACK)
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Do nothing
                }
            }
            inputTanggal.setOnClickListener {
                val datePicker = DatePicker()
                datePicker.show(supportFragmentManager, "datePicker")
            }
            inputJam.setOnClickListener {
                val timePicker = TimePicker()
                timePicker.show(supportFragmentManager, "timePicker")
            }
            btnPesanTiket.setOnClickListener {
                val dialog = DialogConfirm()

                // Create a Bundle to pass data
                val bundle = Bundle()
                bundle.putString(EXTRA_NAME, binding.inputNama.text.toString())
                bundle.putString(EXTRA_TIME, binding.inputJam.text.toString())
                bundle.putString(EXTRA_DATE, binding.inputTanggal.text.toString())
                bundle.putString(EXTRA_LOCATION, locations[binding.spinnerLocation.selectedItemPosition])

                // Set the bundle to the dialog
                dialog.arguments = bundle

                dialog.show(supportFragmentManager, "dialogExit")
            }
        }

    }
    override fun onDateSet(p0: android.widget.DatePicker?, p1: Int, p2: Int, p3:
    Int) {
        // Gunakan p1, p2, p3 untuk mendapatkan tanggal, bulan, dan tahun
        val selectedDate = "$p3/${p2 + 1}/$p1"
        binding.inputTanggal.setText(selectedDate)
        binding.inputTanggal.setTextColor(Color.BLACK)
    }

    override fun onTimeSet(p0: android.widget.TimePicker?, p1: Int, p2: Int) {
        //Gunakanp1danp2untukmendapatkanjamdanmenit
        val selectedTime = String.format("%02d:%02d", p1, p2)
        binding.inputJam.setText(selectedTime)
        binding.inputJam.setTextColor(Color.BLACK)
    }
}