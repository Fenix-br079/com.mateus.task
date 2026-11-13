package com.mateus.task.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.mateus.task.R
import com.mateus.task.databinding.FragmentHomeBinding
import com.mateus.task.ui.adapter.ViewPagerAdapter
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = ViewPagerAdapter(requireActivity()).apply {
            addFragment(TodoFragment(), R.string.status_task_todo)
            addFragment(DoingFragment(), R.string.status_task_doing)
            addFragment(DoneFragment(), R.string.status_task_done)
        }
        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = adapter.itemCount
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = getString(adapter.getTitle(position))
        }.attach()

        binding.ibLogout.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
