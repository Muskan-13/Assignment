package com.example.staticdesign;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<Testviewholder> {

    ArrayList<Model> data;
    public TestAdapter(ArrayList<Model> data)
    {
        this.data=data;
    }
    @NonNull
    @Override
    public Testviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.test_row,parent,false);
        return new Testviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Testviewholder holder, final int position)
    {
        holder.title.setText(data.get(position).getTitle());
        holder.date.setText(data.get(position).getDate());
        holder.time.setText(data.get(position).getTime());
        holder.desc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), data.get(position).getDesc(), Toast.LENGTH_SHORT).show();
            } });
        holder.btn.setText(data.get(position).getBtntxt());
        if((data.get(position).getBtntxt()).equals("SOLUTION"))
            holder.btn.setTextColor(Color.parseColor("#D15780"));

        }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
