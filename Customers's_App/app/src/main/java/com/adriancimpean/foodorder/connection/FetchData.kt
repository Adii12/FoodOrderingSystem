package com.adriancimpean.foodorder.connection

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class FetchData(){
    companion object {
         fun getRequest(targetURL:String) : String{
             val url: URL
             var connection: HttpURLConnection? = null

             return try {
                 url = URL(targetURL)
                 connection = url.openConnection() as HttpURLConnection
                 connection.setRequestProperty("content-type", "application/json; charset=utf-8")
                 connection.setRequestProperty("Content-Language", "en-US")
                 connection.useCaches = false
                 connection.doInput = true
                 connection.doOutput = false
                 connection.requestMethod= "GET"

                 val inputStream: InputStream

                 val status = connection.responseCode

                 inputStream = if (status != HttpURLConnection.HTTP_OK) {
                     connection.errorStream
                 } else {
                     connection.inputStream
                 }

                 val br = BufferedReader(InputStreamReader(inputStream))
                 var line: String? = ""
                 val response = StringBuffer()

                 while (br.readLine().also({ line = it }) != null) {
                     response.append(line)
                     response.append("\n")
                 }
                 br.close()

                 response.toString()
             } catch (ex: Exception) {
                 ex.printStackTrace()
                 ""
             } finally {
                 connection?.disconnect()
             }
         }

    }
}