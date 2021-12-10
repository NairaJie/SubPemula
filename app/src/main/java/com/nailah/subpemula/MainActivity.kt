package com.nailah.subpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.nailah.subpemula.adapter.HeliAdapter
import com.nailah.subpemula.data.Heli
import com.nailah.subpemula.data.Helidata
import com.nailah.subpemula.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private var list: ArrayList<Heli> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        rvMain.setHasFixedSize(true)
        list.addAll(Helidata.listHeli)
        addRecyclerViewList()
    }

    private fun addRecyclerViewList() {
        val heliAdapter = HeliAdapter(list)
        mainBinding.rvMain.layoutManager = LinearLayoutManager (this)
        mainBinding.rvMain.adapter = heliAdapter

        heliAdapter.setOnClickCallback(object : HeliAdapter.OnItemClickCallBack{
            override fun onItemClicked(heli: Heli) {
                setSelectedUsers(heli)
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_profile -> {
                intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setSelectedUsers(heli: Heli) {
        val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
        intentDetail.putExtra(DetailActivity.EXTRA_USER, heli)
        startActivity(intentDetail)
    }

}