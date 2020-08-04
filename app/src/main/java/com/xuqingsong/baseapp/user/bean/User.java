package com.xuqingsong.baseapp.user.bean;

import com.xuqingsong.baseapp.http.result.Result;

import java.io.Serializable;

public class User extends Result implements Serializable {
    public String access_token;
    public String token_type;
    public String refresh_token;
    public String expires_in;
    public String scope;
    public String tenant_id;
    public String user_name;
    public String id_card;
    public String real_name;
    public String address;
    public String birthday;
    /*avatar*/
    public String avatar;
    public String client_id;
    public String role_name;
    public String license;
    public String user_id;
    public String role_id;
    public String nick_name;
    public String dept_id;
    public String account;
    public String jti;
    public boolean allow_app_login;
    //以下是身份证回显时兼容是新增的
    public String name;
    public String homeAddress;
    public String nation;
    public String sex;
    public String idCode;
}
