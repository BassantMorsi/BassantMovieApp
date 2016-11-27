package com.example.bassant.movieapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bassant on 11/25/2016.
 */

public class DetailsFragment extends Fragment {

    private Movie m;
    DatabaseHelper db;
    GridView gridView2 ;
    Adapter adapter;
    List<String> youtubeLinks ;

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
        rate.append(m.getVote_average()+"/10");
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

        gridView2 = (GridView)v.findViewById(R.id.gridView2);
        adapter =new Adapter(v.getContext());
        youtubeLinks = new ArrayList<String>();
        DownloadTrailer downloadTrailer =new DownloadTrailer(){
            @Override
            protected void onPostExecute(List<String> strings) {
                super.onPostExecute(strings);
                youtubeLinks = strings;
                adapter.addAll(strings);
                gridView2.setAdapter(adapter);
            }
        };
        downloadTrailer.execute("https://api.themoviedb.org/3/movie/"+m.getMid()+"/videos?api_key=2f763afd6d5c3ded6e3bfa5ec32e32e1");

        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLinks.get(i)));
                Toast.makeText(v.getContext(), " hhhhhhhhhhh", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });


        return v;
    }
}
