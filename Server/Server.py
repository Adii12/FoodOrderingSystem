import socket
import threading
import DatabaseHandler as db

PORT = 8000
HOST = socket.gethostbyname(socket.gethostname())
HEADER = 10
FORMAT = "utf-8"
DISCONNECT_MESSAGE = "!DISCONNECT"

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
            
            if msg == DISCONNECT_MESSAGE:
                connected = False
                print(f"[DISCONNECT] {addr} disconnected.")
            else:
                handle_message(msg)

            print(f"[{addr}]: {msg}")

    conn.close()


def start():
    print("[STARTING] Server is starting...")
    server.listen()
    db.createTable()
    print(f"[LISTENING] Server is listening on {HOST}")
    while True:
        conn, addr = server.accept()
        thread = threading.Thread(target=handle_client, args=(conn, addr))
        thread.start()
        print(f"[ACTIVE CONNECTIONS] {threading.activeCount() - 1}")


def handle_message(message):
    if(message.startswith("test")):
        db.test()
    elif(message.startswith("showTables")):
        db.showTables()
        db.showValues()


start()
