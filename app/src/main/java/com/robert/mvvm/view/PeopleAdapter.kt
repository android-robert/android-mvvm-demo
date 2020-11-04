package com.robert.mvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.robert.mvvm.R
import com.robert.mvvm.databinding.ItemPeopleBinding
import com.robert.mvvm.model.People
import com.robert.mvvm.view.PeopleAdapter.PeopleAdapterViewHolder
import com.robert.mvvm.viewmodel.ItemPeopleViewModel
import java.io.File

class PeopleAdapter internal constructor() : RecyclerView.Adapter<PeopleAdapterViewHolder>() {
    private var peopleList: List<People>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleAdapterViewHolder {
        return PeopleAdapterViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_people, parent, false))
    }

    override fun onBindViewHolder(holder: PeopleAdapterViewHolder, position: Int) {
        holder.bindPeople(peopleList[position])
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    fun setPeopleList(peopleList: List<People>) {
        this.peopleList = peopleList
        notifyDataSetChanged()
    }

    class PeopleAdapterViewHolder(var binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.itemPeople) {
        fun bindPeople(people: People) {

            binding.peopleViewModel?.setPeople(people) ?:kotlin.run {
                binding.peopleViewModel = ItemPeopleViewModel(itemView.context, people)
            }

        }
    }

    init {
        peopleList = emptyList()
    }
}