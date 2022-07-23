package it.elsalamander.calculatorbridge.layout

import android.graphics.Bitmap
import it.elsalamander.loaderclass.AbstractLoadClass
import org.json.JSONObject

class ItemRecyclerView(val title: String, val desc: String, val image: Bitmap, val json: JSONObject?) {

    constructor(extends : AbstractLoadClass, json : JSONObject) : this(extends.getTitle(),
        extends.getDescription(), extends.getImage(), json)
}