package com.ilham.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ilham.githubuser.databinding.ActivityUserDetailBinding

class UserDetail : AppCompatActivity() {
    private lateinit var binding: ActivityUserDetailBinding

    companion object {
        const val USER_DATA_DETAIL = "User Data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userData = intent.getParcelableExtra<User>(USER_DATA_DETAIL) as User
        bind(userData)

        binding.fabBack.setOnClickListener(actionListener)

    }

    val actionListener = View.OnClickListener { view ->
        when (view.id) {
            binding.fabBack.id -> {
                finish()
            }
        }
    }

    private fun bind(user: User) {
        binding.nameDetailUser.text = user.name
        binding.nameDetailUsername.text = "@${user.username}"
        binding.userDetailAvatar.setImageResource(user.avatar)
        binding.userDetailFollower.text = user.follower.toString()
        binding.userDetailFollowing.text = user.following.toString()
        binding.userDetailLocation.text = user.location
        binding.userDetailRepository.text = user.repository.toString()
        binding.userDetailWorkAt.text = user.company
        binding.badge.visibility = isVisible(user.follower)
        binding.isTopUser.visibility = isVisible(user.follower)
    }

    fun isVisible(follower : Int): Int {
        if (follower <5000){
            return View.GONE
        }
        else{
            return View.VISIBLE
        }
    }


}