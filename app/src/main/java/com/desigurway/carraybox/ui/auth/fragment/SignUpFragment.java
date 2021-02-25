package com.desigurway.carraybox.ui.auth.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.desigurway.carraybox.Json.BaseClient;
import com.desigurway.carraybox.Json.CarryBoxApi;
import com.desigurway.carraybox.Json.auth.SaveMobileData;
import com.desigurway.carrybox.R;
import com.desigurway.carrybox.databinding.FragmentSignUpBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpFragment extends Fragment {

    FragmentSignUpBinding signUpBinding;
    String name,email,mobile,password;
    NavDirections action;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_sign_up, container, false);

        signUpBinding = FragmentSignUpBinding.inflate(inflater,container,false);
        View view = signUpBinding.getRoot();
        return  view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        signUpBinding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserNumber();
            }
        });

    }

    private void saveUserNumber() {

        name = signUpBinding.signUpName.getText().toString().trim();
        email = signUpBinding.signUpEmail.getText().toString().trim();
        mobile = signUpBinding.signUpMobile.getText().toString().trim();
        password = signUpBinding.signUpPassword.getText().toString().trim();

        CarryBoxApi carryBoxApi = BaseClient.getBaseClient().create(CarryBoxApi.class);
        Call<SaveMobileData> call = carryBoxApi.registerMobile(mobile);
        call.enqueue(new Callback<SaveMobileData>() {
            @Override
            public void onResponse(Call<SaveMobileData> call, Response<SaveMobileData> response) {
                if (response.isSuccessful()){

                    SaveMobileData mobileData = response.body();
                    if (mobileData.getStatus().equals("1")){
                        Toast.makeText(getActivity(), mobileData.getMessage(), Toast.LENGTH_SHORT).show();

                        action = SignUpFragmentDirections.actionSignUpFragmentToVerifyRegistrationFragment(
                                name,email,mobile,password
                        );
                        Navigation.findNavController(getView()

                        ).navigate(action);
                    }else {
                        Toast.makeText(getActivity(), "Failed : "+mobileData.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getActivity(), "Not Sucess", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SaveMobileData> call, Throwable t) {
                Toast.makeText(getActivity(), "On Failure"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}