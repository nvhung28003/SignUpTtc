package com.example.signupttc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RegiterContract.View, View.OnClickListener {
    private EditText mEditTextNameAccount, mEditTextPassWord, mEditTextEmail, mEditTextPhoneNumber;
    private Button mButtonSignUp;
    private RegiterPresenter mRegiterPresenter;
    private AccountDataBase mAccountDataBase;
    private List<MyAccount> myAccountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        regiterListerner();
        initPresenter();

        mAccountDataBase = new AccountDataBase(this);

    }

    private void initView() {
        mEditTextNameAccount = findViewById(R.id.edtNameAccount);
        mEditTextPassWord = findViewById(R.id.edtPassword);
        mEditTextEmail = findViewById(R.id.edtEmail);
        mEditTextPhoneNumber = findViewById(R.id.edtPhoneNumber);
        mButtonSignUp = findViewById(R.id.btnSignUp);

    }

    private void regiterListerner() {
        mButtonSignUp.setOnClickListener(this);
    }

    private void initPresenter() {
        mRegiterPresenter = new RegiterPresenter();
        mRegiterPresenter.setView(this);
    }

    private void regiterAccount() {
        String nameAccount = mEditTextNameAccount.getText().toString();
        String passWord = mEditTextPassWord.getText().toString();
        String phoneNumber = mEditTextPhoneNumber.getText().toString();
        String email = mEditTextEmail.getText().toString();

        MyAccount myAccount = new MyAccount(nameAccount,passWord,phoneNumber,email);
        myAccountList = mAccountDataBase.getAllAccount();

        mRegiterPresenter.HandleSingUp(myAccount,myAccountList);
    }

    @Override
    public void signUpSuccess(MyAccount myAccount) {
        mAccountDataBase.addAccount(myAccount);
        Toast.makeText(this, "Sign Up success", Toast.LENGTH_LONG).show();
        mEditTextNameAccount.setText("");
        mEditTextPassWord.setText("");
        mEditTextEmail.setText("");
        mEditTextPhoneNumber.setText("");

    }

    @Override
    public void singUpFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void singUpEmpty(String Mess) {
        Toast.makeText(this, Mess, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignUp:
                regiterAccount();
                break;
        }
    }
}
