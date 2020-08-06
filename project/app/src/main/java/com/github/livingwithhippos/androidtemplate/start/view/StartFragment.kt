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

        viewModel.positionsLiveData.observe(viewLifecycleOwner, Observer { positions ->
            positions?.forEach { Log.d("StartFragment", "Position: $it") }
        })

        binding.bLoad.setOnClickListener {
            viewModel.fetchPositionsInfo("android", "berlin")
        }
        return binding.root
    }

}