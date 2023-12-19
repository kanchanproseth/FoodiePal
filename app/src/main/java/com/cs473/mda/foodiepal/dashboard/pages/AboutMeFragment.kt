package com.cs473.mda.foodiepal.dashboard.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cs473.mda.foodiepal.R
import com.cs473.mda.foodiepal.databinding.FragmentAboutMeBinding
import com.cs473.mda.foodiepal.databinding.FragmentBlogBinding


class AboutMeFragment : Fragment(R.layout.fragment_about_me), FragmentPropertyInterface {
    override val title: String = "About me"

    private var _binding: FragmentAboutMeBinding? = null
    private val binding = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutMeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    private fun bind(views: FragmentAboutMeBinding) {
        views.profileEditButton.setOnClickListener {

        }
    }

    private fun mockProfile(): Profile {
        return Profile("https://avatars.githubusercontent.com/u/10096187?v=4", getString(R.string.skill_default_text), getString(R.string.profile_description_default))
    }

    data class Profile(val profile_url: String, val skill: String, val description: String) {}
}