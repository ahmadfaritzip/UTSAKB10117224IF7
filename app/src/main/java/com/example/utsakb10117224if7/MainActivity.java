package com.example.utsakb10117224if7;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.utsakb10117224if7.utils.ZoomOutPageTransformer;
import com.example.utsakb10117224if7.ui.kontak.KontakFragment;
import com.example.utsakb10117224if7.ui.daftar.DaftarFragment;
import com.example.utsakb10117224if7.utils.MainActivityAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
//    Tanggal Pengerjaan : 12 Mei 2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7

    LinearLayout layout_tab;
    FrameLayout layout_frame;
    ViewPager viewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    layout_tab.setVisibility(View.VISIBLE);
                    layout_frame.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_dashboard:
                    layout_tab.setVisibility(View.GONE);
                    layout_frame.setVisibility(View.VISIBLE);
                    load_fragment_bottom(new KontakFragment());
                    return true;
                case R.id.navigation_notifications:
                    layout_tab.setVisibility(View.GONE);
                    layout_frame.setVisibility(View.VISIBLE);
                    load_fragment_bottom(new DaftarFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        layout_tab = findViewById(R.id.layout_tab);
        layout_frame = findViewById(R.id.layout_frame);
        MainActivityAdapter mainActivityAdapter = new MainActivityAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewpager);

        viewPager.setAdapter(mainActivityAdapter);
        ZoomOutPageTransformer zoomOutPageTransformer = new ZoomOutPageTransformer();
        viewPager.setPageTransformer(true, zoomOutPageTransformer);
    }

    Boolean load_fragment_bottom(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_frame, fragment).commit();
            return true;
        }
        return false;
    }
}


