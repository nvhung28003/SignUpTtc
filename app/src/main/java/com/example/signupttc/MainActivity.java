package com.example.signupttc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RegiterContract.View, View.OnClickListener {
    private EditText mEditTextNameAccount, mEditTextPassWord, mEditTextEmail, mEditTextPhoneNumber;
    private Button mButtonSignUp;
    private RegiterPresenter mRegiterPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        regiterListerner();
        initPresenter();

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
        mRegiterPresenter = new RegiterPresenter(this);
        mRegiterPresenter.setView(this);
    }

    private void regiterAccount() {

        String nameAccount = mEditTextNameAccount.getText().toString();
        String passWord = mEditTextPassWord.getText().toString();
        String phoneNumber = mEditTextPhoneNumber.getText().toString();
        String email = mEditTextEmail.getText().toString();
        MyAccount myAccount = new MyAccount(nameAccount, passWord, phoneNumber, email);
        mRegiterPresenter.handleSingUp(myAccount);
    }

    @Override
    public void signUpSuccess(String mess) {

        Toast.makeText(this, mess, Toast.LENGTH_LONG).show();
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
    public void singUpEmpty(String mess) {
        Toast.makeText(this, mess, Toast.LENGTH_LONG).show();
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
