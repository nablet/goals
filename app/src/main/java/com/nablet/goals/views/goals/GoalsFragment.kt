package com.nablet.goals.views.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nablet.goals.MainViewModel
import com.nablet.goals.R
import com.nablet.goals.databinding.FragmentGoalsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GoalsFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentGoalsBinding>(
            inflater,
            R.layout.fragment_goals,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}
