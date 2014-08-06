package com.example.borjayanes.iitbooks;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.borjayanes.iitbooks.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BookDetailsActivity extends Activity {

    ImageView iconDetails;
    TextView nameDetails, authorDetails, priceDetails, descriptionDetails;
    Integer sessionImage;
    String sessionName;
    String sessionAuthor;
    String sessionDescription;
    Integer sessionPrice;
    Button addCart, continueShopping;
    DatabaseHandler db;
    Book book;
    ArrayList<Book> bookInCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        iconDetails = (ImageView) findViewById(R.id.iconDetails);
        nameDetails = (TextView) findViewById(R.id.nameDetails);
        authorDetails = (TextView) findViewById(R.id.authorDetails);
        descriptionDetails = (TextView) findViewById(R.id.textDescription);
        priceDetails = (TextView) findViewById(R.id.textPrice);
        addCart = (Button) findViewById(R.id.addCart);
        continueShopping = (Button) findViewById(R.id.continueShopping);

        Intent i = getIntent();
        book = (Book)i.getSerializableExtra("SessionBook");

        sessionImage = book.getIcon2();
        sessionName = book.getName();
        sessionAuthor = book.getAuthor();
        sessionPrice = book.getPrice();
        sessionDescription = book.getDescription();

        iconDetails.setImageResource(sessionImage);
        nameDetails.setText(sessionName);
        authorDetails.setText(sessionAuthor);
        priceDetails.setText("Price: $" + sessionPrice);
        descriptionDetails.setText(sessionDescription);

        db = new DatabaseHandler(this);
        bookInCart = new ArrayList<Book>();


        addCart.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                Toast.makeText(BookDetailsActivity.this, "+1 Item added", Toast.LENGTH_SHORT).show();
                db.addBook2(book);
                //bookInCart.add(book);
                List<Book> books = db.getAllBooks2();
                for (Book b : books) {
                    String log = "Id: " + b.getID() + " ,Name: " + b.getName() + " ,Author: " +
                            b.getAuthor() +  " ,Term: " + b.getTerm()
                            + " ,Department: " + b.getDepartment() + " ,Course: " + b.getCourse() +
                            " ,Icon: " + b.getIcon();
                    // Writing Books to log
                    Log.d("Name: ", log);
                }
            }
        });

        continueShopping.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.book_details, menu);
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
