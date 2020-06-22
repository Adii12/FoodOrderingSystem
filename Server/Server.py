import socket
import threading
import DatabaseHandler as db

PORT = 8000
HOST = socket.gethostbyname(socket.gethostname())
HEADER = 10
FORMAT = "utf-8"
DISCONNECT_MESSAGE = "!DISCONNECT"
CONNECTED_RESPONSE = f"Connected to server ({HOST})!"

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((HOST, PORT))


def handle_client(conn, addr):
    print(f"[NEW CONNECTION] {addr} connected.")

    connected = True
    while connected:
        msg_length = conn.recv(HEADER).decode(FORMAT)
        if msg_length:
            msg_length = int(msg_length)
            msg = conn.recv(msg_length).decode(FORMAT)
            
            print(f"[{addr}]: {msg}")

            if msg == DISCONNECT_MESSAGE:
                connected = False
                print(f"[DISCONNECT] {addr} disconnected.")
            else:
                handle_message(msg, conn)
    
    conn.close()


def start():
    print("[STARTING] Server is starting...")
    server.listen()
    db.createTables()
    print(f"[LISTENING] Server is listening on {HOST}")
    print("------------------------------------------")
    try:
        while True:
            conn, addr = server.accept()
            thread = threading.Thread(target=handle_client, args=(conn, addr))
            thread.start()
            print(f"[ACTIVE CONNECTIONS] {threading.activeCount() - 1}")
    except KeyboardInterrupt:
        print("[SERVER] Server is stopping...")
        raise



def handle_message(message, conn):
    if(message.startswith("!createOrder")):
        print("[SERVER] Order created.")
    
    elif(message.startswith("!showOrders")):
        db.selectOrders()
    
    elif(message.startswith("!createNewOrder")):
        #message received = msg_command, no of items, item1, item2...., totalOrderPrice, customerID
        msgList = message.split("|")
        del msgList[0]
        items = []  #store items from order

        for i in range(int(msgList[0])):
            items.append(msgList[i+1])

        print(msgList)
        print(items)

        totalOrderPrice=msgList[int(msgList[0])+1]
        customerID = msgList[int(msgList[0])+2]
        db.insertOrder(totalOrderPrice, customerID, items)
        
start()