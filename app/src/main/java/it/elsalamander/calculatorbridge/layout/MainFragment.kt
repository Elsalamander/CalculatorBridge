package it.elsalamander.calculatorbridge.layout

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import it.elsalamander.calculatorbridge.MainActivity
import it.elsalamander.calculatorbridge.R
import it.elsalamander.calculatorbridge.calculator.Calculator
import it.elsalamander.calculatorbridge.layout.listener.CalculatorButtonListener


class MainFragment : Fragment() {

    private val args: MainFragmentArgs by navArgs()
    lateinit var calculator : Calculator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        calculator = Calculator(context as MainActivity)

        val editText = view.findViewById<EditText>(R.id.calculator_input)
        val resultText = view.findViewById<TextView>(R.id.calculator_result)
        val button = view.findViewById<Button>(R.id.calculator_calc_button)

        val buttonListener = CalculatorButtonListener(calculator, editText, resultText)
        button.setOnClickListener(buttonListener)

        return view
    }


}