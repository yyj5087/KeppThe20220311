package com.example.keppthe20220311

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.keppthe20220311.databinding.ActivityEditMyPlaceBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker

class EditMyPlaceActivity : BaseActivity() {

    lateinit var binding: ActivityEditMyPlaceBinding

//    선택된 장소 저장 변수 / 마커 표시 변수
    var mSelectedPoint : LatLng?  = null
    var marker : Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_edit_my_place)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        binding.naverMapView.getMapAsync {
            val naverMap = it
            naverMap.setOnMapClickListener { pointF, latLng ->

                if(mSelectedPoint == null){
//                    처음으로 지도를 클릭 한 상황
//                    마커를 새로 만들어주자. => 위치정보는? latLng변수가 대입될 예정. 새로 만들 필요 없다.
                    marker = Marker()
                }
                mSelectedPoint = latLng
                marker!!.position = latLng
                marker!!.map = naverMap

            }
        }
    }
}