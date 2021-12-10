package com.nailah.subpemula

import android.content.Intent.EXTRA_USER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.nailah.subpemula.data.Heli
import com.nailah.subpemula.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var heli: Heli

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        heli = intent.getParcelableExtra<Heli>(EXTRA_USER) as Heli

        showDetail()
    }

    private fun showDetail() {
        detailBinding.apply {
            Glide.with(this.root).load(heli.image).circleCrop().into(ivHeliDetail)
            tvNameDetail.text = heli.name
            tvPriceDetail.text = heli.price
            tvDescDetail.text = heli.desc
        }
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}