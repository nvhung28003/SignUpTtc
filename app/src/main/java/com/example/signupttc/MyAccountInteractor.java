package com.example.signupttc;

import android.content.Context;

public class MyAccountInteractor {
    public Context mContext;
    public AccountDataBase mAccountDataBase;

    public MyAccountInteractor(Context context) {
        mContext = context;
    }

    public boolean checkAccount(String nameAccount) {

        mAccountDataBase = new AccountDataBase(mContext);


        return mAccountDataBase.checkAccount(nameAccount);
    }

    public void addAccount(MyAccount myAccount) {

        mAccountDataBase = new AccountDataBase(mContext);


        mAccountDataBase.addAccount(myAccount);
    }

}
