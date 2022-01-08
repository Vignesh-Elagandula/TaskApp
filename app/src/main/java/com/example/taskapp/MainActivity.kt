package com.example.taskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.example.taskapp.adapter.RepoAdapter
import com.example.taskapp.databinding.ActivityMainBinding
import com.example.taskapp.db.RepoDao
import com.example.taskapp.db.RepoDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var repoDao: RepoDao = RepoDatabase.instance.getRepoDao()

    lateinit var repoAdapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnAddRepo = binding.btnAddrepo

        val recyclerView = binding.recyclerView

        repoAdapter = RepoAdapter(repoDao.queryAllAddedRepo())
        recyclerView.adapter = repoAdapter

        log("all data fetched as ${repoDao.queryAllAddedRepo()}")

        btnAddRepo.setOnClickListener {
            val intent = Intent(this, RepositoryAdd::class.java)
            startActivity(intent)
        }
    }

    fun log(s: String) {
        if (BuildConfig.DEBUG) {
            Log.d("TaskApp", s)
        }
    }

    override fun onResume() {
        super.onResume()
        (binding.recyclerView.adapter as RepoAdapter).setNewData(repoDao.queryAllAddedRepo())
    }

}