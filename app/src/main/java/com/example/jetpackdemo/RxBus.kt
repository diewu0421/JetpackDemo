package com.example.jetpackdemo

import androidx.lifecycle.MutableLiveData

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   1/11/21 12:14 AM
 */
class RxBus {
    private val mCache by lazy { hashMapOf<String, MyLivedata<Any>>() }

    @Synchronized
    fun with(key: String):MyLivedata<Any> {
        if (mCache[key] == null) {
            mCache[key] = MyLivedata()
        }

        return mCache[key]!!
    }
    companion object {
        fun getInstance() = Holder.INSTANCE
    }

    private class Holder {
        companion object {
            val INSTANCE = RxBus()
        }
    }
}