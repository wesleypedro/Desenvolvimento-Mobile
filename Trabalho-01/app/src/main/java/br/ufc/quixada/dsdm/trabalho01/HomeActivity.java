package br.ufc.quixada.dsdm.trabalho01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<String> strs;

    private TabLayout tab;
    private TabItem tab1;
    private TabItem tab2;
    private TabItem tab3;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        strs = new ArrayList<>();

        tab = findViewById(R.id.tab);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);
        viewPager = findViewById(R.id.viewPage);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),
                tab.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
