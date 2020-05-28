package com.adriancimpean.foodorder.connection

import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


class FetchData{
    companion object {
        //GET
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

        //POST
        fun postRequest(targetURL: String, postData: JSONObject) : String{
            val url:URL
            var conn : HttpURLConnection? = null

            return try{
                url = URL(targetURL)
                conn=url.openConnection() as HttpURLConnection
                conn.setRequestProperty("content-type", "application/json; charset=utf-8")
                conn.setRequestProperty("Content-Language", "en-US")
                conn.useCaches = false
                conn.doInput = true
                conn.doOutput = true
                conn.requestMethod= "POST"

                val os = conn.outputStream
                val writer = BufferedWriter(OutputStreamWriter(os,"UTF-8"))

                writer.write(postData.toString())
                println(postData.toString())
                writer.flush()
                writer.close()
                os.close()

                val responseCode = conn.responseCode
                println(responseCode)
                var sb  : StringBuffer? = null

                if(responseCode == HttpURLConnection.HTTP_OK){
                    val input = BufferedReader(InputStreamReader(conn.inputStream))
                    sb = StringBuffer("")
                    var line : String? = ""
                    while(input.readLine().also { line = it } != null){
                        sb.append(line)
                        break
                    }
                    input.close()
                }
                return responseCode.toString()

            }catch (ex : java.lang.Exception){
                ex.printStackTrace()
                ""
            }finally {
                conn?.disconnect()
            }
        }
    }
}