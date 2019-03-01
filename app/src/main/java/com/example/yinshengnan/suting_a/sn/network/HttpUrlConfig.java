package com.example.yinshengnan.suting_a.sn.network;

/**
 * Created by jl on 2019/1/10.
 */

public class HttpUrlConfig {

    public static String Token = "9cd1e4be-4898-44db-aa8f-210d1bb2f8b6";

    /** 服务器地址 */
    public static String ServerUrl = "http://59.110.159.182:9040/";


//    public static String ServerUrl = "http://59.110.159.182:8040/";

    /**登录**/
    public static final String Login = "http://59.110.159.182:8040/oauth/token?";

    public static final String LoginSelect = "http://59.110.159.182:9030/account/select";

    /**获取房源地址**/
     public static final String HouseSearchResources = "house/search";

     /**获取房间**/
     public static final String RoomSearch = "room/search";

    /**查房**/
    public static final String ChangeStateCheck = "room/state/check?roomId=";

    /**删除密码**/
    public static final String DeletePassword = "/room/state/reset?roomId=";

    /**绑定锁**/
    public static final String BindForApp = "room/forapp/bind/";
    /**
     * 获取锁信息
     */
    public static final String LockBean = "electronic-lock/getone/";

    /**获取用户信息**/
    public static final String UserInfo = "http://59.110.159.182:9030/principal";

    /**修改密码**/
    public static final String modifyPassword = "http://59.110.159.182:9030/password?";






}
