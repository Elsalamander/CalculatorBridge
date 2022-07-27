package it.elsalamander.calculatorbridge.layout.listener

import android.view.View
import android.widget.EditText
import android.widget.TextView
import it.elsalamander.loaderclass.calculator.execute.Calculator

/****************************************************************
 * Evento da realizzare quando ci preme il bottone nella
 * calcolatrice
 *
 * @author: Elsalamander
 * @data: 14 luglio 2022
 * @version: v1.0
 ****************************************************************/
class CalculatorButtonListener(private val calculator: Calculator, private val input: EditText, private val resultText: TextView) : View.OnClickListener {

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