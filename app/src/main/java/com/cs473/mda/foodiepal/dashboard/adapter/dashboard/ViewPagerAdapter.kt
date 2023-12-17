package com.cs473.mda.foodiepal.dashboard.adapter.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, val items: ArrayList<Fragment>) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        return items.count()
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }

    public fun addfragment(view: Fragment) {
        items.add(view)
    }

    public fun removeItem(position: Int) {
        items.removeAt(position)
    }
}