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

import com.desigurway.carrybox.databinding.FragmentForgotPasswordBinding;


public class ForgotPasswordFragment extends Fragment {

    FragmentForgotPasswordBinding forgotPasswordBinding;
    NavDirections action;

    public ForgotPasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_forgot_password, container, false);

        forgotPasswordBinding = FragmentForgotPasswordBinding.inflate(inflater,container,false);
        View view = forgotPasswordBinding.getRoot();
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        forgotPasswordBinding.fogNxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToMakeSelectionFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
}