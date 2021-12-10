package com.nailah.subpemula.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Heli(
var image : Int = 0,
var name : String = "",
var desc : String = "",
var price : String = ""
): Parcelable
