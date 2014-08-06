package com.example.borjayanes.iitbooks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Borja Yanes on 7/12/2014.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
        // All Static variables
        // Database Version
        private static final int DATABASE_VERSION = 95;

    // Database Name
    private static final String DATABASE_NAME = "booksManager2";

    // Books table name
    private static final String TABLE_BOOKS = "books";
    private static final String TABLE_BOOKS2 = "books2";

    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_TERM = "term";
    private static final String KEY_DEPARTMENT = "department";
    private static final String KEY_COURSE = "course";
    private static final String KEY_ICON = "icon";
    private static final String KEY_ICON2 = "icon2";
    private static final String KEY_PRICE = "price";
    private static final String KEY_DESCRIPTION = "description";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BOOKS_TABLE = "CREATE TABLE " + TABLE_BOOKS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_AUTHOR + " TEXT," + KEY_TERM + " TEXT," + KEY_DEPARTMENT
                + " TEXT," + KEY_COURSE + " TEXT," + KEY_ICON + " INTEGER," +
                KEY_ICON2 + " INTEGER," + KEY_PRICE + " INTEGER," + KEY_DESCRIPTION + " TEXT" + ");";

        String CREATE_BOOKS_TABLE2 = "CREATE TABLE " + TABLE_BOOKS2 + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_AUTHOR + " TEXT," + KEY_TERM + " TEXT," + KEY_DEPARTMENT
                + " TEXT," + KEY_COURSE + " TEXT," + KEY_ICON + " INTEGER," +
                KEY_ICON2 + " INTEGER," + KEY_PRICE + " INTEGER," + KEY_DESCRIPTION + " TEXT" + ");";

        db.execSQL(CREATE_BOOKS_TABLE);
        db.execSQL(CREATE_BOOKS_TABLE2);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS2);

        // Create tables again
        onCreate(db);
    }

    // Adding new book
    public void addBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, book.getName()); // Book Name
        values.put(KEY_AUTHOR, book.getAuthor()); // Book Author
        values.put(KEY_TERM, book.getTerm()); // Book Term
        values.put(KEY_DEPARTMENT, book.getDepartment()); // Book Department
        values.put(KEY_COURSE, book.getCourse()); // Book Course
        values.put(KEY_ICON, book.getIcon()); // Book Icon
        values.put(KEY_ICON2, book.getIcon2()); // Book Icon2
        values.put(KEY_PRICE, book.getPrice()); // Book Price
        values.put(KEY_DESCRIPTION, book.getDescription()); // Book Description

        // Inserting Row
        db.insert(TABLE_BOOKS, null, values);
        db.close(); // Closing database connection
    }

    // Adding new book
    public void addBook2(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, book.getName()); // Book Name
        values.put(KEY_AUTHOR, book.getAuthor()); // Book Author
        values.put(KEY_TERM, book.getTerm()); // Book Term
        values.put(KEY_DEPARTMENT, book.getDepartment()); // Book Department
        values.put(KEY_COURSE, book.getCourse()); // Book Course
        values.put(KEY_ICON, book.getIcon()); // Book Icon
        values.put(KEY_ICON2, book.getIcon2()); // Book Icon2
        values.put(KEY_PRICE, book.getPrice()); // Book Price
        values.put(KEY_DESCRIPTION, book.getDescription()); // Book Description

        // Inserting Row
        db.insert(TABLE_BOOKS2, null, values);
        db.close(); // Closing database connection
    }

    // Getting single book
    public Book getBook(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BOOKS, new String[] { KEY_ID,
                        KEY_NAME, KEY_AUTHOR, KEY_TERM, KEY_DEPARTMENT, KEY_COURSE, KEY_ICON,
                        KEY_ICON2, KEY_PRICE, KEY_DESCRIPTION }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Book book = new Book(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getString(5), Integer.parseInt(cursor.getString(6)),
                Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)),
                cursor.getString(9));
        // return book
        return book;
    }

    // Getting All Books
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<Book>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BOOKS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setID(Integer.parseInt(cursor.getString(0)));
                book.setName(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                book.setTerm(cursor.getString(3));
                book.setDepartment(cursor.getString(4));
                book.setCourse(cursor.getString(5));
                book.setIcon(Integer.parseInt(cursor.getString(6)));
                book.setIcon2(Integer.parseInt(cursor.getString(7)));
                book.setPrice(Integer.parseInt(cursor.getString(8)));
                book.setDescription(cursor.getString(9));

                // Adding book to list
                bookList.add(book);
            } while (cursor.moveToNext());
        }

        // return book list
        return bookList;
    }

    public List<Book> getAllBooks2() {
        List<Book> bookList = new ArrayList<Book>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BOOKS2;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setID(Integer.parseInt(cursor.getString(0)));
                book.setName(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                book.setTerm(cursor.getString(3));
                book.setDepartment(cursor.getString(4));
                book.setCourse(cursor.getString(5));
                book.setIcon(Integer.parseInt(cursor.getString(6)));
                book.setIcon2(Integer.parseInt(cursor.getString(7)));
                book.setPrice(Integer.parseInt(cursor.getString(8)));
                book.setDescription(cursor.getString(9));
                // Adding book to list
                bookList.add(book);
            } while (cursor.moveToNext());
        }

        // return book list
        return bookList;
    }

    // Getting Books for a course
    public ArrayList<Book> getCourseBooks(String term_typed, String department_typed,
                                     String course_typed) {
        ArrayList<Book> bookList = new ArrayList<Book>();
        // Select Books Query
        String selectQuery = "SELECT * FROM " + TABLE_BOOKS + " WHERE " + KEY_TERM + " LIKE '"
                + term_typed + "' AND " + KEY_DEPARTMENT + " LIKE '" + department_typed + "' AND "
                + KEY_COURSE + " LIKE '" + course_typed + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setID(Integer.parseInt(cursor.getString(0)));
                book.setName(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                book.setTerm(cursor.getString(3));
                book.setDepartment(cursor.getString(4));
                book.setCourse(cursor.getString(5));
                book.setIcon(Integer.parseInt(cursor.getString(6)));
                book.setIcon2(Integer.parseInt(cursor.getString(7)));
                book.setPrice(Integer.parseInt(cursor.getString(8)));
                book.setDescription(cursor.getString(9));
                // Adding book to list
                bookList.add(book);
            } while (cursor.moveToNext());
        }

        // return book list
        return bookList;
    }

    // Getting books Count
    public int getBooksCount() {
        String countQuery = "SELECT  * FROM " + TABLE_BOOKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Getting books Count
    public int getBooksCount2() {
        String countQuery = "SELECT  * FROM " + TABLE_BOOKS2;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single book
    public int updateBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, book.getName());
        values.put(KEY_AUTHOR, book.getAuthor());
        values.put(KEY_TERM, book.getTerm());
        values.put(KEY_DEPARTMENT, book.getDepartment());
        values.put(KEY_COURSE, book.getCourse());
        values.put(KEY_ICON, book.getIcon());
        values.put(KEY_ICON2, book.getIcon2());
        values.put(KEY_PRICE, book.getPrice());
        values.put(KEY_DESCRIPTION, book.getDescription());
        // updating row
        return db.update(TABLE_BOOKS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(book.getID()) });
    }

    // Deleting single book
    public void deleteBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOKS, KEY_ID + " = ?",
                new String[] { String.valueOf(book.getID()) });
        db.close();
    }

    // Deleting single book
    public void deleteBook2(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOKS2, KEY_ID + " = ?",
                new String[] { String.valueOf(book.getID()) });
        db.close();
    }
}