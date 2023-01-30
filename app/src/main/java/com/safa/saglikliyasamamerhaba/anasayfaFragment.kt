package com.safa.saglikliyasamamerhaba

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [anasayfaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class anasayfaFragment : Fragment() {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var bmiTextView: TextView
    private lateinit var sensorManager: SensorManager
    private var stepCounterSensor: Sensor? = null
    private var stepCounter: Int = 0
    private lateinit var step_counter_text_view:TextView

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

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_anasayfa, container, false)

        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        weightEditText = view.findViewById(R.id.etWeight)
        heightEditText = view.findViewById(R.id.etHeight)
        calculateButton = view.findViewById(R.id.btnCalculate)
        bmiTextView = view.findViewById(R.id.tvResult)

        calculateButton.setOnClickListener {
            val weight = weightEditText.text.toString().toDouble()
            val height = heightEditText.text.toString().toDouble() / 100
            val bmi = weight / (height * height)
            bmiTextView.text = "Vki: %.2f".format(bmi)
            step_counter_text_view = view.findViewById(R.id.step_counter_text_view) as TextView
        }

    if (stepCounterSensor == null) {
        Toast.makeText(requireContext(), "Adım Sayacı Sensörü Bulunmamaktadır!", Toast.LENGTH_SHORT).show()
    } else {
        sensorManager.registerListener(
            stepCounterListener,
            stepCounterSensor,
            SensorManager.SENSOR_DELAY_UI
        )
    }
    return view
}
    override fun onResume() {
        super.onResume()
        registerListener()
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(stepCounterListener)
    }

    private val stepCounterListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_STEP_COUNTER) {
                stepCounter = event.values[0].toInt()
                step_counter_text_view.text = stepCounter.toString()

            }
        }
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            // Not in use
        }
    }
    

}

private fun registerListener() {

}






