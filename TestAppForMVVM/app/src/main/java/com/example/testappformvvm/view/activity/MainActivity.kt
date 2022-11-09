package com.example.testappformvvm.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testappformvvm.databinding.ActivityMainBinding
import com.example.testappformvvm.view.adapter.TestAdapter
import com.example.testappformvvm.viewModel.ExampleDataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ExampleDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       viewModel.getAllData(108)
        viewModel.responser.observe(this){
            if (it != null) {
                binding.rv.layoutManager = LinearLayoutManager(this)
                binding.rv.adapter = TestAdapter(it)
                binding.rv.setHasFixedSize(true)
                (binding.rv.adapter as Any)
            }
        }

    }
}