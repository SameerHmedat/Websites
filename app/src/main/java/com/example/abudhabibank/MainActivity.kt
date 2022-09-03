package com.example.abudhabibank

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.info_item_row.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupInfoUIList()
        setINfoList()

    }

    private fun setupInfoUIList() {
        rvInfo.layoutManager = LinearLayoutManager(this)
        rvInfo.setHasFixedSize(true)
    }

    private fun setINfoList() {

        val infoList: MutableList<Info> = mutableListOf()

        val json: String =
            this.assets.open("Info.json").bufferedReader().use { it.readText() }

        val jsoArr = JSONArray(json)
        for (i in 0 until jsoArr.length()) {
            val jsonObj = jsoArr.getJSONObject(i)
            infoList.add(
                Info(
                    name = jsonObj.getString("name"),
                    link=jsonObj.getString("link")
                )
            )

            var adapter=InfoAdapter(infoList)
            rvInfo.adapter =adapter
            adapter.setOnItemClickListener(object :InfoAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
                //   Toast.makeText(this@MainActivity,"You Clicked me $position",Toast.LENGTH_SHORT).show()
                    val openURL = Intent(Intent.ACTION_VIEW)
                 //   openURL.data = Uri.parse("${infoList[position].name}")
                    openURL.data = Uri.parse(infoList[position].link)
               //     openURL.data = Uri.parse("https://develop.fitoman.com/MobileServices/Uploads/P/2022/"+"${infoList[position].name}")
                    startActivity(openURL)
                   }


            })

        }
    }

}

