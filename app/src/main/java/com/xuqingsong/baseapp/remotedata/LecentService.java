package com.xuqingsong.baseapp.remotedata;

import com.xuqingsong.baseapp.http.result.Result;
import com.xuqingsong.baseapp.user.bean.User;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 乐城会见服务接口类
 */
public interface LecentService {
    @GET("open/api/weather/json.shtml")
    Call<Result> getWeather(@Query("city") String city);

    @GET("book/search")
    Call<Result> getBook(@Query("q") String name);

    /**
     * 身份证登录
     *
     * @return 家属信息
     */
    @POST("lecent-auth/oauth/token")
    @FormUrlEncoded
    Observable<Result<User>> loginByIDCard(@Header("Authorization") String auth,
                                           @Field("auth_type") String auth_type,
                                           @Field("grant_type") String grant_type,
                                           @Field("password") String password,
                                           @Field("tenant_id") String tenant_id,
                                           @Field("idCard") String idCard,
                                           @Field("user_type") String user_type);
}
