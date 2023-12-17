package com.cs473.mda.foodiepal.dashboard.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.cs473.mda.foodiepal.R
import com.cs473.mda.foodiepal.databinding.RecipeAddDialogBinding
import com.cs473.mda.foodiepal.dashboard.adapter.recipe.Recipe


class AddRecipeDialog(): DialogFragment(R.layout.recipe_add_dialog) {

    var delegate: AddRecipeInterface? = null

    private var _binding: RecipeAddDialogBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    val binding get() = _binding!!

    override fun getTheme() = R.style.RoundedCornersDialog

    companion object {
        const val TAG = "AddRecipeDialog"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RecipeAddDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = RecipeAddDialogBinding.inflate(LayoutInflater.from(context))

        val dialog = activity?.let {
            Dialog(it)
        }

        if(dialog != null) {
            dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setContentView(binding.root)
        }
        return dialog!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addButton: Button? = view.findViewById<Button>(R.id.add_recipe_dialog_button)
        binding.addRecipeDialogButton.setOnClickListener {
            val title = binding.recipeTitleEdt.text.toString()
            val ingredients = binding.ingredientsEdt.text.toString()
            val instructions = binding.instructionsEdt.text.toString()

            if (title.isEmpty() ||ingredients.isEmpty() || instructions.isEmpty()) {
                Toast.makeText(context, "Please input ingredients and instructions to add the recipe", Toast.LENGTH_LONG).show()
            } else {
                delegate?.add(Recipe(title, ingredients, instructions))
                this.dismiss()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}