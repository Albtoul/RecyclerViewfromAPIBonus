package com.example.recyclerviewfromapibonus

import RV
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerview : RecyclerView
        lateinit var names:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview=findViewById(R.id.recycler)
        recyclerview.layoutManager= LinearLayoutManager(this)
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)  //call api to fetch data
        apiInterface!!.getClient()?.enqueue(object : Callback<Person?> {
            override fun onResponse(call: Call<Person?>, response: Response<Person?>) {
                names= arrayListOf()



                for(index in response.body()!!){   //for loop to the name in class Person

                  names.add("${index.name}")

                }
                recyclerview.adapter= RV(names)
                recyclerview.adapter?.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<Person?>, t: Throwable) {
                call.cancel()

            }
        })




    }
}