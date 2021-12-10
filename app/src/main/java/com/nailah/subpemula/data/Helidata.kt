package com.nailah.subpemula.data

import com.nailah.subpemula.R

object Helidata {
    private val heliNames = arrayOf(
        "Cake",
        "Cookies",
        "Pratata",
        "Donuts",
        "Jelly",
        "Macaron",
        "Rainbow Cake",
        "Breed Sobek",
        "Waffle"
    )

    private val heliDetails = arrayOf(
        "The delicious dessert and fillings are made, fresh to order, by our own baker.",
        "The delicious dessert and fillings are made, fresh to order, by our own baker.",
        "The delicious dessert and fillings are made, fresh to order, by our own baker.",
        "The delicious dessert and fillings are made, fresh to order, by our own baker.",
        "The delicious dessert and fillings are made, fresh to order, by our own baker.",
        "The delicious dessert and fillings are made, fresh to order, by our own baker.",
        "The delicious dessert and fillings are made, fresh to order, by our own baker.",
        "The delicious dessert and fillings are made, fresh to order, by our own baker.",
        "The delicious dessert and fillings are made, fresh to order, by our own baker."
    )


    private val heliImages = intArrayOf(
        R.drawable.cake,
        R.drawable.cookies,
        R.drawable.cream,
        R.drawable.donuts,
        R.drawable.jelly,
        R.drawable.macaron4,
        R.drawable.rainbow,
        R.drawable.roti,
        R.drawable.waffle
    )

    private val heliPrice = arrayOf(
        "$70",
        "$29",
        "$49",
        "$22",
        "$54",
        "$98",
        "$68",
        "$85",
        "$31",
        "$12",
    )

    val listHeli: ArrayList<Heli>
        get() {
            val list = arrayListOf<Heli>()
            for (position in heliNames.indices) {
                val heli = Heli()
                heli.name = heliNames[position]
                heli.desc = heliDetails[position]
                heli.image = heliImages[position]
                heli.price = heliPrice[position]
                list.add(heli)
            }
            return list
        }
}