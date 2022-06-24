package com.example.ageinminiute

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BtnDatePicker.setOnClickListener { view ->
            Datepicker(view)

            Toast.makeText(this, "botton is working ", Toast.LENGTH_LONG).show()
        }


    }

    fun Datepicker(view: View) {

        val myCalender =
            Calendar.getInstance()    //ye line se hum calendar ka instance create car rahe hai jsime date select karenge !!!
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
       val dpd=  DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { selectedview, Syear, Smonth, Sday -> Toast.makeText(this ,
                "year is $year the month is $month the day is $day" ,
                Toast.LENGTH_SHORT).show()
                val selecteddate ="$Sday/${Smonth+1}/$Syear"
                tvselecteddate.setText(selecteddate)
                val sdf =SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                val theDate = sdf.parse(selecteddate)
                val selecteddateinminute = theDate!!.time/ 60000
                // time return the date in milisecond format so its upto you in what unit you want it
                // thedate can be null aslo if the user select the current date so we  use (not null assertion operator (!!))
                val currdate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currenttomin=currdate.time/60000
                val ans = currenttomin-selecteddateinminute
                selecteddateinmin.setText(ans.toString() )
            },
            year,
            month,
            day,
        )
        dpd.datePicker.setMaxDate(Date().time -86400000)
        dpd.show();

    }
}