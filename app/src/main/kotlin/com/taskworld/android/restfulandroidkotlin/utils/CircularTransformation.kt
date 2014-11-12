package com.taskworld.android.restfulandroidkotlin.utils

import com.squareup.picasso.Transformation
import android.graphics.Bitmap
import com.taskworld.android.restfulandroidkotlin.extensions.tag
import android.graphics.Paint
import android.graphics.BitmapShader
import android.graphics.Shader
import android.graphics.Bitmap.Config
import android.graphics.Canvas

/**
 * Created by Kittinun Vantasin on 11/12/14.
 */

class CircularTransform : Transformation {

    override fun transform(source: Bitmap): Bitmap? {
        val paint = Paint()
        paint.setAntiAlias(true)
        paint.setShader(BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP))

        val output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Config.ARGB_8888)
        val canvas = Canvas(output)

        val sizeOfWidth = source.getWidth().toFloat() / 2
        val sizeOfHeight = source.getHeight().toFloat() / 2

        canvas.drawCircle(sizeOfWidth, sizeOfHeight, sizeOfWidth, paint)

        source.recycle()
        return output
    }

    override fun key(): String? {
        return tag()
    }

}