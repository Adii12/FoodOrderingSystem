import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

host = socket.gethostname()
port = 8000
print(socket.gethostname())
s.bind((host, port))

s.listen(5)

print('Server started')

while True:
    connection, address = s.accept()
    print(f"Connected ${address}")
    connection.send(bytes("muie", "utf-8"))
    connection.close()

