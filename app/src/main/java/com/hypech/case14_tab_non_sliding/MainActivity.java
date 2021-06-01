package com.hypech.case14_tab_non_sliding;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout layoutFrame;
    TabLayout layoutTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 get the reference of FrameLayout and TabLayout
        layoutFrame= findViewById(R.id.layout_frame);
        layoutTab  = findViewById(R.id.layout_tab);

        // 2 Create tabs
        TabLayout.Tab tab1 = layoutTab.newTab();
        TabLayout.Tab tab2 = layoutTab.newTab();
        TabLayout.Tab tab3 = layoutTab.newTab();

        // 3 set each tab name
        tab1.setText("World");
        tab2.setText("Business");
        tab3.setText("Technology");

        // 4 set each tab icon
        tab1.setIcon(R.drawable.icon1);
        tab2.setIcon(R.drawable.icon2);
        tab3.setIcon(R.drawable.icon3);

        // 5 add  the tab at in the TabLayout
        layoutTab.addTab(tab1);
        layoutTab.addTab(tab2);
        layoutTab.addTab(tab3);

        // 6 perform addOnTabSelectedListener event on TabLayout
        layoutTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // get the current selected tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new BlankFragment1();
                        break;
                    case 1:
                        fragment = new BlankFragment2();
                        break;
                    case 2:
                        fragment = new BlankFragment3();
                        break;
                }
                FragmentManager     fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.layout_frame, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {            }
        });
    }
}
