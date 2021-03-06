package com.example.bassant.movieapp;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ExecutionException;

/**
 * Created by Bassant on 10/25/2016.
 */

public class GridViewFragment extends android.support.v4.app.Fragment {


    DatabaseHelper db;
    ImageAdapter imageAdapter ;
    GridView gridView1  ;
    List<Movie> favoritesMovie;
    Movie fMovie;
    List<Movie> movies;//dah elly bab3toh le details activity

    private  MovieListener movieListener;
    void setMovieListener (MovieListener m)
    {
        this.movieListener = m ;
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public GridViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add this line in order for this fragment to handle menu events.

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_setting, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        if (id == R.id.top_rated) {
          if(isNetworkAvailable()){
            DownloadTask downloadTask1 = new DownloadTask() {
                @Override
                protected void onPostExecute(List<Movie> moviesDetails) {
                    super.onPostExecute(moviesDetails);
                    if (moviesDetails.isEmpty()) {
                        Toast.makeText(getContext(), "NO Internet Connection", Toast.LENGTH_LONG).show();
                    } else {
                        imageAdapter.addAll(moviesDetails);
                        gridView1.setAdapter(imageAdapter);
                        movies.clear();
                        movies.addAll(moviesDetails);
                    }

                }
            };
            downloadTask1.execute("https://api.themoviedb.org/3/movie/popular?api_key=2f763afd6d5c3ded6e3bfa5ec32e32e1");
            Toast.makeText(getContext(), "Top Rated", Toast.LENGTH_LONG).show();
            return true;
        }else {
              Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
          }
        }
        else if(id == R.id.most_popular) {

         if(isNetworkAvailable()){
            DownloadTask downloadTask2 = new DownloadTask() {
                @Override
                protected void onPostExecute(List<Movie> moviesDetails) {
                    super.onPostExecute(moviesDetails);
                    imageAdapter.addAll(moviesDetails);
                    gridView1.setAdapter(imageAdapter);
                    movies.clear();
                    movies.addAll(moviesDetails);
                }
            };
            downloadTask2.execute("https://api.themoviedb.org/3/movie/top_rated?api_key=2f763afd6d5c3ded6e3bfa5ec32e32e1");

            Toast.makeText(getContext(), "Most Popular", Toast.LENGTH_LONG).show();
            return true;
        }else
         {
             Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_LONG).show();

         }
        }
        else if(id==R.id.favorite)
        {
           //   db = new DatabaseHelper(getContext());
            favoritesMovie = new ArrayList<Movie>();
            Cursor c = db.getAllData();
            if(c.getCount()==0)
            {
                Toast.makeText(getContext(),"There Is No Favorites", Toast.LENGTH_SHORT).show();
            }
            else
            {
                while(c.moveToNext())
                {

                    fMovie = new Movie();
                    fMovie.set(c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getInt(0));
                    favoritesMovie.add(fMovie);
                }
                imageAdapter.addAll(favoritesMovie);
                gridView1.setAdapter(imageAdapter);
                movies.clear();
                movies.addAll(favoritesMovie);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.gridview_fragment, container, false);
        gridView1 = (GridView) v.findViewById(R.id.gridView1);
        imageAdapter =new ImageAdapter(v.getContext());
        movies= new ArrayList<Movie>();

        db = new DatabaseHelper(getContext());
        favoritesMovie = new ArrayList<Movie>();
        Cursor c = db.getAllData();
        if(c.getCount()==0)
        {
            Toast.makeText(getContext(),"There Is No Favorites", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(c.moveToNext())
            {

                fMovie = new Movie();
                fMovie.set(c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getInt(0));
                favoritesMovie.add(fMovie);
            }
            imageAdapter.addAll(favoritesMovie);
            gridView1.setAdapter(imageAdapter);
            movies.clear();
            movies.addAll(favoritesMovie);
        }

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                   movieListener.setSelectedMovie(movies.get(i));

            }
        });


        return v;

    }



}
