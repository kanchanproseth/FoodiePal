package com.cs473.mda.foodiepal.dashboard.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs473.mda.foodiepal.R
import com.cs473.mda.foodiepal.dashboard.adapter.blog.Blog
import com.cs473.mda.foodiepal.dashboard.adapter.blog.BlogRecyclerViewAdapter
import com.cs473.mda.foodiepal.dashboard.adapter.recipe.Recipe
import com.cs473.mda.foodiepal.dashboard.adapter.recipe.RecipeRecyclerViewAdapter
import com.cs473.mda.foodiepal.dashboard.dialog.AddRecipeDialog
import com.cs473.mda.foodiepal.databinding.FragmentBlogBinding
import com.cs473.mda.foodiepal.databinding.FragmentRecipeBinding

class BlogFragment : Fragment(R.layout.fragment_blog), FragmentPropertyInterface {
    override val title: String = "Blog"

    private var _binding: FragmentBlogBinding? = null
    private val binding get() = _binding!!

    // RecyclerView
    private val adapter = BlogRecyclerViewAdapter(arrayListOf())

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
        adapter.add(mockRecipe())
        adapter.add(mockRecipe())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        val addButton = binding.blogAddButton
        addButton.setOnClickListener {
            configureDialog()
        }
//        adapter.notifyDataSetChanged()
    }

    private fun configureDialog() {
//        val dialog = AddRecipeDialog()
//        dialog.delegate = this
//        dialog.show(childFragmentManager, AddRecipeDialog.TAG)
    }

//    override fun add(recipe: Recipe) {
//        adapter.add(recipe)
//        adapter.notifyDataSetChanged()
//    }

    private fun mockRecipe(): Blog {
        val ingredients = "3 tablespoons unsalted butter, plus more for greasing the baking dish\n" + "\n" + "1 medium onion, finely chopped\n" + "\n" + "1 teaspoon fresh thyme leaves\n" + "\n" + "Kosher salt and freshly ground black pepper\n" + "\n" + "Two 16-ounce bags frozen corn, thawed\n" + "\n" + "1 1/2 cups heavy cream\n" + "\n" + "1/2 pound thick-sliced deli ham, diced\n" + "\n" + "5 ounces frozen kale (about 1 3/4 cups)\n"
        val instructions = "Preheat the oven to 350 degrees F. Butter a 2-quart oval baking dish.For the creamed corn: Melt the butter in a large skillet over medium heat. Add the onions, thyme, 1/2 teaspoon salt and a few grinds of pepper, and cook, stirring frequently, until the onions are soft and translucent, about 10 minutes. Add the corn and cream, and bring to a simmer, stirring occasionally, until the mixture reduces in volume and bubbles rapidly, about 15 minutes. Transfer 2 cups of the corn mixture to a food processor, puree until smooth, then stir it back into the skillet. Fold in the ham and kale. Transfer the creamed corn to the prepared baking dish; set aside. Clean the food processor bowl. For the cornbread topping: Pulse the cornmeal, flour, baking powder, sugar and 1/2 teaspoon each salt and pepper in a food processor to combine. Add the butter, and pulse until the mixture resembles coarse breadcrumbs. Add the cream and 1/2 cup of the Cheddar, and pulse until the batter just comes together.To assemble: Sprinkle the cornmeal batter over the creamed corn. (Don't worry if the corn isn't completely covered; the batter will puff and spread as it bakes.) Sprinkle with the remaining 1/2 cup Cheddar. Place the casserole on a baking sheet, and bake until the corn is bubbling and the crust is puffed and golden brown, about 35 minutes. Let cool for 15 minutes. Serve with hot sauce."
        return Blog("Our Best Breakfast Casseroles", ingredients, instructions);
    }
}