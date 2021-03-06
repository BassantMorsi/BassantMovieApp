package com.example.bassant.movieapp;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bassant on 10/21/2016.
 */

public class DownloadTask extends AsyncTask<String,Void,List<Movie>>{
    @Override
    protected List<Movie> doInBackground(String ... urls) {
        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;
        List<Movie> moviesDetails = new ArrayList<Movie>();
        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();
            while (data != -1) {
                char current = (char) data;
                result += current;
                data = reader.read();
            }
            try {
                JSONObject jsonObject = new JSONObject(result);
                String r = jsonObject.getString("results");
                JSONArray arr = new JSONArray(r);
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject listObject = arr.getJSONObject(i);
                    String str = listObject.getString("poster_path");
                    String str1 = listObject.getString("overview");
                    String str2 = listObject.getString("original_title");
                    String str3 = listObject.getString("release_date");//date
                    String str4 = listObject.getString("vote_average");//vote
                    int str5 = listObject.getInt("id");


                    Movie movieD = new Movie();
                    movieD.set("http://image.tmdb.org/t/p/w185/" + str, str2, str1, str3, str4, str5);
                    moviesDetails.add(movieD);

                    //poster.add("http://image.tmdb.org/t/p/w185/"+str);
                    //Log.i("poster",listObject.getString("poster_path"));
                    // Log.i("movieDetails",moviesDetails.get(2).getOriginal_title());
                }
                //  Log.i("poster item2",poster.get(2)) ;
                Log.i("movieDetails", moviesDetails.get(2).getOriginal_title());
                Log.i("movieDetails", moviesDetails.get(5).getOriginal_title());

                //Log.i("list",jsonObject.getString("list"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return moviesDetails;
        } catch (MalformedURLException e) {  //hena

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }


            return null;
    }

}

