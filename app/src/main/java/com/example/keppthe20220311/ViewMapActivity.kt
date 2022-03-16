package com.example.keppthe20220311

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.keppthe20220311.databinding.ActivityViewMapBinding
import com.example.keppthe20220311.datas.AppointmentData
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.overlay.Marker

class ViewMapActivity : BaseActivity() {

    lateinit var binding: ActivityViewMapBinding

    lateinit var mAppointment: AppointmentData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_view_map)

        mAppointment = intent.getSerializableExtra("appointment")as AppointmentData


        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        binding.naverMapView.getMapAsync {
            val naverMap = it

//            도착지 자체를를 변수화.
            val destLatLng = LatLng(mAppointment.latitude, mAppointment.longitude)

//           도착지로 카메라 이동
            val cameraUpdate = CameraUpdate.scrollTo(destLatLng)
            naverMap.moveCamera(cameraUpdate)

//            마커도 찍어주자.

            val marker = Marker()
            marker.position = destLatLng
            marker.map = naverMap

        }
   }
}