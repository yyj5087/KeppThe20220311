package com.example.keppthe20220311

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Base64
import android.util.Log
import com.example.keppthe20220311.datas.BasicResponse
import com.example.keppthe20220311.utils.ContextUtil
import com.google.firebase.messaging.FirebaseMessaging
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.MessageDigest

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
//        임시 - 자동 로그인 구현 전까지는, 2.5초 후에 무조건 로그인화면으로.

        var isMyInfoLoaded = false

        apiList.getRequestMyInfo()
            .enqueue(object : Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
//                code : 200 => 성공 응답이 왔다? 내정보가 일단 잘 불러졌다.
                    if (response.isSuccessful) {
                        isMyInfoLoaded = true
                    }
                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }

            })

        val myHandler = Handler(Looper.getMainLooper())
        myHandler.postDelayed({

            val myIntent: Intent

            if (isMyInfoLoaded) {
                myIntent = Intent(mContext, MainActivity::class.java)
            } else {
                myIntent = Intent(mContext, SignInActivity::class.java)
            }
            startActivity(myIntent)
            finish()

        }, 2500)
        getKeyHash()
        getFCMDeviceToken()
    }
    fun getFCMDeviceToken(){

        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            Log.d("토큰값", it.result!!)
        }

    }
    fun getKeyHash(){

        val info = packageManager.getPackageInfo(
            "com.example.keppthe20220311",
            PackageManager.GET_SIGNATURES
        )
        for (signature in info.signatures) {
            val md: MessageDigest = MessageDigest.getInstance("SHA")
            md.update(signature.toByteArray())
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
        }
    }
}