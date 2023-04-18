package com.example.dataofRoK.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.DataofRoK.databinding.FragmentProfilBinding
import com.example.DataofRoK.databinding.MembersItemBinding
import com.example.dataofRoK.MembersViewModel
import com.example.dataofRoK.adapter.MembersAdapter
import com.example.dataofRoK.data.ProfilRepository
import com.example.dataofRoK.data.Repository
import com.example.dataofRoK.data.model.Members
import com.example.dataofRoK.data.model.Profil
import com.example.dataofRoK.data.remote.MembersApiService


class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MembersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilBinding.inflate(inflater,container,false)


        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val memberId = requireArguments().getLong("Id")

        viewModel.members.observe(viewLifecycleOwner) { list ->
            val title = list.find { it.Id == memberId }

            if (title != null) {
                binding.profilFragmentMaterialtoolbar.setTitle(title.Name)
            }


        }
        viewModel.members.observe(viewLifecycleOwner) { list ->
            val member = list.find { it.Id == memberId }
            if (member != null) {
                binding.profilFragmentName.text = member.Name
                binding.profilFragmentEnergy.text = member.Energy.toString()
                binding.profilFragmentId.text = member.Id.toString()
                binding.profilFragmentKingdom.text = member.Kd.toString()
                binding.profilFragmentAlliance.text = member.Alliance

                binding.profilFragmentT1kills.text = member.KillsTOne.toString()
                binding.profilFragmentT2kills.text = member.KillsTTwo.toString()
                binding.profilFragmentT3kills.text = member.KillsTThree.toString()
                binding.profilFragmentT4kills.text = member.KillsTFour.toString()
                binding.profilFragmentT5kills.text = member.KillsTFive.toString()
                binding.profilFragmentKillpoints.text = member.KillPoints.toString()
                binding.profilFragmentDeathtroops.text = member.Dead.toString()
                binding.profilFragmentHelpclicks.text = member.HelpClicks.toString()

            }
        }
         val profil = ProfilRepository().loadProfil()
        binding.profilFragmentName.text = profil[0].Name
        binding.profilFragmentEnergy.text = profil[0].Energy.toString()
        binding.profilFragmentId.text = profil[0].Id.toString()
        binding.profilFragmentKingdom.text = profil[0].Kd.toString()
        binding.profilFragmentAlliance.text = profil[0].Alliance
        binding.profilFragmentT1kills.text = profil[0].KillsTOne.toString()
        binding.profilFragmentT2kills.text = profil[0].KillsTTwo.toString()
        binding.profilFragmentT3kills.text = profil[0].KillsTThree.toString()
        binding.profilFragmentT4kills.text = profil[0].KillsTFour.toString()
        binding.profilFragmentT5kills.text = profil[0].KillsTFive.toString()
        binding.profilFragmentAllkills.text = "156786589"
        binding.profilFragmentKillpoints.text = profil[0].KillPoints.toString()
        binding.profilFragmentDeathtroops.text = profil[0].Dead.toString()
        binding.profilFragmentHelpclicks.text = profil[0].HelpClicks.toString()

    }




    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
