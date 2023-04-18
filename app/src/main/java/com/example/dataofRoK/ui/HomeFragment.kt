package com.example.dataofRoK.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.dataofRoK.MainActivity2
import com.example.DataofRoK.databinding.FragmentHomeBinding
import com.example.dataofRoK.LogInViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LogInViewModel by activityViewModels ()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

       val view = binding.root

        binding.homeFragmentIdtext.text = "53585738"
        binding.homeFragmentNametext.text = "Niesi"


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.currentUser.observe(viewLifecycleOwner){
            if(it == null){
                val intent = Intent(binding.root.context, MainActivity2::class.java)
                binding.root.context.startActivity(intent)
            }
        }
        binding.homeFragmentLogout.setOnClickListener {

            viewModel.logOut()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}

