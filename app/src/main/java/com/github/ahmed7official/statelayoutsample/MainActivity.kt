package com.github.ahmed7official.statelayoutsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.ahmed7official.statelayout.StateLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initListeners()
    }//onCreate()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun initListeners(){

        btnContent.setOnClickListener{showContent()}
        btnLoading.setOnClickListener{showLoading()}
        btnError.setOnClickListener{showError()}
        btnErrorWithRetry.setOnClickListener{showErrorWithRetry()}

    }//initListeners()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun showContent(){
        stateLayout.showContent()
    }//showContent()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun showLoading(){
        stateLayout.stateLoading()
    }//showLoading()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun showError(){
        stateLayout.stateError(
            title = "Internal Server Error",
            icon = R.drawable.ic_error
        )
    }//showError()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun showErrorWithRetry(){
        stateLayout.stateRetry(
            msg = "In order to continue kindly check your internet connection and try again after that."
        ){

            Toast.makeText(this, "Retry", Toast.LENGTH_SHORT).show()
        }
    }//showErrorWithRetry()


}//MainActivity
