package jp.ac.aut.mytimetable

import Ekispart_parse
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class searchFragment : Fragment() {
    private lateinit var edittext : EditText
    private lateinit var button : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onCreateView(inflater,container,savedInstanceState)
        edittext = requireView().findViewById(R.id.station_name)
        val EkispartAPI : Ekispart_parse = Ekispart_parse()
        button = requireView().findViewById<Button>(R.id.searchButton)
        button.setOnClickListener{
            GlobalScope.launch{
                EkispartAPI.searchStationCode("")
            }
        }
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

}