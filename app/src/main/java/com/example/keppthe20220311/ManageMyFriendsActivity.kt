package com.example.keppthe20220311

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.keppthe20220311.databinding.ActivityManageMyFriendsBinding

class ManageMyFriendsActivity : BaseActivity() {

    lateinit var binding: ActivityManageMyFriendsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_manage_my_friends)

        setupEvents()
        setValues()


    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}