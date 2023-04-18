package com.example.dataofRoK.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.DataofRoK.R
import com.example.DataofRoK.databinding.FragmentMembersBinding
import com.example.dataofRoK.MembersViewModel
import com.example.dataofRoK.adapter.MembersAdapter


class MembersFragment: Fragment() {

    private var _binding: FragmentMembersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MembersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMembersBinding.inflate(inflater,container,false)

        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("LoadMembers",viewModel.members.value.toString())
        val membersAdapter = viewModel.members.value?.let { MembersAdapter(it) }
        binding.membersItemRecyclerview.adapter = membersAdapter

        viewModel.members.observe(viewLifecycleOwner){
            membersAdapter?.memberList
        }



    }
    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }


}
