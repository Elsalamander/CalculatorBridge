package it.elsalamander.calculatorbridge.layout

import android.graphics.Bitmap
import it.elsalamander.loaderclass.AbstractLoadClass

class ItemRecyclerView(val title : String, val desc : String, val image : Bitmap) {

    constructor(extends : AbstractLoadClass) : this(extends.getTitle(),
                                                    extends.getDescription(), extends.getImage())
}