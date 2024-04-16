package com.example.finallayout.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.finallayout.Activity.LoginActivity;
import com.example.finallayout.R;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    Button btnInfor, btnNoti, btnSchedule, btnLogout;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        btnInfor = view.findViewById(R.id.profile_btn_infor);
        btnNoti = view.findViewById(R.id.profile_btn_noti);
        btnSchedule = view.findViewById(R.id.profile_btn_schedule);
        btnLogout = view.findViewById(R.id.profile_btn_logout);

        addEvents();
    }

    private void addEvents() {
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ScheduleFragment();
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, fragment).commit();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Bạn đã đăng xuất", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}