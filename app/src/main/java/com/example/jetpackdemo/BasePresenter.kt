package com.example.jetpackdemo

import android.util.Log
import androidx.lifecycle.*

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   1/10/21 8:24 PM
 */
class BasePresenter : LifecycleEventObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.e("BasePresenter","onCreate ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.e("BasePresenter","onResume ")
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.e("BasePresenter","onStateChanged $event")
    }
}