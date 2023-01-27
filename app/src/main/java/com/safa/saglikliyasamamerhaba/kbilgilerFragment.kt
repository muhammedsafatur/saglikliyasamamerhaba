package com.safa.saglikliyasamamerhaba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [kbilgilerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class kbilgilerFragment : Fragment() {
    private lateinit var button: Button
    private lateinit var textView: TextView
    private val myArray = arrayOf("5 tane Şınav 3 Set", "5 Tane Barfiks 2 Set", "10 Mekik 3 Set", "10 Dakika koşu","1 Bardak Su iç","30 Dakika Bisiklet Sür","20 Squat Yap","30 Saniye Plank")
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

        val view = inflater.inflate(R.layout.fragment_kbilgiler, container, false)

        button = view.findViewById(R.id.button)
        textView = view.findViewById(R.id.textView)

        button.setOnClickListener {
            val randomText = myArray.random()
            textView.text = randomText
        }

return view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment kbilgilerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            kbilgilerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
