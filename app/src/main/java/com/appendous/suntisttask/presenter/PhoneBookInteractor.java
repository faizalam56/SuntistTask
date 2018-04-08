package com.appendous.suntisttask.presenter;

import com.appendous.suntisttask.model.PhoneBookItem;
import com.appendous.suntisttask.util.ButtonFuturaMdBt;
import com.appendous.suntisttask.util.EditTextFuturaMdBt;

import java.util.List;

/**
 * Created by root on 7/4/18.
 */

public interface PhoneBookInteractor {

    interface onPhoneBookListener{
        void onSuccess();
        void onNameError();
        void onPhoneError();
        void onFailure(String message);
        void onCreatePhonebook(List<PhoneBookItem> itemList);
    }
    void onSubmit(String name,String tel,String sex,onPhoneBookListener listener);

    interface onTextChangeListener{
        void onTextChangedName(boolean isEnable);
    }

    void onTextChangeAction(EditTextFuturaMdBt nameET,EditTextFuturaMdBt telET,String sex,onTextChangeListener listener);

}
