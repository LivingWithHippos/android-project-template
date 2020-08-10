package com.github.livingwithhippos.androidtemplate.start.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.github.livingwithhippos.androidtemplate.databinding.FragmentStartBinding
import com.github.livingwithhippos.androidtemplate.start.model.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StartFragment : Fragment() {

    // ViewModel shared with main activity and eventually other fragments
    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentStartBinding.inflate(inflater, container, false)

        val positionAdapter = PositionAdapter()
        binding.adapter = positionAdapter

        viewModel.positionsLiveData.observe(viewLifecycleOwner, Observer { positions ->
            positionAdapter.submitList(positions)
        })

        binding.bLoad.setOnClickListener {
            val description = if (binding.tiDescription.text.toString().isNotEmpty()) binding.tiDescription.text.toString() else "android"
            val location = if (binding.tiLocation.text.toString().isNotEmpty()) binding.tiLocation.text.toString() else "berlin"
            viewModel.fetchPositionsInfo(description, location)
        }
        return binding.root
    }

}