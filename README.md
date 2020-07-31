# FoodOrderingSystem

Food Ordering System contains 3 main components: Customer's app, Cook's App and a Server.

## How it works?
The customers register in the app (his account will be stored in Firebase) then he can choose the food/product they want and place an order. The address for delivery can be manually typed by user or it can be automatically generated based on the GPS (using Geolocator).
The order will be stored in Firebase an also in a local database (for backup). Local database will be accessed through the Server (TCP/IP Socket server).
In the Cook's app all active orders can be seen.

## Customer's app:
This app is for customers where they can see the restaurant's menu, choose the products they want and place an order. Also customers can see their own order history.

## Server:
TCP/IP Socket server for accessing the SQLite database and store orders for backup.
Main backend(database) is on Firebase.

## Cook's app
Here, only the cooker and the system administrator has access. All cookers have separate account and can log in to see pending orders and accept them.
