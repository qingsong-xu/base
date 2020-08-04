package com.xuqingsong.baseapp.http.callback;

public abstract class CallBack<T> {
    public void onStart() {
    }

    public abstract void onSuccess(T t);

    public abstract void onFail(String code, String msg);

    public void onFinish() {
    }
}
