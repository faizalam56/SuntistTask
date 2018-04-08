package com.appendous.suntisttask.view;

import com.appendous.suntisttask.model.PhoneBookItem;

import java.util.List;

/**
 * Created by root on 7/4/18.
 */

public interface PhoneBookView {
    void setNameError();
    void setPhoneError();
    void setcreatephonebook(List<PhoneBookItem> itemList);
    void showMessage(String message);
    void setTextWatcher(boolean isEnable);
}
