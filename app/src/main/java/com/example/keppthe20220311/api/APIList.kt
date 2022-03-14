package com.example.keppthe20220311.api

import com.example.keppthe20220311.datas.BasicResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface APIList {

//    BASE_URL에 해당하는 서버에서, 어떤 기능들을 사용할건지 명시.

    @FormUrlEncoded //파라미터중에, Field (formData)에 담아야하는 파라미터가 있ekaus 필요한 문구
    @POST("/user")
    fun postRequestLogin(
    @Field("email") email: String,
    @Field("password") pw: String
    ) : Call<BasicResponse> // 서버가 주는 응답을 (성공시에) BasicResponse 형태로 자동 파싱

    @FormUrlEncoded
    @PUT("/user")
    fun putRequestSignUp(
        @Field("email") email: String,
        @Field("password") pw: String,
        @Field("nick_name") nick: String,
    ) : Call<BasicResponse>

    @GET("/user")
    fun getRequestMyInfo(
        @Header("X-Http-Token") token: String,
    ) : Call<BasicResponse>

    @GET("/user/check")
    fun getRequestDuplicatedCheck(
        @Query("type") type: String,
        @Query("value") value: String,
    ) : Call<BasicResponse>

    @GET("/user/friend")
    fun getRequestFriendList(
        @Header("X-Http-Token") token: String,
        @Query("type") type: String // all, my, requested 세문구 외에는 넣지 말자
    ) : Call<BasicResponse>

    @GET("/search/user")
    fun getRequestSearchUser(
        @Header("X-Http-Token") token: String,
        @Query("nickname") nickname: String,
    ) : Call<BasicResponse>


}