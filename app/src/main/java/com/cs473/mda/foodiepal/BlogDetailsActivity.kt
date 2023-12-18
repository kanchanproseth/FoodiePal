package com.cs473.mda.foodiepal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import coil.load
import com.cs473.mda.foodiepal.databinding.ActivityBlogDetailsBinding

class BlogDetailsActivity : AppCompatActivity() {

    private var binding: ActivityBlogDetailsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogDetailsBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding(binding!!)
    }

    private fun binding(views: ActivityBlogDetailsBinding) {
        views.backButton.setOnClickListener {
            this.finish()
        }
        val intent = intent
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val imageUrl = intent.getStringExtra("imageUrl")
        views.blogDetailsTitle.text = title
        views.blogDetailsContentText.text = content
        views.blogDetailsImageView.load(imageUrl)
    }
}