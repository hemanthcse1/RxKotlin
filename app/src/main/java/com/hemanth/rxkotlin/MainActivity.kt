package com.hemanth.rxkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hemanth.rxkotlin.data.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // fistExample()

        // fromOperator()

        // fromIterableOperator()

        // rangeOperatorMethod()

        // repeateOperatorMethod()

        // intervalOperatorMethod()

        // timerOperatorMethod()

        // createOperatorMethod()

        // filterOperatorMethod()

        // lastOperatorMethod()

        distinctOperatorMethod()

    }

    private fun distinctOperatorMethod() {

        distinctOperator()
            //.distinct() // it will compare whole object
            .distinct { it.age } // distict based on age
            .subscribe(
                {
                    Log.d(TAG, "onNext: "+it.name)
                },
                {
                    Log.d(TAG, "onError: "+it.toString())
                },
                {
                    Log.d(TAG, "onComplete: ")
                }
            )
    }

    private fun lastOperatorMethod() {

        lastOperator()
            .filter {
                it.age >= 25
            }
            //.lastElement()
            //.lastOrError() // if list is empty
            .last(User(1,"Hemanth",30))
            .subscribe(
                {
                    Log.d(TAG, "onNext: "+it.name)
                },
                {
                    Log.d(TAG, "onError: "+it.toString())
                }
            )
    }

    private fun filterOperatorMethod() {

        filterOperator()
            .filter {
               // it.age < 25
                it.name == "Hemanth"
            }
            .subscribe(
                {
                    Log.d(TAG, "onNext: "+it.name)
                },
                {
                    Log.d(TAG, "onError: "+it.toString())
                },
                {
                    Log.d(TAG, "onComplete: ")
                }
            )
    }

    private fun createOperatorMethod() {

        createOperator().subscribe(
            {
                Log.d(TAG, "onNext: " + it)
            },
            {
                Log.d(TAG, "onError: " + it.toString())
            },
            {
                Log.d(TAG, "onComplete: ")
            }
        )
    }

    private fun timerOperatorMethod() {

        timerOperator().subscribe(
            {
                Log.d(TAG, "onNext: " + it)
                getLocation()
            },
            {
                Log.d(TAG, "onError: " + it.toString())
            },
            {
                Log.d(TAG, "onComplete: ")
            }
        )
    }

    private fun intervalOperatorMethod() {

        intervalOperator().subscribe(
            {
                Log.d(TAG, "onNext: " + it)
                getLocation()
            },
            {
                Log.d(TAG, "onError: " + it.toString())
            },
            {
                Log.d(TAG, "onComplete: ")
            }
        )
    }

    private fun getLocation() {
        Log.d(TAG, "Latitude: 102.0303 Longitude: 1.26456")
    }

    private fun repeateOperatorMethod() {

        repeateOperator().subscribe(
            {
                Log.d(TAG, "onNext: " + it)
            },
            {
                Log.d(TAG, "onError: " + it.toString())
            },
            {
                Log.d(TAG, "onComplete: ")
            }
        )
    }

    private fun rangeOperatorMethod() {

        rangeOperator().subscribe(
            {
                Log.d(TAG, "onNext: ${it}")
            },
            {
                Log.d(TAG, "onError: " + it.toString())
            },
            {
                Log.d(TAG, "onComplete: ")
            }
        )


    }


    private fun fistExample() {
        val observable = Observable.just(1, 2, 3, 4, 5)

        val observer = object : Observer<Int> {
            override fun onSubscribe(d: Disposable?) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onNext(t: Int?) {
                Log.d(TAG, "onNext: ${t}")
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, "onError: " + e.toString())
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }

        }

        observable.subscribe(observer)

    }
}