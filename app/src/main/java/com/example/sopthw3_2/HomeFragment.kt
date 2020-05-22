package com.example.sopthw3_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var instaAdapter: InstaAdapter
    val datas = mutableListOf<InstaData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter = InstaAdapter(view.context)
        rv_home.adapter = instaAdapter
        loadDatas()


    }

    private fun loadDatas() {
        datas.apply {
            add(
                InstaData(
                    userName = "하영",
                    img_profile = "https://image.shutterstock.com/image-photo/emperor-penguin-chick-glancing-sideways-260nw-1008811921.jpg",
                    img_contents = "https://image.shutterstock.com/image-photo/five-emperor-penguin-chicks-grouped-260nw-1213001791.jpg"
                )
            )
            add(
                InstaData(
                    userName = "고양이",
                    img_profile = "https://image.shutterstock.com/image-photo/portrait-surprised-cat-scottish-straight-260nw-499196506.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492__480.jpg"
                )
            )
            add(
                InstaData(
                    userName = "풍경",
                    img_profile = "https://cdn.pixabay.com/photo/2020/05/04/16/05/mckenzie-river-5129717__340.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2020/05/04/11/19/smile-5128742__340.jpg"
                )
            )
        }

        rv_home.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL))

        instaAdapter.datas = datas
        //아래 코드는 데이터가 갱신되었음을 어댑터에 알려주는 역할입니다.
        //데이터 변경이 있다면 어댑터에 알려주세요.
        instaAdapter.notifyDataSetChanged()
    }
}