package com.ilham.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.IOException

class Splash : AppCompatActivity() {

    private var userList = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splah)
        userList = parseJson()
        GlobalScope.launch {
            delay(2000L) // this is a placeholder for data loading
            moveIntent(userList)
        }
    }

    private fun moveIntent(list: ArrayList<User>) {
        val intent = Intent(this, Home::class.java)
        intent.putExtra(Home.USER_DATA, list)

        startActivity(intent)
        finish()
    }

    private fun parseJson(): ArrayList<User> {
        //json file to string
        val jsonfile: String =
            applicationContext.assets.open("githubuser.json").bufferedReader().use { it.readText() }
        val list = arrayListOf<User>()
        try {
            val obj = JSONObject(jsonfile)
            val user = obj.getJSONArray("users")

            for (i in 0 until user.length()) {
                val userData = user.getJSONObject(i)
                val userTemp = User(
                    userData.getString("username"),
                    userData.getString("name"),
                    getDrawableId(getSourceName(userData.getString("avatar"))),
                    userData.getString("company"),
                    userData.getString("location"),
                    userData.getInt("repository"),
                    userData.getInt("follower"),
                    userData.getInt("following")
                )

                list.add(userTemp)
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return list
    }

    private fun getSourceName(srcName: String): String {
        val name = srcName.substringAfter('/')
        return name
    }

    private fun getDrawableId(name: String): Int {
        val id = resources.getIdentifier(name, "drawable", packageName)
        return id
    }
}