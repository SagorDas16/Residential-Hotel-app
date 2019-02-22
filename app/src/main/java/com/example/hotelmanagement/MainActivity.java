package com.example.hotelmanagement;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listviewId);
        searchView = findViewById(R.id.searchviewId);

        final String[] districtNames = getResources().getStringArray(R.array.district_name);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.district_view,R.id.districtviewId,districtNames);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = adapter.getItem(position);
                if(value.equals("Bagerhat")) {
                    intent = new Intent(MainActivity.this,JashoreActivity.class);
                    startActivity(intent);
                }
                if(value.equals("Dhaka")) {
                    intent = new Intent(MainActivity.this,JashoreActivity.class);
                    startActivity(intent);
                }
                if(value.equals("Jashore")) {
                    intent = new Intent(MainActivity.this,JashoreActivity.class);
                    startActivity(intent);
                }
                if(value.equals("Khulna")) {
                    intent = new Intent(MainActivity.this,JashoreActivity.class);
                    startActivity(intent);
                }
                if(value.equals("Kushtia")) {
                    intent = new Intent(MainActivity.this,JashoreActivity.class);
                    startActivity(intent);
                }
                if(value.equals("Satkhira")) {
                    intent = new Intent(MainActivity.this,JashoreActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
