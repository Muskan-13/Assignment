package com.example.staticdesign;

import androidx.appcompat.app.AppCompatActivity;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> title= new ArrayList<>();
    ArrayList<String> date= new ArrayList<>();
    ArrayList<Integer> time= new ArrayList<>();
    ArrayList<String> description= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_json();
        TextView desc=(TextView)findViewById(R.id.desc0);
        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), description.get(0), Toast.LENGTH_SHORT).show();
            }
        });
        TextView desc1=(TextView)findViewById(R.id.desc1);
        desc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), description.get(1), Toast.LENGTH_SHORT).show();
            }
        });
        TextView desc2=(TextView)findViewById(R.id.desc2);
        desc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), description.get(2), Toast.LENGTH_SHORT).show();
            }
        });

        TextView t=(TextView) findViewById(R.id.title0);
        t.setText(title.get(0));
        TextView t1=(TextView) findViewById(R.id.title1);
        t1.setText(title.get(1));
        TextView t2=(TextView) findViewById(R.id.title2);
        t2.setText(title.get(2));

        TextView d=(TextView) findViewById(R.id.date0);
        d.setText(date.get(0));
        TextView d1=(TextView) findViewById(R.id.date1);
        d1.setText(date.get(1));
        TextView d2=(TextView) findViewById(R.id.date2);
        d2.setText(date.get(2));

        String txt;
        TextView tm=(TextView) findViewById(R.id.time0);
        txt=time.get(0)+" min";
        tm.setText(txt);
        TextView tm1=(TextView) findViewById(R.id.time1);
        txt=time.get(1)+" min";
        tm1.setText(txt);
        TextView tm2=(TextView) findViewById(R.id.time2);
        txt=time.get(2)+" min";
        tm2.setText(txt);

        String curDate= new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
    }

   public void get_json()
   {
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
                       title.add(obj.getString("assessment_name"));
                       date.add(obj.getString("attempt_date"));
                       time.add((obj.getInt("test_duration"))/60);
                       description.add(obj.getString("description"));
                   }
               }
           }

       } catch (IOException | JSONException e) {
           e.printStackTrace();
       }
   }


}
