package com.example.data

import java.io.Serializable

//Extnesion fucntion rand to shuffle items in list
//So that each time user call it with list we get and random item
private fun <T> List<T>.rand() = shuffled().first()
private fun roll(start:Int,end:Int) = (start..end).toList().rand().toString()

private val firstName = listOf("Ananya", "Palak", "Ashish", "Prerna", "Suman", "Vicky", "Akhil") //lis of first names
private val lastName = listOf("Behera", "Chanana", "Gupta", "Pandey","Sharma", "Malhotra", "") //list of last names
private val  hobby = listOf("Painting","Dancing","Singing","Playing","Cooking","Driving")//list of hobbies
private val city = listOf("Delhi","Mumbai","Bengaluru","Kolkata","Chennai","Ahemdabad","Hyderabad","Pune","Jaipur")

//Here i use object class,as always there will be only one instance
     // need to create user identity, everytime
object CharacterGenerator {

    //data class declared to store name vairable which is serializable
    data class CharacterData(val name: String, val age: String,val hobby: String,  val number: String, val city: String)  : Serializable

    private fun name() = "${firstName.rand()} ${lastName.rand()}" //Here Use String Template to print the name

    private fun ageGroupGen() = listOf("8-14","15-20", "21-24", "25-32", "33-40", "41-48", "49-60").rand()  //Function which generate random age group

    private fun hobbyGen() = "${hobby.rand()}" //Function to generate random hobbies

    private fun cityGen() = "${city.rand()}" //Function to generate random cities

    private fun phoneNumGen() = "${roll(700,999)}${roll(100,999)}${(roll(1000,9999))}" //Function to generate random phone number

    fun generate() = CharacterData(name = name(),
        age = ageGroupGen(),
        hobby = hobbyGen(),
        number = phoneNumGen(),
        city = cityGen())
}