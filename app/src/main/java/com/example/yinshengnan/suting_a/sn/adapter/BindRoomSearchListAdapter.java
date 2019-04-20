package com.example.yinshengnan.suting_a.sn.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yinshengnan.suting_a.R;
import com.example.yinshengnan.suting_a.sn.bean.Responds.BindRoomSearchListResponses;
import com.example.yinshengnan.suting_a.sn.bean.Responds.CheckRoomSearchListResponses;
import com.example.yinshengnan.suting_a.sn.callback.ClickCallback;
import com.example.yinshengnan.suting_a.sn.showUtil.GlideUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jl on 2019/1/9.
 */

public class BindRoomSearchListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private List<BindRoomSearchListResponses> mRoomList = new ArrayList<>();


    private ClickCallback mClickCallback;

    public BindRoomSearchListAdapter(Context context, List<BindRoomSearchListResponses> roomList) {

        this.mContext = context;
        this.mRoomList = roomList;
    }


    public void setClickCallback(ClickCallback clickCallback) {
        this.mClickCallback = clickCallback;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.houseinfo_list_item, parent, false);

        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        BindRoomSearchListResponses rommSearchResponses = mRoomList.get(position);
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.numberTV.setText(rommSearchResponses.getName() + rommSearchResponses.getName());
        myViewHolder.addressTV.setText(rommSearchResponses.getHouse().getAddress());
        myViewHolder.typeTV.setText(rommSearchResponses.getHouse().getHouseType() + rommSearchResponses.getState());
        //roomSearchResponses.getHouse().getTopUrl()
        GlideUtils.setCircleImage(mContext,myViewHolder.imageView,rommSearchResponses.getImagePath(),R.mipmap.ic_launcher);

        myViewHolder.btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickCallback.ItemOnClick(v, position);
            }
        });
//


    }


    @Override
    public int getItemCount() {
        return mRoomList.size();
    }


    private class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView numberTV, addressTV, typeTV;
        Button btnCheck, btnResetPW, btnBind;
        RelativeLayout functionLayout;
        ConstraintLayout constraintLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.ascc_house_layout);
            functionLayout = (RelativeLayout) itemView.findViewById(R.id.house_function_Layout);
            imageView = (ImageView) itemView.findViewById(R.id.house_imageView);
            numberTV = (TextView) itemView.findViewById(R.id.house_number);
            addressTV = (TextView) itemView.findViewById(R.id.house_address);
            typeTV = (TextView) itemView.findViewById(R.id.house_info);
            btnCheck = (Button) itemView.findViewById(R.id.btn_check_house);
            btnResetPW = (Button) itemView.findViewById(R.id.btn_password_reset);
            btnBind = (Button) itemView.findViewById(R.id.btn_binding);
            functionLayout.setVisibility(View.VISIBLE);
            btnBind.setVisibility(View.VISIBLE);
            btnCheck.setVisibility(View.GONE);
            btnResetPW.setVisibility(View.GONE);
            imageView.setVisibility(View.GONE);
        }


    }

}
