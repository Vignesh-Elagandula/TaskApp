package com.example.taskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentTransaction
import com.example.taskapp.databinding.ActivityRepositoryAddBinding

class RepositoryAdd : AppCompatActivity() {

    private lateinit var binding: ActivityRepositoryAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etOwnerName = binding.edtOwner
        val repoName = binding.edtRepoName

        val addToDb = binding.btnAddrepo

        addToDb.setOnClickListener {

        }

    }
}