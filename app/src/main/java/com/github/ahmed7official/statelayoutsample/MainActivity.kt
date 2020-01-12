package com.github.ahmed7official.statelayoutsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
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
        //DONE
        stateLayout.showContent()
    }//showContent()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun showLoading(){
        //DONE
        stateLayout.stateLoading()
    }//showLoading()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun showError(){
        //DONE
        stateLayout.stateError()
    }//showError()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private fun showErrorWithRetry(){
        stateLayout.stateRetry(message = "In order to continue kindly check your internet connection and press retry"
        ){
            Toast.makeText(this, "on retry button click", Toast.LENGTH_SHORT).show()
        }
    }//showErrorWithRetry()


}//MainActivity
