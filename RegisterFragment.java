package com.example.penugasanacara6; // Ganti sesuai dengan package Anda

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class RegisterFragment extends Fragment {

    private EditText edtUsername, edtEmail, edtPhone, edtPassword;
    private Button btnRegister;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Inisialisasi komponen
        edtUsername = view.findViewById(R.id.edtUsername);
        edtEmail = view.findViewById(R.id.edtEmail);
        edtPhone = view.findViewById(R.id.edtPhone);
        edtPassword = view.findViewById(R.id.edtPassword);
        btnRegister = view.findViewById(R.id.btnRegister);

        mainActivity = (MainActivity) getActivity();

        // Logika ketika tombol Register ditekan
        btnRegister.setOnClickListener(v -> {
            String username = edtUsername.getText().toString();
            String email = edtEmail.getText().toString();
            String phone = edtPhone.getText().toString();
            String password = edtPassword.getText().toString();

            if (!username.isEmpty() && !password.isEmpty()) {
                mainActivity.registerUser(username, email, phone, password);
                Toast.makeText(getContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
