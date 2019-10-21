package com.example.signupttc;

import android.accounts.Account;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegiterPresenter implements RegiterContract.Presenter {
    private Context mContext;
    public MyAccountInteractor mMyAccountInteractor;

    public RegiterPresenter(Context context) {
        mContext = context;
    }


    private RegiterContract.View mView;

    public void setView(RegiterContract.View view) {
        mView = view;
    }


    @Override
    public void handleSingUp(MyAccount myAccount) {
        mMyAccountInteractor = new MyAccountInteractor(mContext);
        if (myAccount.getNameAccount().isEmpty() || myAccount.getPassWord().isEmpty()) {
            mView.singUpEmpty("Password or Name Account is empty");
            return;
        }
        if(mMyAccountInteractor.checkAccount(myAccount.getNameAccount())==false)
        {
            mMyAccountInteractor.addAccount(myAccount);
            mView.signUpSuccess("Sign Up success");
            return;
        }
        mView.singUpFailure("Account already exists");
    }
}
