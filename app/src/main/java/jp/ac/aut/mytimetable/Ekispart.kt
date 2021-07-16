import android.util.Log
import com.squareup.moshi.Moshi
import jp.ac.aut.mytimetable.HitAPITask

public class Ekispart_parse{

    //データコンテナ、Stationしか使わん
    data class station(
        val code : Int,
        val Name : String,
        val Type : String,
        val Yomi : String
    )
    data class prefecture(
        val code : Int,
        val Name : String
    )
    data class point(
        val Station : station,
        val Prefecture : prefecture
    )
    data class response(
        val apiVersion :String,
        val engineVersion : String,
        val Point : List<point>
    )
    data class Root(
        val ResultSet:response,
    )

    data class station_detail(
        val code : Int,
        val name : String
    )

    //必要最低限の実装
     suspend fun searchStationCode(station_name : String): MutableList<station_detail> {
        var url : String = "http://api.ekispert.jp/v1/json/station/light?key=LE_LRFtfW2vJbVYS&name=$station_name&type=train"

        //httpリクエスト周り
        val httpReader : HitAPITask = HitAPITask()
        val jsonString = httpReader.requestHttp(url)

        //Json周り
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter<Root>(Root::class.java)
        val root = adapter.fromJson(jsonString)
        Log.d("CHECK","Result : ${root.toString()}")
        var result  = mutableListOf<station_detail>()

        Log.d("CHECK","Result : ${root.toString()}")
        val pointObj = root?.ResultSet?.Point

        for((index,value) in pointObj!!.withIndex()){
            result.add(station_detail(value.Station.code,value.Station.Name))
        }
        Log.d("","")
        return result


    }
}
