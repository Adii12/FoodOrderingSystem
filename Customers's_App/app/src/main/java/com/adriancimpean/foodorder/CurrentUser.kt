package com.adriancimpean.foodorder

object CurrentUser {
    var firstName : String? = null
    var lastName : String? = null
    var username : String? = null
    var city : String? = null
    var county : String? = null
    var streetName : String? = null
    var streetNo : String? = null
    var phoneNo : String? = null
    var user_id : String? = null

    fun setData(firstName: String, lastName: String, username: String, city: String, county: String, streetName: String, streetNo: String, phoneNo: String, user_id : String) {
        this.firstName = firstName
        this.lastName = lastName
        this.username = username
        this.city = city
        this.county = county
        this.streetName = streetName
        this.streetNo = streetNo
        this.phoneNo = phoneNo
        this.user_id = user_id
    }
}