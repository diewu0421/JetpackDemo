package com.example.jetpackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private val model by lazy {
//        ViewModelProvider.NewInstanceFactory().create(NamedViewModel::class.java)
        ViewModelProvider(viewModelStore, ViewModelProvider.AndroidViewModelFactory(application)).get(NamedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(BasePresenter())

        model.name.observe(this) {
            findViewById<TextView>(R.id.tv).text = it
        }

        findViewById<TextView>(R.id.tv).setOnClickListener {
            Log.e("MainActivity","onCreate click")
//            RxBus.getInstance().with("name").setValueStick("如果真的太好")

            startActivity(Intent(this, SecondActivity::class.java))

//            Handler().postDelayed({
//
//                RxBus.getInstance().with("name").setValueStick("asdfkasdfj ")
//            }, 3000)

//            model.name.value += "asdf"

        }
    }

}
