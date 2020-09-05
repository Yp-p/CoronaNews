package com.tphtwe.newswide.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tphtwe.newswide.R
import com.tphtwe.newswide.ui.home.adapter.CoronaAdapter
import kotlinx.android.synthetic.main.fragment_corona.*

class CoronaFragment : Fragment() {
    private lateinit var coronaViewModel: CoronaViewModel
    lateinit var coronaAdapter: CoronaAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_corona, container, false)
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coronaViewModel = ViewModelProvider(this).get(CoronaViewModel::class.java)
        coronaAdapter = CoronaAdapter()
        coronaRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = coronaAdapter
        }
        observeViewModel()
    }

    fun observeViewModel() {
        coronaViewModel.getResult().observe(
            viewLifecycleOwner, Observer {
                coronaAdapter.updateCountry(it)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        coronaViewModel.loadResult()
    }
}