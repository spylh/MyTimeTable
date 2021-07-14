package jp.ac.aut.mytimetable

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


//通信周り、非同期処理のため分離
//あとコピペ()
public class HitAPITask{

    public suspend fun requestHttp(url:String?):String {
        var connection: HttpURLConnection
        var reader: BufferedReader
        val buffer: StringBuffer
        //GET
        val url = URL(url)
        connection = url.openConnection() as HttpURLConnection
        connection.connect()

        //bufferに取得したのを入れる
        val stream = connection.inputStream
        reader = BufferedReader(InputStreamReader(stream))
        buffer = StringBuffer()

        try {

            //doInBackground()
            Thread.sleep(800)
            //ここでAPIを叩きます。バックグラウンドで処理する内容です。
//                var line: String?
//                while (true) {
//                    line = reader.readLine()
//                    if (line == null) {
//                        break
//                    }
//                    buffer.append(line)
//                    Log.d("CHECK", buffer.toString())
//                }

                val jsonText = buffer.toString()
                return jsonText

            //ここからException潰し
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            //接続の切断
            finally {
                connection.disconnect()
                try {
                    reader?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

        withContext(Dispatchers.Main){
            //onPostExecute()
            Log.d("aaa","Task Finished!")
        }

        return "blank"

    }

}