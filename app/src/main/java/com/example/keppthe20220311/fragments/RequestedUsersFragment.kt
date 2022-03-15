package com.example.keppthe20220311.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.keppthe20220311.R
import com.example.keppthe20220311.adapters.RequestUserRecyclerAdapter
import com.example.keppthe20220311.databinding.FragmentMyFriendsBinding
import com.example.keppthe20220311.databinding.FragmentRequestedUsersBinding
import com.example.keppthe20220311.datas.BasicResponse
import com.example.keppthe20220311.datas.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestedUsersFragment : BaseFragment() {

    lateinit var binding: FragmentRequestedUsersBinding

    val mRequestedUserList = ArrayList<UserData>()

    lateinit var mAdapter: RequestUserRecyclerAdapter

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

//        나에게 친구 요청한 사람 목록을 > 리싸이클러뷰로 보여주기
//        API : getRequestFriends 함수 -> "request" 로 대입

        getRequestedUsersFromServer()

        mAdapter = RequestUserRecyclerAdapter(mContext, mRequestedUserList)
        binding .requestUsersRecyclerView.adapter = mAdapter

        binding.requestUsersRecyclerView.layoutManager = LinearLayoutManager(mContext)

    }
    fun getRequestedUsersFromServer(){

        apiList.getRequestFriendList("requested").enqueue(object : Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {

                if (response.isSuccessful){

                    mRequestedUserList.clear()
                    mRequestedUserList.addAll(response.body()!!.data.friends)
                    mAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }

        })

    }
}