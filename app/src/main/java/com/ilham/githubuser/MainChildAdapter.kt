package com.ilham.githubuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ilham.githubuser.databinding.UserItemBinding

class MainChildAdapter(val users : ArrayList<User>): RecyclerView.Adapter<MainChildAdapter.viewHolder>() {
    inner class viewHolder(view : View) : RecyclerView.ViewHolder(view){
        val binding = UserItemBinding.bind(view)


        internal fun bind(user:User){
            binding.userAvatar.setImageResource(user.avatar)
            binding.userName.text= user.name
            binding.userPositon.text= user.company
            binding.userFollower.text = user.follower.toString()
            binding.userRepo.text = user.repository.toString()
        }
        init {
            view.setOnClickListener { view ->
                val position: Int = adapterPosition
                val tempUser = users[position]
                val user = User(
                    tempUser.username,
                    tempUser.name,
                    tempUser.avatar,
                    tempUser.company,
                    tempUser.location,
                    tempUser.repository,
                    tempUser.follower,
                    tempUser.following
                )
                val detailIntent = Intent(itemView.context, UserDetail::class.java)

                detailIntent.putExtra(UserDetail.USER_DATA_DETAIL,user)

                itemView.context.startActivity(detailIntent)
            }
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainChildAdapter.viewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: MainChildAdapter.viewHolder, position: Int) {
        val userIndex = users[position]
        holder.binding.userAvatar.borderWidth = 5
        holder.bind(userIndex)

    }

    override fun getItemCount(): Int {
        return users.size
    }
}