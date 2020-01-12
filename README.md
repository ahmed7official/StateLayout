StateLayout
===========

StateLayout is a Layout enable you to change and navigate between customizable layout states easily just by a line of code.


 <img src="https://raw.githubusercontent.com/ahmed7official/StateLayout/master/ezgif-5-108efa390e7e.gif" alt="alt text" width="270" >



build.gradle


    implementation 'com.github.ahmed7official:StateLayout:0.1.0'


Usage
-------

    <com.github.ahmed7official.statelayout.StateLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!--StateLayout should have only one child-->
    
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        
        <!--Your Content-->
        
    </androidx.constraintlayout.widget.ConstraintLayout>
    
    
    </com.github.ahmed7official.statelayout.StateLayout>



Available States
================

State Loading
-------

    stateLayout.stateLoading(
            message = "String",
            messageColor = R.color.colorPrimary,
            backgroundColor = R.color.colorAccent
        )

State Error
-----

    stateLayout.stateError(
            title = "Internal Server Error",
            titleTextColor = R.color.colorAccent,
            backgroundColor = R.color.colorAccent,
            icon = R.drawable.ic_error
        )


State Error With Retry Button
-----------------------

    stateLayout.stateRetry(
            title = "",
            titleTextColor = R.color.colorAccent,
            msg = "",
            msgTextColor = R.color.colorAccent,
            icon = R.drawable.ic_error,
            backgroundColor = R.color.colorAccent
        ){

            Toast.makeText(this, "Retry", Toast.LENGTH_SHORT).show()
        }



show content
------------

to show your layout content call `stateLayout.showContent()`


customization
=============

you can easily change and customize default style for any state screen by overriding style attributes

    <string name="loading_message">loading</string>
    <string name="error_title">Something went wrong</string>
    <string name="retry_title">Something went wrong</string>



    <color name="loadingMessageColor">#7C7C7C</color>
    <color name="loadingBackgroundColor">#FFFFFF</color>

    <!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->

    <color name="errorTitleColor">#616161</color>
    <color name="errorBackgroundColor">#FFFFFF</color>

    <!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->

    <color name="retryTitleColor">#616161</color>
    <color name="retryMessageColor">#7C7C7C</color>
    <color name="retryBackgroundColor">#FFFFFF</color>
    <color name="retryButtonBackgroundColor">#979797</color>
    <color name="retryButtonTextColor">#FFFFFF</color>


 
