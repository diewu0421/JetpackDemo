package com.example.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackdemo.widget.DampLayout

class NestedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested)

        findViewById<DampLayout>(R.id.root).setOnClickListener {
            it.scrollBy(0, 120)
            it.post {
                Log.e("NestedActivity","onCreate ${it.scrollY}")
            }
        }

        findViewById<RecyclerView>(R.id.rv).apply {
            layoutManager = LinearLayoutManager(this@NestedActivity, RecyclerView.VERTICAL, false)
            adapter = object : RecyclerView.Adapter<MyViewHolder> () {
                private val data by lazy { MutableList(100){ "content = $it"} }

                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): MyViewHolder {
                    val view = layoutInflater.inflate(R.layout.item_view_layout, parent, false)
                    return MyViewHolder(view)
                }

                override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                    holder.getView<TextView>(R.id.tv).text = data[position]
                }

                override fun getItemCount(): Int {
                    return data.size
                }



            }
        }
    }
}

class MyViewHolder(val view:View): RecyclerView.ViewHolder(view) {

    fun <T : View> getView(id: Int) = view.findViewById<T>(id)

}