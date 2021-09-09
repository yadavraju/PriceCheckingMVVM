package com.raju.caperpricechecker.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlin.random.Random
import kotlinx.android.parcel.Parcelize

/**
 * I don't need to put SerializedName for this task but that is required when we pull data from rest
 * service
 */
@Parcelize
data class CartListDataItem(
    // putting id default random value for now
    @SerializedName("id") val id: String = Random.nextInt(1000).toString(),
    @SerializedName("name") val name: String = "",
    @SerializedName("price") val price: String = "",
    @SerializedName("qrUrl") val qrUrl: String = "",
    @SerializedName("thumbnail")
    val thumbnail: String =
    // Putting default thumb url because i haven't passed from form during item add
    "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/237/banana_1f34c.png"
) : Parcelable

val mockCartListData =
    mutableListOf(
        CartListDataItem(
            "1",
            "Banana",
            "$1.00",
            "https://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=0001",
            "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/237/banana_1f34c.png"),
        CartListDataItem(
            "2",
            "Apple",
            "$5.00",
            "https://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=0001",
            "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/237/banana_1f34c.png"),
        CartListDataItem(
            "3",
            "Other",
            "$10.00",
            "https://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=0001",
            "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/237/banana_1f34c.png"))
