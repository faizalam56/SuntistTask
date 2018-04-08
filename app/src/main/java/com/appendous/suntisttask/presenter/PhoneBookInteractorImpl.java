package com.appendous.suntisttask.presenter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import com.appendous.suntisttask.model.PhoneBookItem;
import com.appendous.suntisttask.util.EditTextFuturaMdBt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 7/4/18.
 */

public class PhoneBookInteractorImpl implements PhoneBookInteractor {

    private List<PhoneBookItem> phonebookList = new ArrayList<>();
    @Override
    public void onSubmit(String name, String tel, String sex, onPhoneBookListener listener) {
        String temp=name;
        temp=temp.toUpperCase();
        if(TextUtils.isEmpty(name)){
            listener.onNameError();
        }else if(!temp.equals(name)){
            listener.onFailure("Name must be uppercase");
        }else if(TextUtils.isEmpty(tel)){
            listener.onPhoneError();
        }else if(!tel.matches("[0-9]+")){
            listener.onFailure("tel must be digit");
        }else if(tel.length()!=10){
            listener.onFailure("Tel must be 10 digit");
        }else if(sex.equals("")){
            listener.onFailure("Must Select Sex");
        }else{
            listener.onFailure("PhoneBookCreateSuccesfully");
            addPhoneBook(name,tel,sex,listener);
        }
    }

    String tel="",name = "";
    @Override
    public void onTextChangeAction(final EditTextFuturaMdBt nameET, final EditTextFuturaMdBt telET, final String sex, final onTextChangeListener listener) {

        nameET.addTextChangedListener (new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2){
                name = s.toString();
                checkRequiredFields(name, tel,sex,listener);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        telET.addTextChangedListener (new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2){
                 tel = s.toString();
                checkRequiredFields(name,tel,sex,listener);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        if(sex.length()>0){
            checkRequiredFields(name,tel,sex,listener);
        }
    }

    private void checkRequiredFields(String name, String tel, String sex,onTextChangeListener listener){
        if(name.length()>0&&tel.length()>0&&sex.length()>0){
            listener.onTextChangedName(true);
        }else{
            listener.onTextChangedName(false);
        }

    }

    private void addPhoneBook(String name, String tel, String sex,onPhoneBookListener listener){
        PhoneBookItem phoneBookItem = new PhoneBookItem();
        phoneBookItem.name = name;
        phoneBookItem.telephone = tel;
        phoneBookItem.sex = sex;
        phonebookList.add(phoneBookItem);
        listener.onCreatePhonebook(phonebookList);

    }

}
