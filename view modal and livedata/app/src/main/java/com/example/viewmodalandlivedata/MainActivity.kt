package com.example.viewmodalandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodalandlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.mainAcViewModal = viewModel
        binding.lifecycleOwner = this
//        viewModel.totalData.observe(this) {
//            binding.countText.text = it.toString()
//        }

//        binding.button.setOnClickListener {
//            viewModel.updateCount()
//        }
    }
}
