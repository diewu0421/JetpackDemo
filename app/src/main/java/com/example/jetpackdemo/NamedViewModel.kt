package com.example.jetpackdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   1/10/21 11:48 PM
 */
class NamedViewModel: ViewModel() {

    val name by lazy { MutableLiveData<String>()}

}