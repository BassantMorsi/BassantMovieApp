package com.example.bassant.movieapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieListener {

boolean isTwoPane = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

if (savedInstanceState == null) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    GridViewFragment viewFragment = new GridViewFragment();
    //Set Activity to be a listener to the fragment
    viewFragment.setMovieListener(this);

    fragmentTransaction.add(R.id.fragment_container, viewFragment);//(id bta3 elcontainer,we el7aga elly 3ayza adefha :D )
    fragmentTransaction.commit();

    if (null != findViewById(R.id.fragmentDetails_container)) {
        isTwoPane = true;
       }
      }
    }

    @Override
    public void setSelectedMovie(Movie movie) {
        // Case One Pane
        if(!isTwoPane)
        {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("MyClass",movie);
            startActivity(intent);
        }
        else{// Case Two Pane
           DetailsFragment detailsFragment = new DetailsFragment();
            Bundle bundle = new Bundle() ;
            bundle.putSerializable("MyClass",movie);
            detailsFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentDetails_container,detailsFragment,"").commit();

        }



    }
}

