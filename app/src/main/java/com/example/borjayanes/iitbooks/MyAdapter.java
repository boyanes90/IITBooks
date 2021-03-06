package com.example.borjayanes.iitbooks;

/**
 * Created by Borja Yanes on 7/14/2014.
 */
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends ArrayAdapter<Book> {
    Context context;
    int layoutResourceId;
    ArrayList<Book> itemsArrayList;

    public MyAdapter(Context context, int layoutResourceId, ArrayList<Book> itemsArrayList) {
        super(context, layoutResourceId, itemsArrayList);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        BookHolder holder;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new BookHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imageView);
            holder.txtName = (TextView)row.findViewById(R.id.name);
            holder.txtAuthor = (TextView)row.findViewById(R.id.author);

            row.setTag(holder);

        }
        else
        {
            holder = (BookHolder)row.getTag();
        }

        holder.txtName.setText(itemsArrayList.get(position).getName());
        holder.txtAuthor.setText(itemsArrayList.get(position).getAuthor());
        holder.imgIcon.setImageResource(itemsArrayList.get(position).getIcon());

        if ((position % 2) == 0) {
            row.setBackgroundColor(Color.parseColor("#15151515"));
        }

        return row;
    }

    static class BookHolder
    {
        ImageView imgIcon;
        TextView txtName;
        TextView txtAuthor;
        Button addButton;
    }
}