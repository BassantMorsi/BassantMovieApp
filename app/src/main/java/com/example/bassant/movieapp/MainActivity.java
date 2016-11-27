package com.example.bassant.movieapp;

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

public class MainActivity extends AppCompatActivity {
    DownloadTask task;

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
    fragmentTransaction.add(R.id.fragment_container, viewFragment);//(id bta3 elcontainer,we el7aga elly 3ayza adefha :D )
    fragmentTransaction.commit();
}
      //  GridView gView =(GridView)findViewById(R.id.gridView1);
     //   DownloadTask downloadTask = new DownloadTask(gView,this);//this = activity context =  getApplicationContext()
      // downloadTask.execute("https://api.themoviedb.org/3/movie/top_rated?api_key=2f763afd6d5c3ded6e3bfa5ec32e32e1");

    }
    //*****************SETTING*********************




    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.top_rated) {
            Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
   /*public class DownloadTask extends AsyncTask<String,Void,String>
    {
        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url ;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data != -1)
                {
                    char current = (char)data ;
                    result += current;
                    data = reader.read();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject jsonObject = new JSONObject(result);
               JSONArray arr = new JSONArray(jsonObject.getString("list"));
                for(int i=0 ;i<arr.length();i++)
                {
                    JSONObject listObject = arr.getJSONObject(i);
                    Log.i("dt",listObject.getString("dt"));
                    JSONObject tempObject =new JSONObject(listObject.getString("temp"));
                    Log.i("day",tempObject.getString("day"));
                }

                //Log.i("list",jsonObject.getString("list"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Log.i("Content",result);
        }
    }*/
}

