package com.example.yinshengnan.suting_a.sn.network;

/**
 * Created by jl on 2019/1/10.
 */

public class HttpUrlConfig {

    public static Boolean ISLOGIN = false;

    //public static String Token = "9cd1e4be-4898-44db-aa8f-210d1bb2f8b6";
    public static String Token = "";

    /** 服务器地址 */
//    public static String ServerUrl = "http://59.110.159.182:9040/";


    public static String ServerUrl = "http://59.110.159.182:8888/";

    //http://59.110.159.182:8040/
    /**登录**/
    public static final String Login = "http://59.110.159.182:8040/oauth/token?";



     /**获取房间**/
     public static final String RoomSearch = "api/room/bind";

    /**绑定锁**/
    public static final String BindForApp = "/init-lock-and-bind";

     /**查房列表**/
     public static final String CheckRoomList = "api/room/check";

    /**房间**/
    public static final String Room = "api/room/";
    /** 查房名**/
    public static final String ChangeStateCheck = "/change-state-check";

    /**删除密码列表**/
    public static final String DeletePasswordList = "api/room/lock";

    /**删除密码**/
    public static final String DeletePassword = "api/electronic-lock/delete/";

    /**改变房间状态**/
    public static final String CheckRoomState = "/change-state-clean";

    /**获取用户信息**/
    public static final String UserInfo = "http://59.110.159.182:9030/principal";

    /**修改用户密码**/
    public static final String modifyPassword = "http://59.110.159.182:9030/password?";






}
