package com.example.penugasanacara6;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new RegisterFragment(); // Fragment untuk Register
            case 1:
                return new LoginFragment(); // Fragment untuk Login
            default:
                return new RegisterFragment(); // Default RegisterFragment
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Jumlah tab: Register dan Login
    }
}
