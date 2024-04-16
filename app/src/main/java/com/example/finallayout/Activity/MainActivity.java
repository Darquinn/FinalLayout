package com.example.finallayout.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.finallayout.Class.MyClass;
import com.example.finallayout.Fragment.ScheduleFragment;
import com.example.finallayout.Fragment.HomeFragment;
import com.example.finallayout.Fragment.ProfileFragment;
import com.example.finallayout.R;
import com.example.finallayout.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BottomNavigationView bottom_nav;

    List<MyClass> classItem;

    FloatingActionButton fab;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment();
        setOnClickRecycleView();
    }

    private void setOnClickRecycleView() {
        RecyclerView homeRecycleView = findViewById(R.id.homeRecycleView);
    }

    private void setFragment(){
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNav.setBackground(null);

        binding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.nav_schedule:
                    replaceFragment(new ScheduleFragment());
                    break;
                case R.id.nav_profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


}