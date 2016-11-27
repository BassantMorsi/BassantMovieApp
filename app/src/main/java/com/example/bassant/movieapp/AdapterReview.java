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
 * Created by Bassant on 11/27/2016.
 */

public class AdapterReview extends BaseAdapter {
    private Context context;
    private List<Review> reviews =null;

    public AdapterReview(Context c)
    {
       context = c ;
        reviews = new ArrayList<>();
    }

    public  void addAll (List<Review>  r )
    {
        reviews.clear();
        reviews = r;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return reviews.size();
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
        TextView textView1;
        ImageView imageView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {

            grid = inflater.inflate(R.layout.review_item, viewGroup,false);//xml file msh image by7awel xml le java code  or (R.layout.movie_item, null)

        } else {
            grid =  view;
        }
        textView = (TextView)grid.findViewById(R.id.author);
        textView1 = (TextView)grid.findViewById(R.id.content);
        textView.setText(reviews.get(i).getAuthor());
        textView1.setText(reviews.get(i).getContent());
        imageView=(ImageView)grid.findViewById(R.id.imageView99);
        imageView.setImageResource(R.drawable.user);
        return grid;
    }
}
