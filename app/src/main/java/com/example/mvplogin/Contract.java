package com.example.mvplogin;

import com.example.mvplogin.Model.Callback;

public class Contract {

    //View
    interface View {
        void onUsernameError(String msg);

        void onPasswordError(String msg);

        void showLoading();

        void hideLoading();

        void LoginSuccess();

        void LoginError();
    }

    //mediator or presenter
    interface Presenter {

        void loginButtonClicked(String userId, String password);
    }

    //for data
    interface Model {

          void doLogin(String id, String password, Callback callback);
    }
}
