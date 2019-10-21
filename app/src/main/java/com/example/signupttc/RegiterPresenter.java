package com.example.signupttc;

import android.accounts.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegiterPresenter implements RegiterContract.Presenter {

    private RegiterContract.View mView;

    public void setView(RegiterContract.View view) {
        mView = view;
    }


    @Override
    public void HandleSingUp(MyAccount myAccount, List<MyAccount> accountList) {
        boolean mCheckAccount = false;
        if(myAccount.getNameAccount().isEmpty() || myAccount.getPassWord().isEmpty()){
            mView.singUpEmpty("Password or Name Account is empty");
            return;
        }
        for (MyAccount myAccountInList : accountList) {
            if (myAccount.getNameAccount().equals(myAccountInList.getNameAccount()) == true) {
                mCheckAccount =true;
            }
        }
        if(mCheckAccount ==false)
        {
            mView.signUpSuccess(myAccount);
            return;
        }


        mView.singUpFailure("Account already exists");
    }
}
