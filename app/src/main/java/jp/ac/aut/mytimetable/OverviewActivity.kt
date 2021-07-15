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
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private const val NUM_PAGES = 3

class overview_activity : FragmentActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.overview_tab)
        val pagerAdapter = OverviewPagerAdapter(this)
        viewPager.adapter = pagerAdapter
        val madiator = TabLayoutMediator(tabLayout,viewPager){
            tab:TabLayout.Tab,
            position: Int ->
            when(position){
                0 -> tab.text = "Search"
                else -> tab.text = "MyRoute"
            }
        }
        madiator.attach()

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
        override fun getItemCount(): Int = 2
        override fun createFragment(position: Int): Fragment{
            return when(position) {
                0 -> searchFragment()
                else -> myrouteFragment()
            }
        }
    }

}