package com.cs473.mda.foodiepal.dashboard.pages

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs473.mda.foodiepal.BlogDetailsActivity
import com.cs473.mda.foodiepal.R
import com.cs473.mda.foodiepal.dashboard.adapter.blog.Blog
import com.cs473.mda.foodiepal.dashboard.adapter.blog.BlogItemOnClick
import com.cs473.mda.foodiepal.dashboard.adapter.blog.BlogRecyclerViewAdapter
import com.cs473.mda.foodiepal.dashboard.adapter.recipe.Recipe
import com.cs473.mda.foodiepal.dashboard.adapter.recipe.RecipeRecyclerViewAdapter
import com.cs473.mda.foodiepal.dashboard.dialog.AddBlogDialog
import com.cs473.mda.foodiepal.dashboard.dialog.AddBlogInterface
import com.cs473.mda.foodiepal.dashboard.dialog.AddRecipeDialog
import com.cs473.mda.foodiepal.databinding.FragmentBlogBinding
import com.cs473.mda.foodiepal.databinding.FragmentRecipeBinding

class BlogFragment : Fragment(R.layout.fragment_blog), FragmentPropertyInterface, BlogItemOnClick, AddBlogInterface {
    override val title: String = "Blog"

    private var _binding: FragmentBlogBinding? = null
    private val binding get() = _binding!!

    // RecyclerView
    private val adapter = BlogRecyclerViewAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding()
    }

    private fun viewBinding() {
        val recyclerView = binding.blogRecyclerView
        adapter.add(mockBlog())
        adapter.add(mockBlog())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        val addButton = binding.blogAddButton
        addButton.setOnClickListener {
            configureDialog()
        }
//        adapter.notifyDataSetChanged()
    }

    private fun configureDialog() {
        val dialog = AddBlogDialog()
        dialog.delegate = this
        dialog.show(childFragmentManager, AddBlogDialog.TAG)
    }

    override fun add(blog: Blog) {
        adapter.add(blog)
        adapter.notifyDataSetChanged()
    }

    override fun itemOnClick(blog: Blog) {
        val intent = Intent(this.context, BlogDetailsActivity::class.java)
        intent.putExtra("title", blog.title)
        intent.putExtra("imageUrl", blog.urlString)
        intent.putExtra("content", blog.content)
        startActivity(intent)
    }

    private fun mockBlog(): Blog {
        return Blog("Our Best Breakfast Casseroles", "i am a food blog is an award winning food blog that’s been around since 2010 featuring hundreds of easy, fun, and delicious modern Asian- and globally-inspired recipes that celebrate the joy of home cooking. Our tips and tricks will have you cooking like a pro in no time. Pull up a chair and stick around for awhile, let’s be friends and eat together!\n" +
                "\n" +
                "-Steph and Mike", "https://img.freepik.com/free-photo/chicken-wings-barbecue-sweetly-sour-sauce-picnic-summer-menu-tasty-food-top-view-flat-lay_2829-6471.jpg");
    }
}