package jp.ac.aut.mytimetable

import android.util.Log
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.github.kittinunf.fuel.httpGet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


//通信周り、非同期処理のため分離

public class HitAPITask{

    public suspend fun requestHttp(url:String?): String? {

        val result = runBlocking{
            val(request,response,result) = url?.httpGet()!!.awaitStringResponseResult()
            val data = result.fold(
                {data->data},
                {
                        error -> Log.e("unko","An error of type ${error.exception} happened: ${error.message}")
                        null
                }
            )
            return@runBlocking data
        }

        return result
    }

}