package jp.ac.aut.mytimetable

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [myrouteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class myrouteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myroute, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url:String = "https://roote.ekispert.net/ja/result?arr=%E8%92%B2%E9%83%A1&arr_code=24899&connect=true&dep=%E8%87%AA%E7%94%B1%E3%82%B1%E4%B8%98(%E6%84%9B%E7%9F%A5%E7%9C%8C)&dep_code=29474&express=true&highway=true&hour&liner=true&local=true&minute&plane=true&shinkansen=true&ship=true&sleep=false&sort=time&surcharge=3&type=dep&via1=%E9%87%91%E5%B1%B1(%E6%84%9B%E7%9F%A5%E7%9C%8C)&via1_code=24877&via2=&via2_code="
//        val button = requireView().findViewById<Button>(R.id.test_button)
        val intent : Intent = Intent(requireContext().applicationContext,WebviewActivity::class.java)
        intent.putExtra("URL",url)
//        button.setOnClickListener {
//            startActivity(intent)
//        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment myrouteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            myrouteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}