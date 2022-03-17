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
import com.example.keppthe20220311.datas.PlaceData
import com.example.keppthe20220311.datas.UserData

class StartPlaceSpinnerAdapter(
    val mContext: Context,
    resId: Int,
    val mList: ArrayList<PlaceData>
) : ArrayAdapter<PlaceData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null){
            tempRow = LayoutInflater.from(mContext).inflate(R.layout.start_place_spinner_list_item, null)
        }
        val row = tempRow!!
        val data =  mList[position]

        val txtStartPlaceName = row.findViewById<TextView>(R.id.txtStartPlaceName)

        txtStartPlaceName.text = data.name



        return row
    }
}