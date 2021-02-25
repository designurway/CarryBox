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

import com.desigurway.carrybox.databinding.FragmentNewCredentialBinding;


public class NewCredentialFragment extends Fragment {

    FragmentNewCredentialBinding credentialBinding;
    NavDirections action;

    public NewCredentialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_new_credential, container, false);

        credentialBinding = FragmentNewCredentialBinding.inflate(inflater,container,false);
        View view = credentialBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        credentialBinding.updatePassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = NewCredentialFragmentDirections.actionNewCredentialFragmentToPasswordUpdatedSuccessfullyFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
}