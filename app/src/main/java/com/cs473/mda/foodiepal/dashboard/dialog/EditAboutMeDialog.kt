package com.cs473.mda.foodiepal.dashboard.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.cs473.mda.foodiepal.R
import com.cs473.mda.foodiepal.dashboard.adapter.blog.Blog
import com.cs473.mda.foodiepal.dashboard.pages.AboutMeFragment
import com.cs473.mda.foodiepal.databinding.BlogAddDialogBinding
import com.cs473.mda.foodiepal.databinding.EditAboutMeDialogBinding

class EditAboutMeDialog(model: AboutMeFragment.Profile): DialogFragment(R.layout.blog_add_dialog) {
    var delegate: EditAboutMeInterface? = null

    private val _model = model

    private var _binding: EditAboutMeDialogBinding? = null

    private val binding get() = _binding!!

    override fun getTheme() = R.style.RoundedCornersDialog

    companion object {
        const val TAG = "EditAboutMeDialog"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EditAboutMeDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = EditAboutMeDialogBinding.inflate(LayoutInflater.from(context))

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
        binding.aboutMeSaveButton.setOnClickListener {
            val profileImageUrl = binding.profileImageUrlEdt.text.toString()
            val profileSkillText = binding.profileSkilEdt.text.toString()
            val profileDescription = binding.profileDescriptionEdt.text.toString()

            if (profileImageUrl.isEmpty() ||profileSkillText.isEmpty() || profileDescription.isEmpty()) {
                Toast.makeText(context, "Please input all field to update profile", Toast.LENGTH_LONG).show()
            } else {
                delegate?.save(AboutMeFragment.Profile(profileImageUrl, profileSkillText, profileDescription))
                this.dismiss()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}