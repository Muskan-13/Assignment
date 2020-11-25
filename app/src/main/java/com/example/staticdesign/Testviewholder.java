package com.example.staticdesign;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Testviewholder extends RecyclerView.ViewHolder {
    TextView title,date,time,desc;
    Button btn;
    public Testviewholder(@NonNull View itemView) {
        super(itemView);
        title=(TextView)itemView.findViewById(R.id.title);
        date=(TextView)itemView.findViewById(R.id.date);
        time=(TextView)itemView.findViewById(R.id.time);
        desc=(TextView)itemView.findViewById(R.id.desc);
        btn=(Button)itemView.findViewById(R.id.start);
    }
}
