package jp.ac.aut.mytimetable

import Ekispart_parse
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.coroutines.*


class searchFragment : Fragment() {
    public val rootView : View? = null
    val job  = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job)
    private lateinit var edittext : EditText
    private lateinit var button : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater,container,savedInstanceState)
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //オブジェの取得
        edittext = requireView().findViewById(R.id.station_name)
        val resultview = requireView().findViewById<ListView>(R.id.Search_result)
        val EkispartAPI : Ekispart_parse = Ekispart_parse()
        var Ekispa_result : ArrayList<Ekispart_parse.station_detail>
        lateinit var station_name : Array<String>
        var station_code : Array<Int>


        //onclick
        button = view?.findViewById<ImageButton>(R.id.searchButton)!!
        button.setOnClickListener{
            uiScope.launch {
                Ekispa_result = EkispartAPI.searchStationCode(edittext.text.toString()) as ArrayList<Ekispart_parse.station_detail>
                Ekispa_result.forEach{
                    station_name = arrayOf(it.name)
                    station_code = arrayOf(it.code)
                }
            }
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_expandable_list_item_1,
                station_name
            )

            resultview.adapter = adapter
        }

    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

}