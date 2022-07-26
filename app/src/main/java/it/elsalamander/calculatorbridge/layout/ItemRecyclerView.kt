package it.elsalamander.calculatorbridge.layout

import android.graphics.Bitmap
import it.elsalamander.loaderclass.AbstractLoadClass
import org.json.JSONObject

/****************************************************************
 * Data per la recyclerView
 *
 * @author: Elsalamander
 * @data: 14 luglio 2022
 * @version: v1.0
 ****************************************************************/
class ItemRecyclerView(val title: String, val desc: String, val image: Bitmap, val json: JSONObject?) {

    constructor(extends : AbstractLoadClass, json : JSONObject) : this(extends.getTitle(),
        extends.getDescription(), extends.getImage(), json)
}