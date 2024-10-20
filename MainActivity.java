package com.example.penugasanacara6;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi ViewPager dan TabLayout
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        // Set Adapter untuk ViewPager
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);

        // Hubungkan TabLayout dengan ViewPager
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Register");
                    break;
                case 1:
                    tab.setText("Login");
                    break;
            }
        }).attach();

        // Inisialisasi SharedPreferences untuk menyimpan data registrasi
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
    }

    // Fungsi untuk menyimpan data registrasi
    public void registerUser(String username, String email, String phone, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    // Fungsi untuk melakukan login
    public boolean loginUser(String username, String password) {
        String storedUsername = sharedPreferences.getString("username", null);
        String storedPassword = sharedPreferences.getString("password", null);

        return username != null && username.equals(storedUsername) && password.equals(storedPassword);
    }
}