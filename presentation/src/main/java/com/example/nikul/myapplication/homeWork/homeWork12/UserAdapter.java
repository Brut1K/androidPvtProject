package com.example.nikul.myapplication.homeWork.homeWork12;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.domain.entity.UserEntity;
import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.classWork.classWork6.UserListAdapter;

import java.util.List;

import io.reactivex.Observable;


public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Observable<List<UserEntity>> list;

    public Observable<List<UserEntity>> getList() {
        return list;
    }

    public void setList(Observable<List<UserEntity>> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_userentity,parent,false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder holder1 = (Holder) holder;
//        final UserEntity userEntity = list.get(position);
 //       holder1.nameTextView.setText(userEntity.getUserName());


    }

    @Override
    public int getItemCount() {
  //      return list.size();
        return 1;
    }

    static class Holder extends RecyclerView.ViewHolder{

        TextView nameTextView;
        public Holder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.userentityTextView);
                   }

    }
}
