package it.elsalamander.calculatorbridge.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import it.elsalamander.calculatorbridge.MainActivity
import it.elsalamander.calculatorbridge.R
import it.elsalamander.calculatorbridge.layout.listener.CalculatorButtonListener
import it.elsalamander.loaderclass.calculator.execute.Calculator

/****************************************************************
 * Fragment per la calcolatrice
 *
 * @author: Elsalamander
 * @data: 14 luglio 2022
 * @version: v1.0
 ****************************************************************/
class MainFragment : Fragment() {

    private val args: MainFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val calculator = (context as MainActivity).calculator

        val editText = view.findViewById<EditText>(R.id.calculator_input)
        val resultText = view.findViewById<TextView>(R.id.calculator_result)
        val button = view.findViewById<Button>(R.id.calculator_calc_button)

        val buttonListener = CalculatorButtonListener(calculator, editText, resultText)
        button.setOnClickListener(buttonListener)

        return view
    }


}