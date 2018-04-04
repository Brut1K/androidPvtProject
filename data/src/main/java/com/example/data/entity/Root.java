package com.example.data.entity;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Root {

    @SerializedName("data")
    private List<Data> dataList = new ArrayList<>();

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Data d : dataList) {
            sb.append(d.toString());
        }
        return "Root{" +
                "dataList=" + sb.toString()
                +
                '}';
    }
}

