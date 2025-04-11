package com.example.basicapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicapp.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList = listOf(
            MyItem("First Item", "This is the first item"),
            MyItem("Second Item", "This is the second item"),
            MyItem("Third Item", "This is the third item"),
            MyItem("Fourth Item", "Another interesting item"),
            MyItem("Fifth Item", "Final one in the list")
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(itemList)
    }
}
