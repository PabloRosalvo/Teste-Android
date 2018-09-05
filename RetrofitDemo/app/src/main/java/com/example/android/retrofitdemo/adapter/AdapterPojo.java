package com.example.android.retrofitdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.retrofitdemo.R;
import com.example.android.retrofitdemo.model.PojoJson;

import java.util.ArrayList;

public class AdapterPojo extends RecyclerView.Adapter<AdapterPojo.EmployeeViewHolder> {

    private ArrayList<PojoJson> dataList;

    public AdapterPojo(ArrayList<PojoJson> dataList) {
        this.dataList = dataList;
    }



    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_data, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        holder.id.setText(dataList.get(position).getId());
        holder.name.setText(dataList.get(position).getName());
        holder.pwd.setText(dataList.get(position).getPwd());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView name, id, pwd;

        EmployeeViewHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.id);

            name = (TextView) itemView.findViewById(R.id.name);

            pwd = (TextView) itemView.findViewById(R.id.pwd);

        }
    }
}