package com.github.ahmed7official.statelayout

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.children

class StateLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {


    private val layoutLoading by lazy {
        LayoutInflater.from(context).inflate(R.layout.layout_loading, this, false)
    }//lazy

    private val layoutRetry by lazy {
        LayoutInflater.from(context).inflate(R.layout.layout_retry, this, false)
    }//lazy

    private val layoutError by lazy {
        LayoutInflater.from(context).inflate(R.layout.layout_error, this, false)
    }//lazy


    override fun onFinishInflate() {
        super.onFinishInflate()


        layoutLoading.visibility = View.GONE
        addView(layoutLoading)
        //
        layoutRetry.visibility = View.GONE
        addView(layoutRetry)
        //
        layoutError.visibility = View.GONE
        addView(layoutError)



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

    fun stateLoading(
        message: String = context.getString(R.string.loading_message),
        messageColor: Int = R.color.loadingMessageColor,
        backgroundColor: Int = R.color.loadingBackgroundColor
    ) {

        layoutLoading.findViewById<TextView>(R.id.tvLoading).apply {
            text = message
            setTextColor(ContextCompat.getColor(context, messageColor))
        }

        layoutLoading.findViewById<LinearLayout>(R.id.layoutLoading).setBackgroundColor(ContextCompat.getColor(context, backgroundColor))


        setState(layoutLoading)

    }//stateLoading()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    fun stateRetry(
        title: String = context.getString(R.string.retry_title),
        titleTextColor: Int = R.color.retryTitleColor,
        message: String? = null,
        messageTextColor: Int = R.color.retryMessageColor,
        icon: Int = R.drawable.ic_warning,
        backgroundColor: Int = R.color.retryBackgroundColor,
        listener: () -> Unit
    ) {
        Log.i("zxc", "stateLoading()")

        layoutRetry.findViewById<TextView>(R.id.tvTitle).apply {
            text = title
            setTextColor(ContextCompat.getColor(context, titleTextColor))
        }

        layoutRetry.findViewById<TextView>(R.id.btnRetry).setOnClickListener { listener() }
        layoutRetry.findViewById<ImageView>(R.id.retryImageView).setImageResource(icon)
        layoutRetry.findViewById<ConstraintLayout>(R.id.layoutRetry).setBackgroundColor(ContextCompat.getColor(context, backgroundColor))


        // - - - - - - - - - - - - - -
        // - - - - - - - - - - - - - -

        val tvMessage = layoutRetry.findViewById<TextView>(R.id.tvMessage)

        when(message){

            null -> {
                tvMessage.visibility = View.GONE
            }

            else -> {
                tvMessage.apply {
                    visibility = View.VISIBLE
                    text = message
                    setTextColor(ContextCompat.getColor(context, messageTextColor))
                }//apply
            }

        }//when

        // - - - - - - - - - - - - - -
        // - - - - - - - - - - - - - -


       setState(layoutRetry)

    }//stateRetry()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    fun stateError(
        title: String = context.getString(R.string.error_title),
        titleTextColor: Int = R.color.errorTitleColor,
        icon: Int = R.drawable.ic_warning,
        backgroundColor: Int = R.color.errorBackgroundColor
    ) {

        layoutError.findViewById<TextView>(R.id.tvTitle).apply {
            text = title
            setTextColor(ContextCompat.getColor(context, titleTextColor))
        }

        layoutError.findViewById<ImageView>(R.id.errorImageView).setImageResource(icon)
        layoutError.findViewById<ConstraintLayout>(R.id.layoutError).setBackgroundColor(ContextCompat.getColor(context, backgroundColor))



        setState(layoutError)

    }//stateError()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun setState(state: View){

        children.forEach {
            if (it == state) {
                it.visibility = View.VISIBLE
                return@forEach
            }//if
        }//forEach

        children.forEach {
            if (it != state) {
                it.visibility = View.GONE
            }//if
        }//forEach

    }//setState()


}//StateLayout