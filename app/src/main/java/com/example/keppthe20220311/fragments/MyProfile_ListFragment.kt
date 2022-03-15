package com.example.keppthe20220311.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.keppthe20220311.ManageMyFriendsActivity
import com.example.keppthe20220311.R
import com.example.keppthe20220311.SplashActivity
import com.example.keppthe20220311.api.ServerAPI
import com.example.keppthe20220311.databinding.FragmentMyProfileBinding
import com.example.keppthe20220311.datas.BasicResponse
import com.example.keppthe20220311.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfile_ListFragment : BaseFragment() {

    lateinit var binding: FragmentMyProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_profile,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupEvent()
        setValues()

    }

    override fun setupEvent() {

        binding.btnManageMyFriends.setOnClickListener {
            val myIntent = Intent(mContext, ManageMyFriendsActivity::class.java)
            startActivity(myIntent)
        }



        binding.btnLogout.setOnClickListener {
            val alert = AlertDialog.Builder(mContext)
                .setTitle("로그아웃")
                .setMessage("정말 로그아웃 하시겠습니까?")
                .setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->

//                    실제 로그아웃 처리 => 저장된 토큰을 초기화.
                    ContextUtil.setLoginUserToken(mContext, "")

//                    로딩화면으로 복귀
                    val myIntent = Intent(mContext, SplashActivity::class.java)
                    myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(myIntent)

                })
                .setNegativeButton("취소", null)
                .show()

        }

    }

    override fun setValues() {


//        내 정보 조회 > UI 반영
        apiList.getRequestMyInfo().enqueue(object :Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if(response.isSuccessful){
                    val br = response.body()!!
                   binding.txtNickname.text = br.data.user.nick_name // 프래그먼트의 txtNickname은 어떻게 가져와야하는가?

                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })
    }

}