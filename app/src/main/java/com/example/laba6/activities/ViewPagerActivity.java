package com.example.laba6.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.laba6.DBHelper;
import com.example.laba6.Model;
import com.example.laba6.R;

import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Model> items;
    private String name;
    DBHelper db;


    //Находими ViewPager по Id и настраиваем адаптер для ViewPager
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_fragment);

        viewPager = findViewById(R.id.activity_item_view_pager);

        items = Singleton.getInstance().getItems();

        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                Model civ = items.get(position);
                //Создает новый фрагмент, в который передает имя из объекта Civilization
                return ViewPagerFragment.newInstance(civ.getId());
            }

            @Override
            public int getCount() {
                return items.size();
            }
        });

        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getName().equals(name))
            {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
