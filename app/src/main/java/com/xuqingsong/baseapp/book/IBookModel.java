package com.xuqingsong.baseapp.book;

import com.xuqingsong.baseapp.http.callback.CallBack;
import com.xuqingsong.baseapp.http.result.Result;

public interface IBookModel {
    void loadBook(String name, CallBack callBack);
}
