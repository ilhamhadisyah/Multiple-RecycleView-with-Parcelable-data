package com.ilham.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilham.githubuser.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    var userData = ArrayList<User>()
    companion object {
        const val USER_DATA = "User Data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userData = intent.getParcelableArrayListExtra<User>(USER_DATA) as ArrayList<User>

        showTopUserList(UserSelection().topUserSelector(userData))
        showList(UserSelection().userSelector(userData))
    }

    private fun showList(list: ArrayList<User>) {
        binding.mainRv.layoutManager = LinearLayoutManager(this)
        val itemAdapter = MainChildAdapter(list)
        binding.mainRv.adapter = itemAdapter
    }

    private fun showTopUserList(list: ArrayList<User>) {
        binding.topUserRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val itemAdapter = topUserAdapter(list)
        binding.topUserRecycler.adapter = itemAdapter
    }

}

