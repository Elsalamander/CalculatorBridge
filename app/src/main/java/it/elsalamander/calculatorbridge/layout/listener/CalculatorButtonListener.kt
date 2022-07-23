package it.elsalamander.calculatorbridge.layout.listener

import android.view.View
import android.widget.EditText
import android.widget.TextView
import it.elsalamander.calculatorbridge.R
import it.elsalamander.calculatorbridge.calculator.Calculator

class CalculatorButtonListener(val calculator: Calculator, val input: EditText, val resultText: TextView) : View.OnClickListener {

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {

        val result = calculator.calc(input.text.toString())
        resultText.text = result.toString()
    }
}