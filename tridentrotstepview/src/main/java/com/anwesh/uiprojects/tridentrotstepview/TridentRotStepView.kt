package com.anwesh.uiprojects.tridentrotstepview

/**
 * Created by anweshmishra on 15/02/19.
 */

import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.view.View
import android.view.MotionEvent

val nodes : Int = 5
val trids : Int = 2
val scGap : Float = 0.05f
val scDiv : Double = 0.51
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#4CAF50")
val backColor : Int = Color.parseColor("#212121")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.scaleFactor() : Float = Math.floor(this / scDiv).toFloat()
fun Float.mirrorValue(a : Int, b : Int) : Float = (1 - scaleFactor()) * a.inverse() + scaleFactor() * b.inverse()
fun Float.updateValue(dir : Float, a : Int, b : Int) : Float = mirrorValue(a, b) * dir * scGap

fun Canvas.drawTRSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    paint.color = foreColor 
    save()
    translate(w / 2, gap * (i + 1))
    rotate(90f * (1 - 2 * (i % 2)) * scale.divideScale(1, 2))
    drawLine(0f, size, 0f, -size/2, paint)
    drawLine(-size/2, -size/2, size/2 , -size/2,paint)
    save()
    translate(0f, -size / 2)
    for (j in 0..(trids - 1)) {
        val sc : Float = scale.divideScale(0, 2).divideScale(j, trids)
        drawLine(0f, 0f, 0f, -size / 4)
    }
    restore()
    restore()
}


