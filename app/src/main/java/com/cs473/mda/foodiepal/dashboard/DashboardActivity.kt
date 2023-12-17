package com.cs473.mda.foodiepal.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cs473.mda.foodiepal.R
import com.cs473.mda.foodiepal.dashboard.adapter.dashboard.ViewPagerAdapter
import com.cs473.mda.foodiepal.dashboard.pages.AboutMeFragment
import com.cs473.mda.foodiepal.dashboard.pages.BlogFragment
import com.cs473.mda.foodiepal.dashboard.pages.ContactMeFragment
import com.cs473.mda.foodiepal.dashboard.pages.FragmentPropertyInterface
import com.cs473.mda.foodiepal.dashboard.pages.MealPlannerFragment
import com.cs473.mda.foodiepal.dashboard.pages.RecipeFragment
import com.cs473.mda.foodiepal.databinding.ActivityDashboardBinding
import com.google.android.material.tabs.TabLayoutMediator

class DashboardActivity : AppCompatActivity() {
    private val fragments: ArrayList<Fragment> = arrayListOf(
        RecipeFragment(),
        MealPlannerFragment(),
        BlogFragment(),
        ContactMeFragment(),
        AboutMeFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        binding(viewBinding)
    }

    private fun binding(views: ActivityDashboardBinding) {
        val viewPager = views.viewPager
        val tabLayout = views.tabLayout
        val bottomNavigationView = views.bottomNavigationView
        viewPager.adapter = configureAdapter(fragments)

        TabLayoutMediator(views.tabLayout, viewPager) { tab, position ->
            tab.text = (fragments[position] as FragmentPropertyInterface).title
        }.attach()



        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.title) {
                getString(R.string.recipe) -> viewPager.currentItem = 0
                getString(R.string.meal_planer) -> viewPager.currentItem = 1
                getString(R.string.blog) -> viewPager.currentItem = 2
            }
            true
        }
    }

    private fun configureAdapter(items: ArrayList<Fragment>): ViewPagerAdapter {
        return ViewPagerAdapter(supportFragmentManager, this.lifecycle, items)
    }


}