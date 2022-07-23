package it.elsalamander.calculatorbridge.calculator.operator

import java.util.*

/**
 * Ci sono diversi tipi di operatori, ogni operatore ha
 * Stringa identificativa: "+", "/", "ln", "sin", ...
 * Assegnato c'è un operatore che ha:
 * - Nome: Rindondanza stringa identificativa per la registrazione
 * - Priorità: 0,1,2,3,... di esecuzione "+"= 1 ; "/"= 2 ; "ln"= 3
 * - Numero di parametri richiesti: 1 o 2
 *
 * Un operator può essere formato da tutto l'alfabeto con in aggiunta
 * "+" ; "-" ; "/" ; "*"
 *
 * Tutti i numeri e le () [] terminano l'operatore
 *
 */
abstract class Operator(val name : String, val prio : Int, val numArgs : Int) {

    companion object{
        val map = TreeMap<String, Operator>()

        /**
         * Ritorna l'operator con quella sistassi
         */
        fun getOperator(operator : String) : Operator?{
            return map[operator]
        }
    }

    init{
        map[name] = this
    }

}