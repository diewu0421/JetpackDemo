package com.example.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.OnRebindCallback
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionManager
import com.example.jetpackdemo.bo.User
import com.example.jetpackdemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val model by lazy {
//        ViewModelProvider.NewInstanceFactory().create(NamedViewModel::class.java)
        ViewModelProvider(
            viewModelStore,
            ViewModelProvider.AndroidViewModelFactory(application)
        ).get(NamedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =

            DataBindingUtil.setContentView<ActivitySecondBinding>(this, R.layout.activity_second)
        val user = User().apply {
            name = model.name.value ?: "'default"
        }
        binding.setVariable(BR.user, user)
        binding.addOnRebindCallback(object : OnRebindCallback<ActivitySecondBinding>(){
            override fun onPreBind(binding: ActivitySecondBinding): Boolean {
                Log.e("SecondActivity","onPreBind ")
                return super.onPreBind(binding)
            }

            override fun onBound(binding: ActivitySecondBinding) {

                Log.e("SecondActivity","onBound ")
                super.onBound(binding)
                TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
            }
        })
        Handler().postDelayed({
            Log.e("SecondActivity","onCreate handle")


            user.name = "niahdadfads"

        }, 2000)

//        RxBus.getInstance().with("name").observe(this) {
//            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
//        }
    }
}