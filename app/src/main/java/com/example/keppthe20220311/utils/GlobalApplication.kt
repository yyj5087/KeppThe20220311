package com.example.keppthe20220311.utils

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this,"3cc1e99251a185569c0185e18dda3d9d")
    }
}