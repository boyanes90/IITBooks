/**
 * Created by Borja Yanes on 7/12/2014.
 */
package com.example.borjayanes.iitbooks;

import java.io.Serializable;

public class Book implements Serializable {
    //private variables
    int _id;
    int _icon;
    int _icon2;
    int _price;
    String _name;
    String _author;
    String _term;
    String _department;
    String _course;
    String _description;



    // Empty constructor
    public Book(){

    }
    // constructor
    public Book(int id, String name, String author, String term, String department, String course
    , int icon, int icon2, int price, String description){
        this._id = id;
        this._name = name;
        this._author = author;
        this._term = term;
        this._department = department;
        this._course = course;
        this._icon = icon;
        this._icon2 = icon2;
        this._price = price;
        this._description = description;
    }

    // constructor
    public Book(String name, String author, String term, String department, String course
    , int icon, int icon2, int price, String description){
        this._name = name;
        this._author = author;
        this._term = term;
        this._department = department;
        this._course = course;
        this._icon = icon;
        this._icon2 = icon2;
        this._price = price;
        this._description = description;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting author
    public String getAuthor(){
        return this._author;
    }

    // setting author
    public void setAuthor(String author){
        this._author = author;
    }

    // getting term
    public String getTerm(){
        return this._term;
    }

    // setting term
    public void setTerm(String term){
        this._term = term;
    }

    // getting department
    public String getDepartment(){
        return this._department;
    }

    // setting department
    public void setDepartment(String department){
        this._department = department;
    }

    // getting course
    public String getCourse(){
        return this._course;
    }

    // setting course
    public void setCourse(String course){
        this._course = course;
    }

    // getting icon
    public int getIcon(){
        return this._icon;
    }

    // setting icon
    public void setIcon(int icon){
        this._icon = icon;
    }

    // getting icon
    public int getIcon2(){
        return this._icon2;
    }

    // setting icon
    public void setIcon2(int icon2){
        this._icon2 = icon2;
    }

    // getting price
    public int getPrice(){
        return this._price;
    }

    // setting price
    public void setPrice(int price){
        this._price = price;
    }

    // getting name
    public String getDescription(){
        return this._description;
    }

    // setting name
    public void setDescription(String description){
        this._description = description;
    }

    @Override
    public String toString() {

        return "Name: " + _name + " Author: " + _author + " Icon: " + _icon;
    }
}
