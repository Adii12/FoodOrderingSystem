package com.adriancimpean.foodorder.connection

import android.util.Log
import okio.ByteString
import okio.ByteString.Companion.encode
import okio.ByteString.Companion.encodeUtf8
import java.io.*
import java.net.InetSocketAddress
import java.net.Socket
import java.net.UnknownHostException

class TCPClient(msg: String) : Thread() {
    private val SERVER_IP = "192.168.0.126"
    private val PORT = 8000
    private val HEADER = 10
    private var messsage  = msg


    override fun run() {
        try {
            var clientSocket = Socket()
            clientSocket.connect(InetSocketAddress(SERVER_IP, PORT), 1000)

            var printWriter = PrintWriter(clientSocket.getOutputStream())

            println("Socket: $clientSocket.isConnected")

           // var whiteSpaces = " ".repeat(HEADER-messsage.length)
            //println("FINAL MESSAGE: $finalMessage")
            //printWriter.print(messsage.length.toString()+whiteSpaces)
           // printWriter.print(messsage)

            var msg_length = messsage.length
            var send_length : String = msg_length.toString()
            send_length += " ".repeat(HEADER-send_length.length)

            printWriter.print(send_length)
            printWriter.print(messsage)

            printWriter.flush()
            printWriter.close()
            clientSocket.close()
            println("Socket closed ${clientSocket.isClosed}")

        } catch (unknownHostException : UnknownHostException) {
            Log.e("SOCKET CONNECTION", unknownHostException.printStackTrace().toString())
        } catch (ioException : IOException) {
            Log.e("SOCKET CONNECTION", ioException.printStackTrace().toString())
        }
    }

}