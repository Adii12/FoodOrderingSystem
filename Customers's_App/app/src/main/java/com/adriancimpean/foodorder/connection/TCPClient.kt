package com.adriancimpean.foodorder.connection

import android.content.Context
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.InetSocketAddress
import java.net.Socket
import java.net.UnknownHostException

class TCPClient(context : Context, msg: String) : Thread() {
    private val SERVER_IP = "192.168.0.126"
    private val PORT = 8000
    private val HEADER = 10
    private var messsage  = msg
    private var context = context


    override fun run() {
        try {
            val clientSocket = Socket()
            clientSocket.connect(InetSocketAddress(SERVER_IP, PORT), 1000)

            val printWriter = PrintWriter(clientSocket.getOutputStream())
            println("Socket: ${clientSocket.isConnected}")

            val msg_length = messsage.length
            var send_length : String = msg_length.toString()
            send_length += " ".repeat(HEADER - send_length.length)

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