package com.example.android8338.twittelumapp.extensions

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream


fun Bitmap.decodificaParaBase64(): String {
    val byteArrayOutputStream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
    val ByteArray = byteArrayOutputStream.toByteArray()
    return Base64.encodeToString(ByteArray, Base64.DEFAULT)
}

