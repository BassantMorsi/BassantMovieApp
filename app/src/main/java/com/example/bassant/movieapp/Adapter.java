package com.example.bassant.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bassant on 11/26/2016.
 */

public class Adapter extends BaseAdapter {
    private Context context;
    private  List<String>  trailer =null;

    Adapter(Context c)
    {
        context = c;
        trailer= new ArrayList<String>();
    }

    public  void addAll (List<String> t )
    {
        trailer.clear();
        trailer=t;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return trailer.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View grid ;
        TextView textView;
        ImageView imageView;
        //LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {

        grid = inflater.inflate(R.layout.trailer_item, viewGroup,false);//xml file msh image by7awel xml le java code  or (R.layout.movie_item, null)

        } else {
        grid =  view;
        }
         textView = (TextView)grid.findViewById(R.id.trailerNum);
         imageView =(ImageView)grid.findViewById(R.id.youtube);
         textView.setText("Trailer "+(i+1));
         imageView.setImageResource(R.drawable.logo2);

        return grid;
    }
}

//if (view == null) {
//        LayoutInflater inflater = (LayoutInflater) context
//        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        grid = inflater.inflate(R.layout.trailer_item, viewGroup,false);//xml file msh image by7awel xml le java code  or (R.layout.movie_item, null)
//
//
//
//        } else {
//        grid = view;
//        }