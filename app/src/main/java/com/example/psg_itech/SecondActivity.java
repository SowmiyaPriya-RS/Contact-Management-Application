package com.example.psg_itech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity{

    private String JSON_URL1 = "http://192.168.29.221/psg/psgcontact.php";
    private String JSON_URL2 = "http://192.168.29.221/psg/psgcontact1.php";
    private String JSON_URL3 = "http://192.168.29.221/psg/psgcontact2.php";
    private String JSON_URL4 = "http://192.168.29.221/psg/psgcontact3.php";
    //private String JSON_URL;

    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<ModelClass>userList;
    private RecyclerView recyclerView;
    private Adapter myadapter;

    private String[] category;
    private String[] department;
    String depart;
    String categ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Spinner m1=(Spinner) findViewById(R.id.spinner1);
        Spinner m2=(Spinner) findViewById(R.id.spinner2);
        department=getResources().getStringArray(R.array.dept);
        category=getResources().getStringArray(R.array.cty);

        ArrayAdapter<String>myAdapter1 = new ArrayAdapter<String>(SecondActivity .this, android.R.layout.simple_list_item_1,department);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        m1.setAdapter(myAdapter1);
        ArrayAdapter<String>myAdapter2 = new ArrayAdapter<String>(SecondActivity .this, android.R.layout.simple_list_item_1,category);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        m2.setAdapter(myAdapter2);


        /*String depart = m1.getSelectedItem().toString();
        String categ = m2.getSelectedItem().toString();

        /*if(depart.equals("CSE") && categ.equals("TECHNICAL")){
            JSON_URL = "http://192.168.29.221/psg/psgcontact.php";
        }
        if(depart.equals("CSE") && categ.equals("NON-TECHNICAL")){
            JSON_URL = "http://192.168.29.221/psg/psgcontact1.php";
        }*/

        userList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        /*m1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        jsonRequest(JSON_URL1);
                        break;
                    case 1:
                        categ = m2.getSelectedItem().toString();
                        if(categ.equals("TECHNICAL")){
                            depart = department[position];
                            userList.clear();
                            myadapter.notifyDataSetChanged();
                            jsonRequest(JSON_URL1);
                            Toast.makeText(SecondActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else{
                            depart = department[position];
                            userList.clear();
                            myadapter.notifyDataSetChanged();
                            jsonRequest(JSON_URL2);
                            Toast.makeText(SecondActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                            break;
                        }
                    case 2:
                        depart = department[position];
                        userList.clear();
                        myadapter.notifyDataSetChanged();
                        jsonRequest(JSON_URL3);
                        Toast.makeText(SecondActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        depart = department[position];
                        userList.clear();
                        myadapter.notifyDataSetChanged();
                        jsonRequest(JSON_URL1);
                        Toast.makeText(SecondActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
        m2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        jsonRequest(JSON_URL1);
                        break;
                    case 1:
                        depart = m1.getSelectedItem().toString();
                        Toast.makeText(SecondActivity.this, depart, Toast.LENGTH_SHORT).show();
                        if(depart.equals("CSE")){
                            userList.clear();
                            myadapter.notifyDataSetChanged();
                            jsonRequest(JSON_URL1);
                            Toast.makeText(SecondActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if(depart.equals("ECE")){
                            userList.clear();
                            myadapter.notifyDataSetChanged();
                            jsonRequest(JSON_URL3);
                            Toast.makeText(SecondActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if(depart.equals("EEE")){
                            userList.clear();
                            myadapter.notifyDataSetChanged();
                            jsonRequest(JSON_URL1);
                            Toast.makeText(SecondActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                            break;
                        }
                    case 2:
                        depart = m1.getSelectedItem().toString();
                        Toast.makeText(SecondActivity.this, depart, Toast.LENGTH_SHORT).show();
                        if(depart.equals("CSE")){
                            userList.clear();
                            myadapter.notifyDataSetChanged();
                            jsonRequest(JSON_URL2);
                            Toast.makeText(SecondActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if(depart.equals("ECE")){
                            userList.clear();
                            myadapter.notifyDataSetChanged();
                            jsonRequest(JSON_URL4);
                            Toast.makeText(SecondActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else if(depart.equals("EEE")){
                            userList.clear();
                            myadapter.notifyDataSetChanged();
                            jsonRequest(JSON_URL2);
                            Toast.makeText(SecondActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                            break;
                        }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void jsonRequest(String JSON_URL) {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for (int i=0; i<response.length(); i++){

                    try{
                        jsonObject = response.getJSONObject(i);
                        ModelClass modelClass = new ModelClass();
                        modelClass.setImageView1(jsonObject.getString("image"));
                        modelClass.setTextview1(jsonObject.getString("name"));
                        modelClass.setTextview2(jsonObject.getString("qualification"));
                        modelClass.setTextview3(jsonObject.getString("designation"));
                        modelClass.setTextview4(jsonObject.getString("department"));
                        modelClass.setTextview5(jsonObject.getString("contact"));
                        modelClass.setTextview6(jsonObject.getString("email"));
                        userList.add(modelClass);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(userList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(SecondActivity.this);
        requestQueue.add(request);

    }

    private void setuprecyclerview(List<ModelClass> userList) {
        myadapter = new Adapter(this, userList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(myadapter);
    }
}