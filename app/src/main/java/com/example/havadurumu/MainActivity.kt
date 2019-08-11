package com.example.havadurumu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url="https://api.openweathermap.org/data/2.5/weather?q=Ankara,tr&appid=d1cac1c60222af88cb4db2d9a3c55320&lang=tr"
        val havaDurumuObje=JsonObjectRequest(Request.Method.GET,url,null,object:Response.Listener<JSONObject>{
            override fun onResponse(response: JSONObject?) {
                Toast.makeText(this@MainActivity,response.toString(),Toast.LENGTH_LONG).show()
            }

        },object:Response.ErrorListener{
            override fun onErrorResponse(error: VolleyError?) {

            }

        })


        MySingleton.getInstance(this)?.addToRequestQueue(havaDurumuObje)

    }

}
