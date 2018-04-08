package com.appendous.suntisttask.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


import com.appendous.suntisttask.R;
import com.appendous.suntisttask.adapter.RvAdapterPhoneBook;
import com.appendous.suntisttask.model.PhoneBookItem;
import com.appendous.suntisttask.presenter.PhoneBookPresenter;
import com.appendous.suntisttask.presenter.PhoneBookPresenterImpl;
import com.appendous.suntisttask.util.ButtonFuturaMdBt;
import com.appendous.suntisttask.util.EditTextFuturaMdBt;
import com.appendous.suntisttask.util.TextViewFuturaMdBt;
import com.appendous.suntisttask.view.PhoneBookView;

import java.util.List;

public class PhoneBookActivity extends AppCompatActivity implements View.OnClickListener,PhoneBookView {

    private TextViewFuturaMdBt mNameTV, mEmailTV;
    private EditTextFuturaMdBt mUserNameET,mUserTelET;
    private ButtonFuturaMdBt mMaleBtn, mFemaleBtn, mSubmitBtn;
    private RecyclerView mRecyclerViewPhoneBook;
    private PhoneBookPresenter phoneBookPresenter;
    private String sex ="";
    private List<PhoneBookItem> itemList;
    private RvAdapterPhoneBook rvAdapterPhoneBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phone_book);
        init();
        phoneBookPresenter = new PhoneBookPresenterImpl(this);
        phoneBookPresenter.editTextChanged(mUserNameET,mUserTelET,sex);
    }

    private void init(){
        findViewById(R.id.cl_userInfo).setVisibility(View.VISIBLE);
        findViewById(R.id.cl_header).setVisibility(View.GONE);
        mNameTV = findViewById(R.id.tv_name);
        mEmailTV = findViewById(R.id.tv_email);
        mNameTV.setText(getIntent().getStringExtra("name"));
        mEmailTV.setText(getIntent().getStringExtra("email"));
        mMaleBtn = findViewById(R.id.btn_male);
        mFemaleBtn = findViewById(R.id.btn_female);
        mSubmitBtn = findViewById(R.id.btn_submit);
        mUserNameET = findViewById(R.id.userNameET);
        mUserTelET = findViewById(R.id.userPhoET);
        mRecyclerViewPhoneBook = findViewById(R.id.rv_phonebook);
        mMaleBtn.setOnClickListener(this);
        mFemaleBtn.setOnClickListener(this);
        mSubmitBtn.setOnClickListener(this);

        mRecyclerViewPhoneBook.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvAdapterPhoneBook = new RvAdapterPhoneBook(this,itemList);

        mRecyclerViewPhoneBook.setAdapter(rvAdapterPhoneBook);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_male:
                sex = "Male";
                mMaleBtn.setBackground(getResources().getDrawable(R.drawable.button_shape_sex_pressed));
                mMaleBtn.setTextColor(getResources().getColor(R.color.colorWhite));

                mFemaleBtn.setBackground(getResources().getDrawable(R.drawable.button_sex_selector));
                mFemaleBtn.setTextColor(getResources().getColor(R.color.colorPlaceHolder));

                phoneBookPresenter.editTextChanged(mUserNameET,mUserTelET,sex);
                break;
            case R.id.btn_female:

                sex = "Female";
                mMaleBtn.setBackground(getResources().getDrawable(R.drawable.button_sex_selector));
                mMaleBtn.setTextColor(getResources().getColor(R.color.colorPlaceHolder));

                mFemaleBtn.setBackground(getResources().getDrawable(R.drawable.button_shape_sex_pressed));
                mFemaleBtn.setTextColor(getResources().getColor(R.color.colorWhite));

                phoneBookPresenter.editTextChanged(mUserNameET,mUserTelET,sex);
                break;
            case R.id.btn_submit:
                phoneBookPresenter.submit(mUserNameET.getText().toString(),mUserTelET.getText().toString(),sex);
                break;
        }
    }

    @Override
    public void setNameError() {
        mUserNameET.setError("Username Empty");
    }

    @Override
    public void setPhoneError() {
        mUserTelET.setError("User telephone Empty");
    }


    @Override
    public void setcreatephonebook(List<PhoneBookItem> itemList) {
        mUserNameET.setText("");
        mUserTelET.setText("");
        sex="";
        mMaleBtn.setBackground(getResources().getDrawable(R.drawable.button_sex_selector));
        mFemaleBtn.setBackground(getResources().getDrawable(R.drawable.button_sex_selector));
        mMaleBtn.setTextColor(getResources().getColor(R.color.colorPlaceHolder));
        mFemaleBtn.setTextColor(getResources().getColor(R.color.colorPlaceHolder));
        rvAdapterPhoneBook.updateData(itemList);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,""+message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTextWatcher(boolean isEnable) {
        if(isEnable) {
            mSubmitBtn.setEnabled(true);
            mSubmitBtn.setBackground(getResources().getDrawable(R.drawable.button_shape_submit));

        }else{
            mSubmitBtn.setEnabled(false);
            mSubmitBtn.setBackgroundResource(android.R.drawable.btn_default);

        }
    }
}
