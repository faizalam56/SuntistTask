package com.appendous.suntisttask.presenter;

import com.appendous.suntisttask.model.PhoneBookItem;
import com.appendous.suntisttask.util.ButtonFuturaMdBt;
import com.appendous.suntisttask.util.EditTextFuturaMdBt;
import com.appendous.suntisttask.view.PhoneBookView;

import java.util.List;

/**
 * Created by root on 7/4/18.
 */

public class PhoneBookPresenterImpl implements PhoneBookPresenter,PhoneBookInteractor.onPhoneBookListener,PhoneBookInteractor.onTextChangeListener {

    private PhoneBookView phoneBookView;
    private PhoneBookInteractor phoneBookInteractor;

    public PhoneBookPresenterImpl(PhoneBookView phoneBookView){
        this.phoneBookView = phoneBookView;
        phoneBookInteractor = new PhoneBookInteractorImpl();
    }
    @Override
    public void submit(String name, String tel, String sex) {
        phoneBookInteractor.onSubmit(name,tel,sex,this);
    }

    @Override
    public void editTextChanged(EditTextFuturaMdBt nameET, EditTextFuturaMdBt telET, String sex) {
        phoneBookInteractor.onTextChangeAction(nameET,telET,sex,this);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onNameError() {
        if(phoneBookView!=null){
            phoneBookView.setNameError();
        }
    }

    @Override
    public void onPhoneError() {
        if(phoneBookView!=null){
            phoneBookView.setPhoneError();
        }
    }

    @Override
    public void onFailure(String message) {
        if(phoneBookView!=null){
            phoneBookView.showMessage(message);
        }
    }

    @Override
    public void onCreatePhonebook(List<PhoneBookItem> itemList) {
        if(phoneBookView!=null){
            phoneBookView.setcreatephonebook(itemList);
        }
    }

    @Override
    public void onTextChangedName(boolean isEnable) {
        if(phoneBookView!=null){
            phoneBookView.setTextWatcher(isEnable);
        }
    }


}
