package com.ilham.githubuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilham.githubuser.databinding.TopUserItemBinding

class topUserAdapter (val topUsers : ArrayList<User>): RecyclerView.Adapter<topUserAdapter.viewHolder>() {
    inner class viewHolder(view:View):RecyclerView.ViewHolder(view){
        val binding = TopUserItemBinding.bind(view)
        internal fun bind(user : User){
            binding.topUserName.text = user.name
            binding.topUserPosition.text = user.company
            binding.topUserFollowers.text = user.follower.toString()
            binding.topUserRepository.text = user.repository.toString()
            binding.topUserAvatar.setImageResource(user.avatar)
        }
        init {
            view.setOnClickListener{view->
                val position : Int = adapterPosition
                val tempUser = topUsers[position]
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): topUserAdapter.viewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.top_user_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return topUsers.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val topuserIndex = topUsers[position]
        holder.bind(topuserIndex)
    }


}
