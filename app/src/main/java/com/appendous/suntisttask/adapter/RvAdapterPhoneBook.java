package com.appendous.suntisttask.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appendous.suntisttask.R;
import com.appendous.suntisttask.model.PhoneBookItem;
import com.appendous.suntisttask.util.TextViewFuturaMdBt;

import java.util.List;

/**
 * Created by root on 7/4/18.
 */

public class RvAdapterPhoneBook extends RecyclerView.Adapter<RvAdapterPhoneBook.RvHolderPhoneBook> {

    Context mContext;
    List<PhoneBookItem> phonelist;
    public RvAdapterPhoneBook(Context context, List<PhoneBookItem> list){
        this.mContext = context;
        this.phonelist = list;
    }
    @Override
    public RvHolderPhoneBook onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_rv_phonebook, parent, false);
        return new RvHolderPhoneBook(itemView);
    }

    @Override
    public void onBindViewHolder(RvHolderPhoneBook holder, int position) {
        if(phonelist!=null){
            holder.mUserName.setText(phonelist.get(position).name);
            holder.mUserTel.setText(phonelist.get(position).telephone);
            holder.mUserSex.setText(phonelist.get(position).sex);
        }
    }

    @Override
    public int getItemCount() {
       return phonelist !=null? phonelist.size():0;
    }

    public void updateData(List<PhoneBookItem> phonelist) {
        this.phonelist = phonelist;
        notifyDataSetChanged();
    }
    class RvHolderPhoneBook extends RecyclerView.ViewHolder{

        TextViewFuturaMdBt mUserName,mUserTel,mUserSex;
        public RvHolderPhoneBook(View itemView) {
            super(itemView);
            mUserName = itemView.findViewById(R.id.tv_rowitem_name);
            mUserTel = itemView.findViewById(R.id.tv_rowitem_tel);
            mUserSex = itemView.findViewById(R.id.tv_rowitem_sex);

            mUserTel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
