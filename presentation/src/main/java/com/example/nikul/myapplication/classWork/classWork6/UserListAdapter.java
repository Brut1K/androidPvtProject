package com.example.nikul.myapplication.classWork.classWork6;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nikul.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;



public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> itemList = new ArrayList<>();
    private OnUserClickListener listener;

    public List<User> getItemList() {
        return itemList;
    }

    public void setItemList(List<User> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        //заставляет recycler.view перерисовать экран
        notifyDataSetChanged();
    }

    public void setListener(OnUserClickListener listener) {
        this.listener = listener;
    }

    //создаёт холдер, который содержит layout, он кэшируется,т.е.
    // для разных позиций может использоваться один и тот же холдер
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user,parent,false);
        return new Holder(view);
    }
//вызывается для каждого элемента, используется для заполнения данных item-один элемент
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Holder myholder = (Holder) holder;
        final User user = itemList.get(position);

        myholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null) listener.onClick(user,position);
            }
        });

        if(TextUtils.isEmpty(user.getImageURL())){

        } else {
            Glide.with(myholder.imageView.getContext())
                    .load(user.getImageURL()).into(myholder.imageView);
        }

//        myholder.imageView.setBackgroundResource();

        if(TextUtils.isEmpty(user.getName())) {
            myholder.nameTextView.setText("");
        } else {
            myholder.nameTextView.setText(user.getName());

        }
        myholder.surNameTextView.setText(user.getSurname());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

//технический класс для хранения item и ссылок на элементы
    static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView nameTextView;
        TextView surNameTextView;
        public Holder(View itemView) {
            super(itemView);
            Log.e("UserAdapter","Holder()");
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            surNameTextView = itemView.findViewById(R.id.surnameTextView);
        }

    }


    interface OnUserClickListener {
        void onClick(User user, int position);
    }


}


