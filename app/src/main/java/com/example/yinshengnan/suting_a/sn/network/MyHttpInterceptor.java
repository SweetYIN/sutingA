package com.example.yinshengnan.suting_a.sn.network;



import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jl on 2019/1/18.
 */

public class MyHttpInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request request;
        HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                // Provide your custom parameter here

                .addQueryParameter("access_token", HttpUrlConfig.Token)

                .build();
        request = originalRequest.newBuilder().url(modifiedUrl).build();
        return chain.proceed(request);

    }
}
