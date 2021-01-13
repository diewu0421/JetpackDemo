package com.example.jetpackdemo.bo

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.jetpackdemo.BR

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   1/13/21 10:18 PM
 */
class User() : BaseObservable() {

    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var school: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.school)
        }
}