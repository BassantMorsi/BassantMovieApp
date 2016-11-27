package com.example.bassant.movieapp;

import android.os.AsyncTask;
import android.util.Log;

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
 * Created by Bassant on 11/25/2016.
 */

public class DownloadTrailer extends AsyncTask<String,Void,List<String>>{

    @Override
    protected List<String> doInBackground(String... urls) {
        String result = "";
        URL url ;
        HttpURLConnection urlConnection = null;
        List<String> key = new ArrayList<String>();
        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();
            while(data != -1)
            {
                char current = (char)data ;
                result += current;
                data = reader.read();
            }
            try {
                JSONObject jsonObject = new JSONObject(result);
                String r = jsonObject.getString("results");
                JSONArray arr =new JSONArray(r);
                for(int i=0 ;i<arr.length();i++)
                {
                    JSONObject listObject = arr.getJSONObject(i);
                    String str =listObject.getString("key");
                    String trailerUrl = "https://www.youtube.com/watch?v="+str;
                    key.add(trailerUrl);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return key;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
