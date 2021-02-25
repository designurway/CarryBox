package com.desigurway.carraybox.ui.auth.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.desigurway.carraybox.Json.BaseClient;
import com.desigurway.carraybox.Json.CarryBoxApi;
import com.desigurway.carraybox.Json.auth.SaveMobileData;
import com.desigurway.carrybox.R;
import com.desigurway.carrybox.databinding.FragmentLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {

    FragmentLoginBinding loginBinding;
    NavController navController;
    String loginId;
    NavDirections action;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false);

        loginBinding = FragmentLoginBinding.inflate(inflater,container,false);
        View view = loginBinding.getRoot();



        NavHostFragment navHostFragment =
                (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.auth_nav_host_fragment);
        navController = navHostFragment.getNavController();

        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginBinding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginId = loginBinding.emailMobileEditText.getText().toString();

                if (loginId.matches("[0-9]+")){
                    saveUserNumber();

                }else {
                    action = LoginFragmentDirections.actionLoginFragmentToEmailVerificationFragment();
                    Navigation.findNavController(view).navigate(action);
                }

            }
        });

        loginBinding.fogrotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        loginBinding.signUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = LoginFragmentDirections.actionLoginFragmentToSignUpFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }

    private void saveUserNumber() {

        CarryBoxApi carryBoxApi = BaseClient.getBaseClient().create(CarryBoxApi.class);
        Call<SaveMobileData> call = carryBoxApi.saveUserMobile(loginId);
        call.enqueue(new Callback<SaveMobileData>() {
            @Override
            public void onResponse(Call<SaveMobileData> call, Response<SaveMobileData> response) {
                if (response.isSuccessful()){

                    SaveMobileData mobileData = response.body();
                    if (mobileData.getStatus().equals("1")){
                        Toast.makeText(getActivity(), mobileData.getMessage(), Toast.LENGTH_SHORT).show();
                        action = LoginFragmentDirections.actionLoginFragmentToOtpVerificationFragment();
                        Navigation.findNavController(getView()
                        ).navigate(action);
                    }else {
                        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
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