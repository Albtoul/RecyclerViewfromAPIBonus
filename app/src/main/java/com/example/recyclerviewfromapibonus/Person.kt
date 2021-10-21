package com.example.recyclerviewfromapibonus

class Person : ArrayList<Person.personItem>(){
    data class personItem(
        val name: String
    )
}