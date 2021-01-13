package com.example.jetpackdemo

import androidx.lifecycle.MutableLiveData

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   1/11/21 1:04 AM
 */
class MyLivedata<T>  : MutableLiveData<T>(){

    override fun setValue(value: T) {
        super.setValue(value)
    }

    fun setValueStick(value: T) {
        super.setValue(value)
        javaClass.superclass?.superclass
            ?.getDeclaredField("mVersion")?.let {field->
                field.isAccessible = true
                field.set(this, -1)
            }
    }
}
