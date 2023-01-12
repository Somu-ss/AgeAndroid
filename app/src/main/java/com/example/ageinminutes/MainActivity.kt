package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var dateselect : TextView ?= null
    private var ageminutes : TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        var btndatepicker : Button = findViewById(R.id.button)
        dateselect = findViewById(R.id.selecteddateview)
        ageminutes = findViewById(R.id.ageminutes)

        btndatepicker.setOnClickListener {
            datecalender()
        }


        }
    fun datecalender(){
        val mycalender = Calendar.getInstance()
        val year = mycalender.get(Calendar.YEAR)
        val month = mycalender.get(Calendar.MONTH)
        val day = mycalender.get(Calendar.DAY_OF_MONTH)

        val minsapp = DatePickerDialog(this,
            {view,selectedyear,selectedmonth,selecteddayOfMonth ->
                Toast.makeText(this,"Selected year is $selectedyear,Month is ${selectedmonth+1},Day is $selecteddayOfMonth", Toast.LENGTH_LONG).show()

                val selecteddate = "$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"

                dateselect?.setText(selecteddate)

                val simpledf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val cdate = simpledf.parse(selecteddate)

                val selecteddateinmins = cdate.time /  60000

                val currentdate = simpledf.parse(simpledf.format(System.currentTimeMillis()))

                val currentdateinmins = currentdate.time / 60000

                val differenceinmins = currentdateinmins - selecteddateinmins

               ageminutes?.text = differenceinmins.toString()
            },
            year,
            month,
            day)
        minsapp.datePicker.maxDate = System.currentTimeMillis()
        minsapp.show()




    }
}