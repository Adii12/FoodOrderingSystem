package com.adriancimpean.foodorder.order

class Item {

    var Name : String? = null
    var Description : String? = null
    var Price : Double? = null

    constructor(Name: String?, Description: String?, Price: Double?) {
        this.Name = Name
        this.Description = Description
        this.Price = Price
    }


}
