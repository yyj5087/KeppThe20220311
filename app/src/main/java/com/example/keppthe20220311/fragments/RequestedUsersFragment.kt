package com.example.keppthe20220311.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.keppthe20220311.R
import com.example.keppthe20220311.databinding.FragmentMyFriendsBinding
import com.example.keppthe20220311.databinding.FragmentRequestedUsersBinding

class RequestedUsersFragment : BaseFragment() {

    lateinit var binding: FragmentRequestedUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_requested_users,container,false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvent()
        setValues()

    }



    override fun setupEvent() {

    }

    override fun setValues() {

    }
}