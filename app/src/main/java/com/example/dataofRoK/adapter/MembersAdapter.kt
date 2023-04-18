package com.example.dataofRoK.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.DataofRoK.R
import com.example.DataofRoK.databinding.MembersItemBinding
import com.example.dataofRoK.data.model.Members

class MembersAdapter (var memberList: List<Members>,
    /* val onClick : (Members) -> Unit */)
    : RecyclerView.Adapter<MembersAdapter.MembersHolder>() {

    private var dataset = listOf<Members>()

    class MembersHolder (val binding: MembersItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(members: Members){

            binding.membersItemName.text = members.Name
            binding.membersItemKd.text = members.Kd.toString()
            binding.membersItemEnergy.text = members.Energy.toString()


        }
    }

    fun submitList(list: List<Members>){
        dataset = list
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MembersHolder{
        val binding = MembersItemBinding.inflate(
            LayoutInflater.from(parent.context)
            ,parent,false)
        return MembersHolder(binding)

    }

    override fun onBindViewHolder(holder: MembersHolder , position: Int) {
        holder.bind(memberList.get(position))
        holder.binding.root.setOnClickListener{

        }
    }



    override fun getItemCount(): Int {
        return memberList.size
    }


}