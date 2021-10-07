package com.hemanth.rxkotlin

import android.util.Log
import com.hemanth.rxkotlin.MainActivity.Companion.TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*
import java.util.concurrent.TimeUnit

val mList = mutableListOf(1,2,3,4,5,6,7,8,9,10)
val arraysOfNum = arrayOf(1,2,3,4,5,6,7,8,9,10,11,12)
val arraysOfNum2 = arrayOf(10,20,30,40,50,60,70,80,90,100,110,120)

fun  justOperator(){

    val observable = Observable.just(mList)

    val observer = object : Observer<List<Int>> {
        override fun onSubscribe(d: Disposable?) {
            Log.d(MainActivity.TAG, "onSubscribe: ")
        }

        override fun onNext(t: List<Int>?) {
            Log.d(MainActivity.TAG, "onNext: ${t}")
        }

        override fun onError(e: Throwable?) {
            Log.d(MainActivity.TAG, "onError: "+e.toString())
        }

        override fun onComplete() {
            Log.d(MainActivity.TAG, "onComplete: ")
        }

    }

    observable.subscribe(observer)
}

fun fromOperator(){
    
    val observable = Observable.fromArray(arraysOfNum,arraysOfNum2)

    val observer = object : Observer<Array<Int>>{
        override fun onSubscribe(d: Disposable?) {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onNext(t: Array<Int>?) {
            Log.d(TAG, "onNext: ${Arrays.toString(t)}")
        }

        override fun onError(e: Throwable?) {
            Log.d(TAG, "onError: "+e.toString())
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete: ")
        }

    }

    observable.subscribe(observer)
}

fun fromIterableOperator(){

    val observable = Observable.fromIterable(mList)
    
    val observer = object: Observer<Int>{
        override fun onSubscribe(d: Disposable?) {
            Log.d(TAG, "onSubscribe: ")
        }

        override fun onNext(t: Int?) {
            Log.d(TAG, "onNext: ${t}")
        }

        override fun onError(e: Throwable?) {
            Log.d(TAG, "onError: "+e.toString())
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete: ")
        }

    }

    observable.subscribe(observer)
}

fun rangeOperator(): Observable<Int>{
    return Observable.range(1,100)
}

fun repeateOperator(): Observable<Int>{
    return Observable.range(1,10).repeat(2)
}

fun intervalOperator(): Observable<Long>{
    return Observable.interval(5,2,TimeUnit.SECONDS).takeWhile {
        value -> value <= 10
    }
}

fun timerOperator(): Observable<Long>{
    return Observable.timer(5,TimeUnit.SECONDS)
}