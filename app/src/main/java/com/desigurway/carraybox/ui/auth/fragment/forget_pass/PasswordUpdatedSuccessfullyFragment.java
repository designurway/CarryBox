package com.desigurway.carraybox.ui.auth.fragment.forget_pass;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desigurway.carrybox.databinding.FragmentPasswordUpdatedSuccessfullyBinding;


public class PasswordUpdatedSuccessfullyFragment extends Fragment {

    FragmentPasswordUpdatedSuccessfullyBinding binding;
    NavDirections action;

    public PasswordUpdatedSuccessfullyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_password_updated_successfully, container, false);
        binding = FragmentPasswordUpdatedSuccessfullyBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.upPassLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = PasswordUpdatedSuccessfullyFragmentDirections.actionPasswordUpdatedSuccessfullyFragmentToLoginFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
}