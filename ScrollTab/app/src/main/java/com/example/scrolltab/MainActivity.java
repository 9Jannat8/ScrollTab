package com.example.scrolltab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pagerId);

        //android.app.FragmentManager fragmentManager = getSupportFragmentManager();
       FragmentManager fragmentManager = getSupportFragmentManager();

        CustomAdapter adapter = new CustomAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
    }
}

class CustomAdapter extends FragmentPagerAdapter {

    public CustomAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        if (position == 0){

            fragment = new Fragment1();

        } else if (position == 1){

            fragment = new Fragment2();

        }else if (position == 2){

            fragment = new Fragment3();

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if(position == 0)
        {
            return "Tab1";
        }
        else if(position == 1)
        {
            return "Tab2";
        }
        else if(position == 2)
        {
            return "Tab3";
        }

        return null;
    }
}