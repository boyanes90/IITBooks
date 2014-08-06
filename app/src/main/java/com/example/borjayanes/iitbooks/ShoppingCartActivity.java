package com.example.borjayanes.iitbooks;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.borjayanes.iitbooks.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends Activity {

    ListView lv2;
    Button deleteBook, proceedCheckout;
    TextView totalPrice, textShopping;
    DatabaseHandler entries;
    MyAdapter2 adapter;
    ArrayList<Book> all;
    Integer price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        deleteBook = (Button) findViewById(R.id.ButtonRemoveFromCart);
        proceedCheckout = (Button) findViewById(R.id.Button02);
        totalPrice = (TextView) findViewById(R.id.textPrice);
        textShopping = (TextView) findViewById(R.id.TextView01);

        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        textShopping.setTypeface(font);

        entries = new DatabaseHandler(ShoppingCartActivity.this);
        all = (ArrayList<Book>) entries.getAllBooks2();

        for (int i = all.size()-1; i >=0 ; i--) {
           price += all.get(i).getPrice();
        }

        totalPrice.setText("TOTAL: $" + price);

        if(all.size()>0) // check if list contains items.
        {
            lv2 = (ListView)findViewById(R.id.ListViewCatalog);
            adapter = new MyAdapter2(ShoppingCartActivity.this, R.layout.item_shopping_cart, all);
            lv2.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            lv2.setAdapter(adapter);

        }
        else
        {
            Toast.makeText(ShoppingCartActivity.this, "No items in the cart", Toast.LENGTH_SHORT).show();
        }

       deleteBook.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                for (int i = all.size()-1; i >=0 ; i--) {
                    entries.deleteBook2(all.get(i));
                    all.remove(i);
                }
                Toast.makeText(ShoppingCartActivity.this, "Cart deleted", Toast.LENGTH_SHORT).show();
                totalPrice.setText("TOTAL: $0");
                adapter.notifyDataSetChanged();
            }
        });

        proceedCheckout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent (ShoppingCartActivity.this, CheckoutActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shopping_cart, menu);
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
