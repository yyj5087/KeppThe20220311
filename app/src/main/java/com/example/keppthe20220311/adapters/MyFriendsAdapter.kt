package com.example.keppthe20220311.adapters

import android.content.Context
import android.service.autofill.UserData
import android.widget.ArrayAdapter

class MyFriendsAdapter(
    val mContext: Context,
    resId: Int,
    val mList: List<UserData>
) : ArrayAdapter<UserData>(mContext, resId, mList) {
}