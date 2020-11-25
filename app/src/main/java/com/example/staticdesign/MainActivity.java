package com.example.staticdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new TestAdapter(get_json());
        recyclerView.setAdapter(adapter);
    }

   public ArrayList<Model> get_json()
   {
       ArrayList<Model> holder= new ArrayList<>();
       String json=null;
       try {
           InputStream inp= getAssets().open("data.json");
           int size=inp.available();
           byte[] buffer= new byte[size];
           inp.read(buffer);
           inp.close();

           json=new String(buffer,"UTF-8");
           JSONArray jsonArray=new JSONArray(json);
           if(jsonArray!=null) {
               for (int i = 0; i < jsonArray.length(); i++) {
                   JSONObject obj = jsonArray.getJSONObject(i);
                   if (obj != null) {
                       String t=obj.getString("assessment_name");
                       String dt=obj.getString("attempt_date");
                       String tm=((obj.getInt("test_duration"))/60)+" min";
                       String ds=obj.getString("description");
                       Calendar c=Calendar.getInstance();
                       SimpleDateFormat sdf=new SimpleDateFormat("MMM dd, yyyy");
                       String cDate=sdf.format(c.getTime());
                       Date curDate=sdf.parse(cDate);
                       Date rDate= sdf.parse(dt);
                       String btn="";
                       if(curDate.compareTo(rDate)>= 0)
                       {
                           btn+="SOLUTION";
                       }
                       else
                       {
                           btn+="START";
                       }
                       Model object=new Model(t,dt,tm,ds,btn);
                       object.setTitle(t);
                       object.setDate(dt);
                       object.setTime(tm);
                       object.setDesc(ds);
                       object.setBtntxt(btn);
                       holder.add(object);
                   }
               }
           }

       } catch (IOException | JSONException | ParseException e) {
           e.printStackTrace();
       }
       return holder;
   }


}
