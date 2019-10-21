package com.example.signupttc;

import android.accounts.Account;

import java.util.List;

public class RegiterContract {
    interface View{
        void signUpSuccess(String mess);
        void singUpFailure(String error);
        void singUpEmpty(String mess);
    }

    interface Presenter{
        void handleSingUp(MyAccount myAccount);
    }
}
