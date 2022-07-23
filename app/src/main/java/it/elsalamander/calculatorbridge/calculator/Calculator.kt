package it.elsalamander.calculatorbridge.calculator

import it.elsalamander.calculatorbridge.MainActivity
import javax.xml.xpath.XPathExpression
import kotlin.math.pow

class Calculator(val activity: MainActivity) {

    fun calc(expression : String) : Double{
        if(this.validate(expression)){
            return exec(expression)
        }
        return 0.0;
    }

    /**
     * Controlla se il numero delle parentesi aperte è lo stesso delle chiuse
     * per le () e le []
     */
    private fun validate(expression: String): Boolean {

        return false
    }

    /**
     * Avendo una stringa valida, scansiona ogni elemento della stringa
     *
     */
    private fun exec(expression: String): Double {
        var doNumber = NumberBuilder()

        //per ogni elemento della stringa
        expression.forEach {
            if(doNumber.isForNumber(it)){
                doNumber.addElement(it)
            }else{
                //non sono numeri
                //termina la formazione del numero
                //l'ultimo numero costruito si ottiene con:
                //doNumber.currentNumber
                doNumber.reset()
                when(it){

                    '+'->{

                    }
                }
            }
        }
        return 0.0
    }
}