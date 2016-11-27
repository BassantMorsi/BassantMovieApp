package com.example.bassant.movieapp;

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DownloadTrailer downloadTrailer =new DownloadTrailer(){
            @Override
            protected void onPostExecute(List<String> strings) {
                super.onPostExecute(strings);
                Log.i("beeeeb",strings.get(2));
            }
        };
        downloadTrailer.execute("https://api.themoviedb.org/3/movie/278/videos?api_key=2f763afd6d5c3ded6e3bfa5ec32e32e1");

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             DetailsFragment detailsFragment =new DetailsFragment();
            fragmentTransaction.add(R.id.fragmentDetails_container, detailsFragment);//(id bta3 elcontainer,we el7aga elly 3ayza adefha :D )
            fragmentTransaction.commit();
        }



    }

}
