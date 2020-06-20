import sqlite3

conn = sqlite3.connect("Orders.db", check_same_thread=False)

def createTable():
    string = "CREATE TABLE IF NOT EXISTS test (name TEXT)"
    conn.execute(string)

def showTables():
    res = conn.execute("SELECT name FROM sqlite_master WHERE type='table';")
    for name in res:
        print(name[0])


def test():
    string = "INSERT INTO test(name) VALUES ('iteeeeeem')"
    conn.execute(string)
    conn.commit()
    print("Command executed succesfully")

def showValues():
    string = "SELECT * FROM test"
    print("here")
    cursor = conn.execute(string)
    for row in cursor:
        print ("[ITEM]", row[0])
