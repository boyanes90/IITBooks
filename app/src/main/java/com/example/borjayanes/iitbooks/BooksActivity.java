package com.example.borjayanes.iitbooks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;


import java.util.List;

public class BooksActivity extends Activity {

    ListView lv;
    String sessionTerm;
    String sessionDepartment;
    String sessionCourse;
    Button continue_shopping, checkout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        continue_shopping = (Button) findViewById(R.id.button2);
        checkout = (Button) findViewById(R.id.imageButton);

        Bundle extras = getIntent().getExtras();
        sessionTerm = extras.getString("sessionTerm");
        sessionDepartment = extras.getString("sessionDepartment");
        sessionCourse = extras.getString("sessionCourse");

        DatabaseHandler entry = new DatabaseHandler(BooksActivity.this);

        ArrayList<Book> all = entry.getCourseBooks(sessionTerm, sessionDepartment, sessionCourse);
        if(all.size()>0) // check if list contains items.
        {
            lv = (ListView)findViewById(R.id.listView);
            MyAdapter adapter = new MyAdapter(BooksActivity.this, R.layout.list_entry_layout, all);
            lv.setAdapter(adapter);

            lv.setOnItemClickListener( new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {
                    Intent myIntent = new Intent(BooksActivity.this, BookDetailsActivity.class);
                    Book myBook = (Book) lv.getItemAtPosition(position);
                    myIntent.putExtra("SessionBook", myBook);

                    startActivity(myIntent);
                }
            });

        }
        else
        {
            Toast.makeText(BooksActivity.this, "No available materials for this course", Toast.LENGTH_SHORT).show();
        }

        continue_shopping.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //retrocede
                finish();
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //retrocede
                Intent i = new Intent(BooksActivity.this, ShoppingCartActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.books, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
