package com.example.taskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.taskapp.databinding.ActivityRepositoryAddBinding
import com.example.taskapp.db.RepoDao
import com.example.taskapp.db.RepoDatabase
import com.example.taskapp.model.RepoDb
import org.json.JSONObject

class RepositoryAdd : AppCompatActivity() {

    private lateinit var binding: ActivityRepositoryAddBinding

    var repoDao: RepoDao = RepoDatabase.instance.getRepoDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etOwnerName = binding.edtOwner
        val repoName = binding.edtRepoName

        val addToDb = binding.btnAddrepo

        addToDb.setOnClickListener {
            addRepo(etOwnerName.text.trim().toString(), repoName.text.trim().toString())
        }

    }

    fun log(s: String) {
        if (BuildConfig.DEBUG) {
            Log.d("TaskApp", s)
        }
    }

    private fun addRepo(ownerName: String, repoName: String) {
        val url = "https://api.github.com/repos/$ownerName/$repoName"
        val queue = Volley.newRequestQueue(this@RepositoryAdd)

        val repoInfo = RepoDb("", "")

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            {
                response ->
                if (response.getString("name").isNotEmpty()) {
                    log("name of response is $response")
                    Log.i("value" , "response received as follow $response")
                    val name = response.getString("name")
                    val description = response.getString("description")
                    repoInfo.name = name
                    repoInfo.description = description
                    repoDao.addRepo(repoInfo)
                    onBackPressed()
                }
        }, { error ->
                Toast.makeText(this@RepositoryAdd, "Not found!", Toast.LENGTH_SHORT).show()
        })

        queue.add(jsonObjectRequest)
    }
}