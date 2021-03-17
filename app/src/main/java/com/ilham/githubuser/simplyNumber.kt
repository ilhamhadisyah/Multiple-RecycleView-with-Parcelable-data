package com.ilham.githubuser

class simplyNumber {
    fun trim(num : Int): String{
        if(num >=1000){
            val numBack = num.toString().dropLast(3)
            return "$numBack K"
        }else{
            return num.toString()
        }
    }
}