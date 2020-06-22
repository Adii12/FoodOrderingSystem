import sqlite3

conn = sqlite3.connect("Orders.db", check_same_thread=False)

def createOrdersTable():
    string = "CREATE TABLE IF NOT EXISTS Orders (OrderID INTEGER PRIMARY KEY AUTOINCREMENT, Price REAL NOT NULL, CustomerID TEXT NOT NULL)"
    conn.execute(string)


def createOrderItemsTable():
    string = "CREATE TABLE IF NOT EXISTS OrderItems (ItemID INTEGER PRIMARY KEY AUTOINCREMENT, ItemName TEXT NOT NULL, OrderID INTEGER NOT NULL, FOREIGN KEY (OrderID) REFERENCES Orders(OrderID))"
    conn.execute(string)

def createTables():
    createOrdersTable()
    createOrderItemsTable()

def insertOrder(totalOrderPrice, customerID, ItemNamesList):
    orderString = "INSERT INTO Orders(Price, CustomerID) values (?, ?)"
    conn.execute(orderString, (totalOrderPrice, customerID))

    for item in ItemNamesList:
        orderItemsString = "INSERT INTO OrderItems(ItemName, OrderID) VALUES (?, (SELECT OrderID FROM Orders WHERE CustomerID=?))"
        conn.execute(orderItemsString, (item, customerID))

    conn.commit()
    print("[SERVER] Order stored succesfully")

def selectOrders():
    string = "SELECT Orders.OrderID, Orders.CustomerID, Orders.Price, OrderItems.ItemName FROM Orders INNER JOIN OrderItems On Orders.OrderID=OrderItems.OrderID;"
    cursor = conn.execute(string)

    for row in cursor :
        print("Order id =", row[0])
        print("CustomerID =", row[1])
        print("Total price =", row[2])
        print("Items =", row[3])
        print("\n")