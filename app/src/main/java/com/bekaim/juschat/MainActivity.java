package com.bekaim.juschat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.bekaim.juschat.fragments.CallsFragment;
import com.bekaim.juschat.fragments.ChatFragment;
import com.bekaim.juschat.fragments.StatusFragment;
import com.bekaim.juschat.utils.SetupPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        setupViewPager(mViewPager);

    }


    private void setupViewPager(ViewPager viewPager) {
        SetupPagerAdapter adapter = new SetupPagerAdapter(getSupportFragmentManager());
        // add Fragments to ViewPager
        adapter.addFragment(new CallsFragment());
        adapter.addFragment(new ChatFragment());
        adapter.addFragment(new StatusFragment());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("CHATS");
        tabLayout.getTabAt(1).setText("STATUS");
        tabLayout.getTabAt(2).setText("CALLS");
    }
}
