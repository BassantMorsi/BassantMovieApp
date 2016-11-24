package com.example.bassant.movieapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bassant on 10/21/2016.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private  List<String> poster =null;
    //  List<Movie> Mp;

    public ImageAdapter(Context c) {
        mContext = c;
        poster = new ArrayList<String>();

    }



    public  void addAll (List<Movie> p )
    {
        poster.clear();
        for (int i = 0; i < p.size(); i++) {
           // Log.i("**************", p.get(i).getPoster_path());
            poster.add(p.get(i).getPoster_path());
           // Log.i("&&&&&&&&&&&7", poster.get(i));

        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return poster.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        ImageView imageView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.movie_item, parent,false);//xml file msh image by7awel xml le java code  or (R.layout.movie_item, null)



        } else {
            grid = convertView;
        }
        imageView = (ImageView)grid.findViewById(R.id.movieItem);
        Picasso.with(mContext).load(poster.get(position)).into(imageView);//placeholder().error()
        // notifyDataSetChanged(); hena elsater dah 3amal moshkela lama 7atetoh hena kan fe error fe elscrolling
        return grid;
    }
}
