package it.elsalamander.calculatorbridge.layout

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import it.elsalamander.calculatorbridge.MainActivity
import it.elsalamander.calculatorbridge.R


class EmptyFragment : Fragment() {

    private val args: EmptyFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return null
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.opzioni_estensioni, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.title == getString(R.string.rimuovi_estensione_text)){
            //elimina questa estensione
            (this.context as MainActivity).removeEstensione(args.value)
        }
        return super.onOptionsItemSelected(item)
    }
}