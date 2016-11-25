package com.example.bassant.movieapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Bassant on 11/25/2016.
 */

public class DetailsFragment extends Fragment {

    private Movie m;
    DatabaseHelper db;
    public DetailsFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.details_fragment, container, false);
        db = new DatabaseHelper(getContext());

        m = new Movie();
        m = (Movie) getActivity().getIntent().getSerializableExtra("MyClass");
        Log.i("heeeeeh",m.getPoster_path());



        TextView title = (TextView)v.findViewById(R.id.original_title);
        TextView overview = (TextView)v.findViewById(R.id.overview);
        TextView date = (TextView)v.findViewById(R.id.date);
        TextView rate = (TextView)v.findViewById(R.id.rate);
        title.append(m.getOriginal_title());
        overview.append(m.getOverview());
        date.append(m.getRelease_date());
        rate.append(m.getVote_average());
        ImageView poster =(ImageView)v.findViewById(R.id.imageView3) ;
        Picasso.with(v.getContext()).load(m.getPoster_path()).into(poster);


        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean r =db.insertData(m.getPoster_path(),m.getOriginal_title(),m.getOverview(),m.getMid(),m.getRelease_date(),m.getVote_average());

                if(r==true){
                    Snackbar.make(view, "Success", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else {
                    Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });


        return v;
    }
}
