package com.example.danielhwang.reference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;



import java.io.InputStream;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Adapter adapter;
    private String jsonString;
    ArrayList<GitReference> arrayList;
    private InputStream str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.totalList);
        try{
            str = getApplication().getAssets().open("gitReference.json");
            jsonString = JsonUtils.parseJsonToString(str);
            arrayList = JsonUtils.populateGitReferences(jsonString);

        }
        catch (Exception e)
        {

        }


        adapter = new Adapter(this, arrayList);
        listView.setAdapter(adapter);



    }
}
