package com.github.ahmed7official.statelayout

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.children
import com.google.android.material.button.MaterialButton

class StateLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {


    private val layoutLoading by lazy {
        LayoutInflater.from(context).inflate(R.layout.layout_loading, null, false)
    }//lazy

    private val layoutRetry by lazy {
        LayoutInflater.from(context).inflate(R.layout.layout_retry, null, false)
    }//lazy


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    override fun onFinishInflate() {
        super.onFinishInflate()


        layoutLoading.visibility = View.GONE
        addView(layoutLoading)
        //
        layoutRetry.visibility = View.GONE
        addView(layoutRetry)



        layoutTransition = LayoutTransition()

    }//onFinishInflate()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    fun showContent() {
        Log.i("zxc", "showContent()")


        var flagFirstView = true

        children.forEach {
            if (flagFirstView) {
                flagFirstView = false
                it.visibility = View.VISIBLE
            } else {
                it.visibility = View.GONE
            }
        }//forEach


    }//showContent()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    fun stateLoading(loadingMessage: String = "Loading, please wait") {
        Log.i("zxc", "stateLoading()")

        layoutLoading.findViewById<TextView>(R.id.tvLoading).text = loadingMessage

        children.forEach {
            if (it == layoutLoading) {
                it.visibility = View.VISIBLE
            } else {
                it.visibility = View.GONE
            }
        }//forEach

    }//showContent()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    fun stateRetry(retryMessage: String = "Something went wrong", listener: () -> Unit) {
        Log.i("zxc", "stateLoading()")

        layoutRetry.findViewById<TextView>(R.id.tvRetryMessage).text = retryMessage
        layoutRetry.findViewById<MaterialButton>(R.id.btnRetry).setOnClickListener { listener() }

        children.forEach {
            if (it == layoutRetry) {
                it.visibility = View.VISIBLE
                return@forEach
            }//if
        }//forEach

        children.forEach {
            if (it != layoutRetry) {
                it.visibility = View.GONE
            }//if
        }//forEach

    }//showContent()

}//StateLayout