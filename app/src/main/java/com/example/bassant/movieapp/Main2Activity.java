package com.example.bassant.movieapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.ExecutionException;



public class Main2Activity extends AppCompatActivity  {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //test

        DownloadTrailer downloadTrailer =new DownloadTrailer(){
            @Override
            protected void onPostExecute(List<String> strings) {
                super.onPostExecute(strings);
                Log.i("beeeeb",strings.get(2));
            }
        };
        downloadTrailer.execute("https://api.themoviedb.org/3/movie/278/videos?api_key=2f763afd6d5c3ded6e3bfa5ec32e32e1");
        //test
        DownloadReview downloadReview = new DownloadReview(){
            @Override
            protected void onPostExecute(List<Review> reviews) {
                super.onPostExecute(reviews);
                Log.i("teeeet",reviews.get(1).getAuthor());
            }
        };
        downloadReview.execute("https://api.themoviedb.org/3/movie/278/reviews?api_key=2f763afd6d5c3ded6e3bfa5ec32e32e1");



        if (savedInstanceState == null) {
            Intent sentIntent = getIntent();
            Bundle sentBundle = sentIntent.getExtras();


            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             DetailsFragment detailsFragment =new DetailsFragment();
            detailsFragment.setArguments(sentBundle);

            fragmentTransaction.add(R.id.fragmentDetails_container, detailsFragment);//(id bta3 elcontainer,we el7aga elly 3ayza adefha :D )
            fragmentTransaction.commit();
        }



    }

}
