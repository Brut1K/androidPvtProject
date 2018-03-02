package com.example.nikul.myapplication.homeWork.homeWork6;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nikul.myapplication.R;
import com.example.nikul.myapplication.homeWork.homeWork6.it_academy.entity.Student;
import com.squareup.leakcanary.LeakTraceElement;

import java.util.List;
import java.util.zip.Inflater;

public class StudentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Student> students;
    private View.OnClickListener onClickListener;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students.clear();
        this.students.addAll(students);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student,parent,false);
        return new HolderS(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HolderS myHolder = (HolderS) holder;
        final Student student = students.get(position);
        myHolder.textViewName.setText(student.getName());
        myHolder.textViewSurName.setText(student.getSurname());
        myHolder.textViewLastName.setText(student.getLastname());
        myHolder.textViewBDay.setText(student.getbDay().toString());

    }

    @Override
    public int getItemCount() {
        return students.size();
    }


    static class HolderS extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewSurName;
        TextView textViewLastName;
        TextView textViewBDay;

        public HolderS(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewSurName = itemView.findViewById(R.id.textViewSurName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            textViewBDay = itemView.findViewById(R.id.textViewBDay);


        }
    }
}
