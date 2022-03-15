package com.example.keppthe20220311

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.keppthe20220311.adapters.MyFriendsAdapter
import com.example.keppthe20220311.databinding.ActivityManageMyFriendsBinding
import com.example.keppthe20220311.datas.BasicResponse
import com.example.keppthe20220311.datas.UserData
import com.example.keppthe20220311.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ManageMyFriendsActivity : BaseActivity() {

    lateinit var binding: ActivityManageMyFriendsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_manage_my_friends)

        setupEvents()
        setValues()


    }

    override fun setupEvents() {

        binding.btnAddFriend.setOnClickListener {
            val myIntent = Intent(mContext, SearchUserActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {

    }

}