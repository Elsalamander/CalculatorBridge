package it.elsalamander.calculatorbridge.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import it.elsalamander.calculatorbridge.R

class FragmentProva2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //view.findNavController().graph
        return inflater.inflate(R.layout.fragment_prova2, container, false)
    }
}