package com.example.mvplogin;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mvplogin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private ActivityMainBinding binding;
    private Presenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Model model = new Model();
        presenter = new Presenter(this, model);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        binding.signInBtn.setOnClickListener(view -> presenter.loginButtonClicked(
                binding.userIdText.getText().toString().trim(),
                binding.passwordText.getText().toString().trim()
        ));
    }

    @Override
    public void onUsernameError(String msg) {
        binding.userIdText.setError(msg);
    }

    @Override
    public void onPasswordError(String msg) {
        binding.passwordText.setError(msg);
    }

    @Override
    public void showLoading() {
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null) {
            progressDialog.hide();
        }
    }

    @Override
    public void LoginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        //Intent
    }

    @Override
    public void LoginError() {
        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
    }
}