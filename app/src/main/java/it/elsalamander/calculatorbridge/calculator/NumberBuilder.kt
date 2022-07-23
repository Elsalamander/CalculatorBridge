package it.elsalamander.calculatorbridge.calculator

import kotlin.math.pow

class NumberBuilder {

    var doNumber = false        //Sto costruendo un numero?
    var currentNumber = 0.0     //Il numero che sto costruendo
    var exp = 0.0               //esponente della base 10
    var neg = 1                 //sono dopo la virgola?

    fun addElement(ele : Char){
        when(ele){
            '1','2','3','4','5','6','7','8','9','0' ->{
                //è un numero
                doNumber = true
                currentNumber += Character.getNumericValue(ele) * 10.0.pow(exp)
                exp += neg
            }
            '.' ->{
                //punto
                //controlla se stavo facendo un numero
                if(doNumber){
                    neg = -1
                    exp = -1.0
                }
            }
        }
    }

    fun isForNumber(ele : Char) : Boolean{
        return when(ele){
            '1','2','3','4','5','6','7','8','9','0' -> true
            '.' -> doNumber
            else -> false
        }
    }

    fun reset() {
        doNumber = false
        exp = 0.0
        neg = 1
    }
}