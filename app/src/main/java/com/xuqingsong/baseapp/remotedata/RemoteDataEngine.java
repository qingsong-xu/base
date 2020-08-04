package com.xuqingsong.baseapp.remotedata;

import com.xuqingsong.baseapp.http.RetrofitServiceManager;
import com.xuqingsong.baseapp.http.result.Result;
import com.xuqingsong.baseapp.user.IUserModel;
import com.xuqingsong.baseapp.user.bean.User;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 此层逻辑由用户自己定义调用，调用方式为
 * RetrofitServiceManager.getInstance().getService(LecentService.class)
 */
public class RemoteDataEngine implements IUserModel {
    private static final String AUTH_KEY = "Basic bWVldF9hcHA6bWVldF9hcHBfc2VjcmV0";
    //1 罪犯、2 狱警、3 狱警管理员、4 实施人员、5 系统用户、6 家属
    public static final String ACCOUNT_TYPE_FAMILY = "family";
    public static final String ACCOUNT_TYPE_POLICE = "system_user";

    private RemoteDataEngine() {
    }

    private static class RemoteDataEngineSingleton {
        private final static RemoteDataEngine INSTANCE = new RemoteDataEngine();
    }

    public static RemoteDataEngine getInstance() {
        return RemoteDataEngineSingleton.INSTANCE;
    }

    @Override
    public void loginByIDCard(String cardNumber, Observer<Result<User>> observer) {
        RetrofitServiceManager.getInstance().getService(LecentService.class).loginByIDCard(AUTH_KEY, "idCard", "password", "idCard",
                "5328", cardNumber, ACCOUNT_TYPE_FAMILY)
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
