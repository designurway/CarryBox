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


import com.desigurway.carrybox.databinding.FragmentMakeSelectionBinding;


public class MakeSelectionFragment extends Fragment {

    FragmentMakeSelectionBinding selectionBinding;
    NavDirections action;

    public MakeSelectionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_make_selection, container, false);

        selectionBinding = FragmentMakeSelectionBinding.inflate(inflater,container,false);
        View view = selectionBinding.getRoot();
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        selectionBinding.selectEmailLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = MakeSelectionFragmentDirections.actionMakeSelectionFragmentToNewCredentialFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        selectionBinding.selectMobileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = MakeSelectionFragmentDirections.actionMakeSelectionFragmentToNewCredentialFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
}