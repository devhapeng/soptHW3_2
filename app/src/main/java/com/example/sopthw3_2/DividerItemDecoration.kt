package com.example.sopthw3_2//package com.example.sopthw3_2
//
//import android.content.Context
//import android.graphics.Canvas
//import androidx.recyclerview.widget.RecyclerView
//
//class DividerItemDecoration(private val mDivider: Context?, horizontal: Int) : RecyclerView.ItemDecoration() {
//
//    override fun onDraw(
//        canvas: Canvas,
//        parent: RecyclerView,
//        state: RecyclerView.State
//    ) {
//
//        val dividerLeft = parent.paddingLeft
//        val dividerRight = parent.width - parent.paddingRight
//        for (i in 0 until parent.childCount - 1) {
//            val child = parent.getChildAt(i)
//            val dividerTop =
//                child.bottom + (child.layoutParams as RecyclerView.LayoutParams).bottomMargin
//            val dividerBottom = dividerTop + mDivider!!.intrinsicHeight
//            mDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
//            mDivider.draw(canvas)
//        }
//    }
//}