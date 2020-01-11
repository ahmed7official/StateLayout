package com.github.ahmed7official.statelayout

import android.animation.LayoutTransition
import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.children
import com.google.android.material.button.MaterialButton

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


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()
        //TODO:
    }//onSaveInstanceState()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    override fun onRestoreInstanceState(state: Parcelable?) {
        super.onRestoreInstanceState(state)
        //TODO:
    }//onRestoreInstanceState()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

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

    fun stateRetry(
        title: String = "Something went wrong",
        titleTextColor: Int = android.R.color.white,
        msg: String? = null,
        msgTextColor: Int = R.color.textError,
        icon: Int = R.drawable.ic_warning,
        backgroundColor: Int = R.color.colorPrimaryDark,
        listener: () -> Unit
    ) {
        Log.i("zxc", "stateLoading()")

        layoutRetry.findViewById<TextView>(R.id.tvTitle).apply {
            text = title
            setTextColor(ContextCompat.getColor(context, titleTextColor))
        }

        layoutRetry.findViewById<MaterialButton>(R.id.btnRetry).setOnClickListener { listener() }
        layoutRetry.findViewById<ImageView>(R.id.retryImageView).setImageResource(icon)
        layoutRetry.findViewById<ConstraintLayout>(R.id.layoutRetry).setBackgroundColor(ContextCompat.getColor(context, backgroundColor))


        // - - - - - - - - - - - - - -
        // - - - - - - - - - - - - - -

        val tvMessage = layoutRetry.findViewById<TextView>(R.id.tvMessage)

        when(msg){

            null -> {
                tvMessage.visibility = View.GONE
            }

            else -> {
                tvMessage.apply {
                    visibility = View.VISIBLE
                    text = msg
                    setTextColor(ContextCompat.getColor(context, msgTextColor))
                }//apply
            }

        }//when

        // - - - - - - - - - - - - - -
        // - - - - - - - - - - - - - -


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

    }//stateRetry()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    fun stateError(
        title: String = "Something went wrong",
        titleTextColor: Int = android.R.color.white,
        icon: Int = R.drawable.ic_warning,
        backgroundColor: Int = R.color.colorPrimaryDark
    ) {

        layoutError.findViewById<TextView>(R.id.tvTitle).apply {
            text = title
            setTextColor(ContextCompat.getColor(context, titleTextColor))
        }

        layoutError.findViewById<ImageView>(R.id.errorImageView).setImageResource(icon)
        layoutError.findViewById<ConstraintLayout>(R.id.layoutError).setBackgroundColor(ContextCompat.getColor(context, backgroundColor))



        children.forEach {
            if (it == layoutError) {
                it.visibility = View.VISIBLE
                return@forEach
            }//if
        }//forEach

        children.forEach {
            if (it != layoutError) {
                it.visibility = View.GONE
            }//if
        }//forEach

    }//stateError()

}//StateLayout