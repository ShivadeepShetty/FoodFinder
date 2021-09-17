package com.app.foodfinder.ui

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.foodfinder.adapter.HomeAdapter
import com.app.foodfinder.databinding.ActivityMainBinding
import com.app.foodfinder.viewmodel.HomeViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

private const val TAG = "HomeActivity"

@AndroidEntryPoint
public class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var homeAdapter: HomeAdapter
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        initRecyclerView()
        initSearchView()
    }

    private fun initViewModel() {
        this.viewModel.foodData.observe(this) {
            if (!TextUtils.isEmpty(binding.searchView.query)) {
                binding.recyclerView.visibility = View.VISIBLE
                binding.emptyView.visibility = View.GONE
                homeAdapter.submitData(it)
            } else {
                setEmptyView();
            }
        }
    }

    private fun setEmptyView() {
        homeAdapter.clearData()
        binding.emptyView.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun initRecyclerView() {
        homeAdapter = HomeAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = homeAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.dispose()
    }

    private fun initSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchData(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchData(query)
                return false
            }
        })


    }

}