package com.example.keppthe20220311.adapters

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.keppthe20220311.R
import com.example.keppthe20220311.datas.UserData

class MyFriendsAdapter(
    val mContext: Context,
    resId: Int,
    val mList: ArrayList<UserData>
) : ArrayAdapter<UserData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null){
            tempRow = LayoutInflater.from(mContext).inflate(R.layout.activity_manage_my_friends, null)
        }
        val row = tempRow!!
        val data =  mList[position]

        val imgProfile = row.findViewById<ImageView>(R.id.imgProfile)
        val txtNickname = row.findViewById<TextView>(R.id.txtNickname)
        val txtEmail = row.findViewById<TextView>(R.id.txtEmail)
        val imgSocialLoginlogo = row.findViewById<ImageView>(R.id.imgSocialLoginLogo)

        Glide.with(mContext).load(data.profile_img).into(imgProfile)
        txtNickname.text = data.nick_name


//        사용자의 provider - "default" : 이메일 표시, "kakao" : 카카오 로그인, "facebook" : 페북
//        txtEmail 자리에 반영
        when(data.provider){
            "default" -> {
//                이메일 표시
                txtEmail.text  = data.email

//                로고 이미지 숨김
                imgSocialLoginlogo.visibility = View.GONE
            }
            "kakao" -> {

                txtEmail.text = "카카오로그인"
                imgSocialLoginlogo.visibility = View.VISIBLE
                Glide.with(mContext).load(R.drawable.kk).into(imgSocialLoginlogo)

//                "카카오로그인"
//                로고 이미지 : 카카오 아이콘
            }
            "facebook" ->{
                txtEmail.text = "페북 로그인"
                Glide.with(mContext).load(R.drawable.ff).into(imgSocialLoginlogo)

            }
            "naver" ->{
                txtEmail.text = "네이버 로그인"

//                Glide는 웹의 이미지 뿐만 아니라, 우리 프로젝트 내부의 이미지도 불러낼수 있다.
                Glide.with(mContext).load(R.drawable.nn).into(imgSocialLoginlogo)

            }
            else ->{
//                그 외의 잘못된 경우우
            }
       }

        return row
    }
}