package com.example.testdbflow

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.kotlinextensions.eq
import com.raizlabs.android.dbflow.kotlinextensions.result
import com.raizlabs.android.dbflow.kotlinextensions.save
import com.raizlabs.android.dbflow.sql.language.Select


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FlowManager.init(FlowConfig.Builder(this).build())

        val user = User()
        user.id = 2
        user.name = "reza"

        user.save()
//        val adapter = FlowManager.getModelAdapter(User::class.java)
//        adapter.insert(user)
//
//        user.name = "reza"
//        adapter.update(user)
//
//        adapter.delete(user)
        Toast.makeText(this, "user created", Toast.LENGTH_SHORT).show()

//        Select().from(User::class.java).where().list

        val useeeer = Select().from(User::class.java).where(User_Table.name eq "reza").result
        Toast.makeText(this, useeeer!!.name, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        FlowManager.destroy()
    }
}
