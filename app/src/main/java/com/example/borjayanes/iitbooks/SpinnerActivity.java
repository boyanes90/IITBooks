package com.example.borjayanes.iitbooks;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;



import java.util.List;


public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner spinner, spinner2, spinner3;
    String user;
    TextView txt_usr, txt_term, txt_dept, txt_course;
    Button logoff, find_materials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_activity);

        txt_usr= (TextView) findViewById(R.id.usr_name);
        txt_term= (TextView) findViewById(R.id.textView);
        txt_dept= (TextView) findViewById(R.id.textView2);
        txt_course= (TextView) findViewById(R.id.textView3);
        logoff= (Button) findViewById(R.id.logoff);
        find_materials = (Button) findViewById(R.id.button);

        Bundle extras = getIntent().getExtras();
        //Obtenemos datos enviados en el intent.
        if (extras != null) {
            user  = "Welcome " + extras.getString("user");//usuario
        } else {
            user = "Welcome borja";
        }

        txt_usr.setText(user);//cambiamos texto al nombre del usuario logueado
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        txt_usr.setTypeface(font);
        txt_term.setTypeface(font2);
        txt_dept.setTypeface(font2);
        txt_course.setTypeface(font2);


        spinner = (Spinner)findViewById(R.id.spinner);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);

        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.term_array, R.layout.spinnertext);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.department_array, R.layout.spinnertext);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Books
        Log.d("Insert: ", "Inserting ..");
        db.addBook(new Book("DEFINITIVE GUIDE TO GRAILS 2", "BROWN", "Fall 2014", "ITMD", "562", R.drawable.book2, R.drawable.book2g, 25, "Grails is a full stack framework which aims to greatly simplify the task of building serious web applications for the JVM. The concepts within Grails, like interceptors, tag libs, and Groovy Server Pages (GSP), make those in the Java community feel right at home. Grails foundation is on solid open source technologies such as Spring, Hibernate, and SiteMesh, which gives it even more potential in the Java space: Spring provides powerful inversion of control and MVC, Hibernate brings a stable, mature object relational mapping technology with the ability to integrate with legacy systems, and SiteMesh handles flexible layout control and page decoration.Grails complements these with additional features that take advantage of the coding–by–convention paradigm such as dynamic tag libraries, Grails object relational mapping, Groovy Server Pages, and scaffolding. Graeme Rocher, Grails lead and founder, and Jeff Brown bring you completely up–to–date with their authoritative and fully comprehensive guide to the Grails 2 framework. You’ll get to know all the core features, services, and Grails extensions via plug–ins, and understand the roles that Groovy and Grails are playing in the changing Web."));
        db.addBook(new Book("PHP+MYSQL F/DYNAMIC WEB SITES", "ULLMAN", "Fall 2014", "ITMD", "562", R.drawable.book1, R.drawable.book1g, 20, "It hasn't taken Web developers long to discover that when it comes to creating dynamic, database-driven Web sites, MySQL and PHP provide a winning open-source combination. Add this book to the mix, and there's no limit to the powerful, interactive Web sites that developers can create. With step-by-step instructions, complete scripts, and expert tips to guide readers, veteran author and database designer Larry Ullman gets right down to business: After grounding readers with separate discussions of first the scripting language (PHP) and then the database program (MySQL), he goes on to cover security, sessions and cookies, and using additional Web tools, with several sections devoted to creating sample applications. This guide is indispensable for beginning to intermediate level Web designers who want to replace their static sites with something dynamic. In this edition, the bulk of the new material covers the latest features and techniques with PHP and MySQL. Also new to this edition are chapters introducing jQuery and object-oriented programming techniques."));
        db.addBook(new Book("DATA COMMUNICATIONS + NETWORKING", "FOROUZAN","Fall 2014", "ITMO", "540", R.drawable.book3, R.drawable.book3g, 22, "As one of the fastest growing technologies in our culture today, data communications and networking presents a unique challenge for instructors. As both the number and types of students are increasing, it is essential to have a textbook that provides coverage of the latest advances, while presenting the material in a way that is accessible to students with little or no background in the field. Using a bottom-up approach, Data Communications and Networking presents this highly technical subject matter without relying on complex formulas by using a strong pedagogical approach supported by more than 700 figures. Now in its Fourth Edition, this textbook brings the beginning student right to the forefront of the latest advances in the field, while presenting the fundamentals in a clear, straightforward manner. Students will find better coverage, improved figures and better explanations on cutting-edge material. The \"bottom-up\" approach allows instructors to cover the material in one course, rather than having separate courses on data communications and networking."));
        db.addBook(new Book("INTRO.TO JAVA PROGRAMING", "LIANG","Summer 2014", "ITM", "311", R.drawable.book4, R.drawable.book4g, 18, "Introduction to Java Programming, Comprehensive, 9e, features comprehensive coverage ideal for a one-, two-, or three-semester CS1 course sequence. Daniel Liang teaches concepts of problem-solving and object-oriented programming using a fundamentals-first approach. Beginning programmers learn critical problem-solving techniques then move on to grasp the key concepts of object-oriented, GUI programming, advanced GUI and Web programming using Java. "));
        db.addBook(new Book("A+ GUIDE TO MANAGING+MAINT....-LAB MAN.", "ANDREWS","Summer 2014", "ITM", "301", R.drawable.book5, R.drawable.book5g, 30, "This step-by-step, highly visual text provides a comprehensive introduction to managing and maintaining computer hardware and software. Written by best-selling author and educator Jean Andrews, A+ GUIDE TO MANAGING AND MAINTAINING YOUR PC closely integrates the CompTIAA+ Exam objectives to prepare you for the 220-801 and 220-802 certification exams. The new Eighth Edition also features extensive updates to reflect current technology, techniques, and industry standards in the dynamic, fast-paced field of PC repair. Each chapter covers both core concepts and advanced topics, organizing material to facilitate practical application and encourage you to learn by doing. Supported by a wide range of supplemental resources to enhance learning--including innovative tools, interactive exercises and activities, and online study guides--this proven text offers an ideal way to prepare you for success as a professional PC repair technician."));
        db.addBook(new Book("ADVENTURES OF A IT LEADER", "AUSTIN","Summer 2014", "ITM", "301", R.drawable.book6, R.drawable.book6g, 32, "Becoming an effective IT manager presents a host of challenges--from anticipating emerging technology to managing relationships with vendors, employees, and other managers. A good IT manager must also be a strong business leader. This book invites you to accompany new CIO Jim Barton to better understand the role of IT in your organization. You'll see Jim struggle through a challenging first year, handling (and fumbling) situations that, although fictional, are based on true events. You can read this book from beginning to end, or treat is as a series of cases. You can also skip around to address your most pressing needs. For example, need to learn about crisis management and security? Read chapters 10-12. You can formulate your own responses to a CIO's obstacles by reading the authors' regular \"Reflection\" questions. You'll turn to this book many times as you face IT-related issues in your own career."));

        // Reading all books
        Log.d("Reading: ", "Reading all books..");
        List<Book> books = db.getAllBooks();
        for (Book b : books) {
            String log = "Id: " + b.getID() + " ,Name: " + b.getName() + " ,Author: " +
                    b.getAuthor() +  " ,Term: " + b.getTerm()
                    + " ,Department: " + b.getDepartment() + " ,Course: " + b.getCourse() +
                    " ,Icon: " + b.getIcon() + " ,Icon2: " + b.getIcon2() + " ,Price: " + b.getPrice();
            // Writing Books to log
            Log.d("Name: ", log);
        }

        logoff.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                //'cerrar  sesion' nos regresa a la ventana anterior.
                finish();
            }
        });

        find_materials.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                //encuentra libros para el curso
                Intent i=new Intent(SpinnerActivity.this, BooksActivity.class);
                i.putExtra("sessionTerm", String.valueOf(spinner.getSelectedItem()));
                i.putExtra("sessionDepartment", String.valueOf(spinner2.getSelectedItem()));
                i.putExtra("sessionCourse", String.valueOf(spinner3.getSelectedItem()));
                startActivity(i);
            }
        });

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        if(spinner.getSelectedItem().equals("Fall 2014"))
        {
            if(spinner2.getSelectedItem().equals("ITM")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.fall_itm_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);

            }
            else if(spinner2.getSelectedItem().equals("ITMD")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.fall_itmd_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
            else if(spinner2.getSelectedItem().equals("ITMM")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.fall_itmm_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
            else if(spinner2.getSelectedItem().equals("ITMO")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.fall_itmo_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
            else if(spinner2.getSelectedItem().equals("ITMS")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.fall_itms_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
            else if(spinner2.getSelectedItem().equals("ITMT")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.fall_itmt_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
        }
        else if(spinner.getSelectedItem().equals("Summer 2014"))
        {
            if(spinner2.getSelectedItem().equals("ITM")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.summer_itm_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
            else if(spinner2.getSelectedItem().equals("ITMD")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.summer_itmd_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
            else if(spinner2.getSelectedItem().equals("ITMM")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.summer_itmm_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
            else if(spinner2.getSelectedItem().equals("ITMO")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.summer_itmo_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
            else if(spinner2.getSelectedItem().equals("ITMS")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.summer_itms_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
            else if(spinner2.getSelectedItem().equals("ITMT")) {
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                        R.array.summer_itmt_array, R.layout.spinnertext);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.notifyDataSetChanged();
                spinner3.setAdapter(adapter3);
            }
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
