package com.xuqingsong.baseapp.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * 网络请求框架，首先是单例。
 */
public class RetrofitServiceManager {
    //定义网络连接时长
    private static final int DEFAULT_CONNECT_TIME = 10;
    private static final int DEFAULT_WRITE_TIME = 30;
    private static final int DEFAULT_READ_TIME = 30;
    //定义变量
    private final Retrofit retrofit;
    private final OkHttpClient okHttpClient;

    private RetrofitServiceManager() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.tag("OkHttp").d(message);
            }
        });

        okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(DEFAULT_CONNECT_TIME, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIME, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Api.LECENT_HOST)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static class SingletonHolder {
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();
    }

    //返回单例
    public static RetrofitServiceManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 返回对应 RetrofitService 服务接口
     *
     * @param service
     * @param <T>
     * @return
     */
    public <T> T getService(Class<T> service) {
        return retrofit.create(service);
    }

}
