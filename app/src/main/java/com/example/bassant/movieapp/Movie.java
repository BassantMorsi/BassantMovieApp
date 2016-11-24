package com.example.bassant.movieapp;

import java.io.Serializable;

/**
 * Created by Bassant on 11/4/2016.
 */

public class Movie implements Serializable {
    private String poster_path ;
    private String original_title ;
    private String overview ;
   public void Movie(){

   }
    public void set (String pp,String ot,String ov)
    {
        this.poster_path = pp ;
        this.original_title =ot;
        this.overview =ov;
    }
    public String getPoster_path (){
        return poster_path;
    }
    public String getOriginal_title (){
        return original_title;
    }
    public String getOverview (){
        return overview;
    }

}
