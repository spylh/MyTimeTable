import android.util.Log
import jp.ac.aut.mytimetable.HitAPITask

public class Ekispart_parse{
    public suspend fun searchStationCode(station_name : String){
        var url : String = "http://api.ekispert.jp/v1/json/station/light?key=LE_LRFtfW2vJbVYS&name=高円寺&type=train"

        val httpReader : HitAPITask = HitAPITask()
        val jsonString = httpReader.requestHttp(url)

        Log.d("unko",jsonString)
    }

}
