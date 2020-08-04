package com.xuqingsong.baseapp.user;

import com.xuqingsong.baseapp.http.result.Result;
import com.xuqingsong.baseapp.user.bean.User;

import io.reactivex.rxjava3.core.Observer;

public interface IUserModel {
    void loginByIDCard(String cardNumber, Observer<Result<User>> callback);
}
