package jp.ac.aut.mytimetable

import Ekispart_parse
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
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
        edittext = requireView().findViewById(R.id.station_name)
        val EkispartAPI : Ekispart_parse = Ekispart_parse()
        button = view?.findViewById<ImageButton>(R.id.searchButton)!!
        button.setOnClickListener{
            uiScope.launch {
                EkispartAPI.searchStationCode("")
                withContext(Dispatchers.Main){
                  Toast.makeText(context,"tinpo", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

}