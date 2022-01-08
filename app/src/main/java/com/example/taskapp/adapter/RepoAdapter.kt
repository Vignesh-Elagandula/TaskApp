package com.example.taskapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.R
import com.example.taskapp.databinding.RepodisplayRecyclerBinding
import com.example.taskapp.model.RepoDb

class RepoAdapter(var list: List<RepoDb>): RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var repoInfo: RepoDb? = null
        var binding: RepodisplayRecyclerBinding = RepodisplayRecyclerBinding.bind(view)
    }

    fun setNewData(d: List<RepoDb>) {
        list = d
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repodisplay_recycler, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.repoInfo = list[position]
        holder.binding.txtRepoName.text = holder.repoInfo?.name
        holder.binding.txtDescription.text = holder.repoInfo?.description

    }

    override fun getItemCount(): Int {
        return list.size
    }
}