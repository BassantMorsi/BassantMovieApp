package com.example.bassant.movieapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutionException;



/*class DataBase extends AsyncTask<Movie,Void,String>
{
    @Override
    protected String doInBackground(final Movie... movies) {
        final String[] flag = new String[1];
        Realm realm = Realm.getDefaultInstance();
        try {
            // ... Use the Realm instance ...
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm bgRealm) {
                    MovieDB user = bgRealm.createObject(MovieDB.class);
                    user.setPoster_path(movies[0].getPoster_path());
                    user.setOriginal_title(movies[0].getOriginal_title());
                    user.setOverview(movies[0].getOverview());

                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    // Transaction was a success.
                       flag[0] ="true";

                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(Throwable error) {
                    // Transaction failed and was automatically canceled.
                    flag[0] ="false";

                }
            });

        } finally {
            realm.close();
        }



        return flag[0];
    }
}*/


public class Main2Activity extends AppCompatActivity {

    //private Realm realm;
    private Movie m;
    DatabaseHelper db;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = new DatabaseHelper(this);
       // realm = Realm.getDefaultInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        m = new Movie();
        m = (Movie) getIntent().getSerializableExtra("MyClass");
        Log.i("heeeeeh",m.getPoster_path());



        TextView title = (TextView)findViewById(R.id.original_title);
        TextView overview = (TextView)findViewById(R.id.overview);
        title.append(m.getOriginal_title());
        overview.append(m.getOverview());
        ImageView poster =(ImageView)findViewById(R.id.imageView3) ;
        Picasso.with(getApplicationContext()).load(m.getPoster_path()).into(poster);

        //realm = Realm.getDefaultInstance();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }
    /*private void save_into_database(final Movie movie, final View view){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                MovieDB user = bgRealm.createObject(MovieDB.class);
                user.setPoster_path(movie.getPoster_path());
                user.setOriginal_title(movie.getOriginal_title());
                user.setOverview(movie.getOverview());

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.

                Snackbar.make(view, "Saved To Favorites", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }*/


 /*   @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }*/
}
