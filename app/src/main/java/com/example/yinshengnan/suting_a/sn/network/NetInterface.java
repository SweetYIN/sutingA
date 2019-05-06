package com.example.yinshengnan.suting_a.sn.network;



import com.example.yinshengnan.suting_a.sn.bean.Request.LockFormRequest;
import com.example.yinshengnan.suting_a.sn.bean.Responds.BindRoomSearchListResponses;
import com.example.yinshengnan.suting_a.sn.bean.Responds.ChangeStateResetResponses;
import com.example.yinshengnan.suting_a.sn.bean.Responds.CheckRoomSearchListResponses;
import com.example.yinshengnan.suting_a.sn.bean.Responds.DelectPsRoomSearchListResponses;
import com.example.yinshengnan.suting_a.sn.bean.Responds.LoginResponsesBean;
import com.example.yinshengnan.suting_a.sn.bean.Responds.UserInfoResponses;
import com.ttlock.bl.sdk.entity.LockData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface NetInterface {

	/**登录**/
	@FormUrlEncoded
	@POST
	Observable<LoginResponsesBean> Login(@Url String url,
										 @Header("Authorization") String Authorization,
										 @Field("username") String usernme,
										 @Field("password") String password,
										 @Field("grant_type") String grant_type,
										 @Field("scope") String scope) ;


	/**未绑定房间列表**/
	@Headers("Content-Type:application/json")
	@GET(HttpUrlConfig.RoomSearch)
	Observable<List<BindRoomSearchListResponses>> RoomSearch();

	/**绑定锁**/
	@Headers({"Content-Type:application/json",
				"response-wrap:true"})

	@POST
	Observable<ChangeStateResetResponses> BindForApp(@Url String id,@Body() LockFormRequest data);

	/**查房列表**/
	@Headers("Content-Type:application/json")
	@GET(HttpUrlConfig.CheckRoomList)
	Observable<List<CheckRoomSearchListResponses>> CheckRoomSearch();

	/**查房**/
	@Headers({"Content-Type:application/json",
			"response-wrap:true"})
	@POST
	Observable<ChangeStateResetResponses> CheckRoom(@Url String url);

	/**删除密码房间列表**/
	@Headers("Content-Type:application/json")
	@GET(HttpUrlConfig.DeletePasswordList)
	Observable<List<DelectPsRoomSearchListResponses>> DeletePasswordRoomSearch();

	/**s删除密码**/
	@Headers({"response-wrap:true"})
	@FormUrlEncoded
	@POST
	Observable<ChangeStateResetResponses> DeletePassword(@Url String url, @Field("keyboardPwdId") int keyboardPwdId,
														 @Field("electricQuantity") int electricQuantity,
														 @Field("timeStamp") Long timeStamp);

	/**改锁状态**/
	@Headers({"Content-Type:application/json",
			"response-wrap:true"})

	@POST
	Observable<ChangeStateResetResponses> ChangeRoomState(@Url String url);



	/**获取用户信息**/
	@Headers("Content-Type:application/json")
	@GET(HttpUrlConfig.UserInfo)
	Observable<UserInfoResponses> UserInfo();


	/**修改用户密码**/
	@FormUrlEncoded
	@POST
	Observable<String> ModifyPassword(@Url String url, @Field("account") String account,
                                      @Field("password") String password) ;

	/**获取用户信息**/
	@Headers({"Content-Type:application/json",
			"response-wrap:true"})
	@POST(HttpUrlConfig.BackLogin)
	Observable<ChangeStateResetResponses> BackLogin();

}
