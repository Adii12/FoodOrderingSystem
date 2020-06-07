package com.adriancimpean.foodorder.order

class Order {
    var id : String
    var items : ArrayList<String>
    var totalPrice : Double = 0.0

    constructor(id: String, items: ArrayList<String>, totalPrice: Double) {
        this.id = id
        this.items = items
        this.totalPrice = totalPrice
    }
}