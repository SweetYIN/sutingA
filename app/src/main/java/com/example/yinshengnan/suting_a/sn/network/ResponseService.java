package com.example.yinshengnan.suting_a.sn.network;


import com.ttlock.bl.sdk.util.DigitUtil;

import java.util.HashMap;

/**
 * Created by TTLock on 2016/9/8 0008.
 */
public class ResponseService {
    private static final String TAG = "ResponseService";
    private static String actionUrl = "https://api.ttlock.com.cn";
    private static String actionUrlV3 = actionUrl + "/v3";

    /**
     * authorize
     * @param username  user name
     * @param password  password
     * @return
     */
    public static String auth(String username, String password) {
        String url = actionUrl + "/oauth2/token";
        HashMap params = new HashMap();
        params.put("client_id", Config.CLIENT_ID);
        params.put("client_secret", Config.CLIENT_SECRET);
        params.put("grant_type", "password");
        params.put("username", username);
        params.put("password", DigitUtil.getMD5(password));
        params.put("redirect_uri", Config.REDIRECT_URI);
        return OkHttpRequest.sendPost(url, params);
    }

}
