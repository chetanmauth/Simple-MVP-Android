package com.example.mvplogin;

public class Presenter implements Contract.Presenter, Model.Callback {

    private final Contract.View view;
    private final Contract.Model model;

    public Presenter(Contract.View view, Contract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void loginButtonClicked(String userId, String password) {
        if (userId.length() == 0) {
            view.onUsernameError("User id is Empty");
        } else if (password.length() == 0) {
            view.onPasswordError("Password is Empty");
        } else {
            view.showLoading();
            model.doLogin(userId, password, this);
        }
    }

    @Override
    public void onLoginSuccess(String response) {
        view.hideLoading();
        view.LoginSuccess();
    }

    @Override
    public void onLoginError(String error) {
        view.hideLoading();
        view.LoginError();
    }
}
