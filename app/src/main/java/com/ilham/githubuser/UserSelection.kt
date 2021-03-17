package com.ilham.githubuser

class UserSelection {
    fun topUserSelector (userData : ArrayList<User>) : ArrayList<User>{
        val selected = ArrayList<User>()
        var init = 0
        for (i in userData){
            if (userData[init].follower>=5000){
                selected.add(userData[init])
            }
            init +=1
        }
        return selected
    }
    fun userSelector (userData : ArrayList<User>) : ArrayList<User>{
        val selected = ArrayList<User>()
        var init = 0
        for (i in userData){
            if (userData[init].follower<5000){
                selected.add(userData[init])
            }
            init +=1
        }
        return selected
    }

}