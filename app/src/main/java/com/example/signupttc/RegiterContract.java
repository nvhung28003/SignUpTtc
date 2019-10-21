package com.example.signupttc;

import android.accounts.Account;

import java.util.List;

public class RegiterContract {
    interface View{
        void signUpSuccess(MyAccount myAccount);
        void singUpFailure(String error);
        void singUpEmpty(String Mess);
    }

    interface Presenter{
        void HandleSingUp(MyAccount myAccount, List<MyAccount> accountList);
    }
}
