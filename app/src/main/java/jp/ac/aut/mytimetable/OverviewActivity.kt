package jp.ac.aut.mytimetable

import android.accessibilityservice.AccessibilityService
import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TabHost
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

private const val NUM_PAGES = 3

class overview_activity : FragmentActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        viewPager = findViewById(R.id.viewPager)
        val pagerAdapter = OverviewPagerAdapter(this)
        viewPager.adapter = pagerAdapter
    }

    override fun onBackPressed(){

        if(viewPager.currentItem == 0){
            super.onBackPressed()
        }
        else {
             viewPager.currentItem = viewPager.currentItem-1
        }

    }

    private inner class OverviewPagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa){
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment = searchFragment()
    }

}