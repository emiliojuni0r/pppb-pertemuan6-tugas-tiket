package com.example.pertemuan6_tugas

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.pertemuan6_tugas.databinding.DialogConfirmBinding

class DialogConfirm : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val binding = DialogConfirmBinding.inflate(inflater)

        // Retrieve data from MainActivity
        val name = arguments?.getString(MainActivity.EXTRA_NAME)
        val time = arguments?.getString(MainActivity.EXTRA_TIME)
        val date = arguments?.getString(MainActivity.EXTRA_DATE)
        val location = arguments?.getString(MainActivity.EXTRA_LOCATION)


        with(binding){
            if(location == "Jakarta") binding.txtTarif.text = "Rp230.000" else if (location == "Aceh") binding.txtTarif.text = "Rp250.000" else if (location == "Bali") binding.txtTarif.text = "Rp300.000"
            btnBatal.setOnClickListener{
                dismiss()
            }
            btnNo.setOnClickListener{
                val intentTosecondActivity = Intent(requireActivity(), SecondActivity::class.java)
                intentTosecondActivity.putExtra(MainActivity.EXTRA_NAME,name)
                intentTosecondActivity.putExtra(MainActivity.EXTRA_DATE,date)
                intentTosecondActivity.putExtra(MainActivity.EXTRA_TIME,time)
                intentTosecondActivity.putExtra(MainActivity.EXTRA_LOCATION,location)
                startActivity(intentTosecondActivity)
                dismiss()
            }
        }
        builder.setView(binding.root)
        return builder.create()
    }
}