package com.example.mvplogin;

import android.os.Handler;

public class Model implements Contract.Model {

    @Override
    public void doLogin(String id, String password, Callback callback) {

        //delay like network call
        new Handler().postDelayed(new Runnable() {
            public void run() {
                //response
                if (id.equals("123") && password.equals("abc")) {
                    callback.onLoginSuccess("Login Success");
                } else {
                    callback.onLoginError("Password Wrong");
                }
            }
        }, 2500);
    }

    //callback after response
    public interface Callback {

        void onLoginSuccess(String response);

        void onLoginError(String error);
    }
}
