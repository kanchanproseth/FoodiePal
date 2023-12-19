package com.cs473.mda.foodiepal.dashboard.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import coil.transform.CircleCropTransformation
import com.cs473.mda.foodiepal.R
import com.cs473.mda.foodiepal.dashboard.dialog.EditAboutMeDialog
import com.cs473.mda.foodiepal.dashboard.dialog.EditAboutMeInterface
import com.cs473.mda.foodiepal.databinding.FragmentAboutMeBinding


class AboutMeFragment : Fragment(R.layout.fragment_about_me), FragmentPropertyInterface, EditAboutMeInterface {
    override val title: String = "About me"

    private var _binding: FragmentAboutMeBinding? = null
    private val binding get() = _binding!!
    private var profile: Profile? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profile = Profile("https://avatars.githubusercontent.com/u/10096187?v=4", getString(R.string.skill_default_text), getString(R.string.profile_description_default))
        bind(binding)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutMeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun bind(views: FragmentAboutMeBinding) {

        views.profileEditButton.setOnClickListener {
            configureDialog()
        }
        views.profile.load(profile?.profile_url) {
            crossfade(true)
            placeholder(R.drawable.baseline_account_circle_24)
            transformations(CircleCropTransformation())
        }
        views.skillTextView.text = profile?.skills
        views.profileDescription.text = profile?.description
    }

    private fun configureDialog() {
        val dialog = EditAboutMeDialog(this.profile!!)
        dialog.delegate = this
        dialog.show(childFragmentManager, EditAboutMeDialog.TAG)
    }

    override fun save(profile: Profile) {
        this.profile = profile
    }

    data class Profile(val profile_url: String, val skills: String, val description: String) {}
}