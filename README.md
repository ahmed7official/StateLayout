StateLayout
===========

StateLayout is a Layout enable you change and navigate between layout states easily just by a line of code.



[![img1][1]][1]
[![img2][2]][2]



implementation


    implementation 'com.github.ahmed7official:StateLayout:0.0.3'


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


  [1]: https://i.stack.imgur.com/0wmTe.jpg
  [2]: https://i.stack.imgur.com/ZkWC6.jpg
  [3]: https://i.stack.imgur.com/EXfWb.jpg
