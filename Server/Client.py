import socket
import sys

PORT = 8000
HOST = "192.168.0.126"
HEADER = 10
FORMAT = "utf-8"
DISCONNECT_MESSAGE = "!DISCONNECT"

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    print("Connecting to server...")
    client.connect((HOST, PORT))
except:
    print("Error connecting to server")
    sys.exit()


def send(msg):
    message = msg.encode(FORMAT)
    msg_length = len(message)
    send_length = str(msg_length).encode(FORMAT)
    send_length += b' ' * (HEADER - len(send_length))
    client.send(send_length)
    client.send(message)



send("test World")
send("showTables")
send(DISCONNECT_MESSAGE)

