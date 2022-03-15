package com.example.keppthe20220311.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.keppthe20220311.R
import com.example.keppthe20220311.datas.UserData

class MyFriendRecyclerAdapter(
    val mContext: Context,
    val mList: List<UserData>
) : RecyclerView.Adapter<MyFriendRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(mContext).inflate(R.layout.my_friends_list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount() = mList.size

}