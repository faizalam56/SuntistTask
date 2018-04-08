package com.appendous.suntisttask.presenter;

import com.appendous.suntisttask.util.ButtonFuturaMdBt;
import com.appendous.suntisttask.util.EditTextFuturaMdBt;

/**
 * Created by root on 7/4/18.
 */

public interface PhoneBookPresenter {

    void submit(String name,String tel,String sex);
    void editTextChanged(EditTextFuturaMdBt nameET, EditTextFuturaMdBt telET, String sex);
}
