package com.example.bassant.movieapp;

import java.io.Serializable;

/**
 * Created by Bassant on 11/4/2016.
 */

public class Movie implements Serializable {
    private String poster_path ;
    private String original_title ;
    private String overview ;
    private String release_date ;
    private String vote_average ;
    private int id ;


   public void Movie(){

   }
    public void set (String pp,String ot,String ov,String rDate,String vote,int Mid)
    {
        this.poster_path = pp ;
        this.original_title =ot;
        this.overview =ov;
        this.release_date=rDate;
        this.vote_average=vote;
        this.id=Mid;

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
    public  String getRelease_date(){return  release_date;}
    public  String getVote_average(){return  vote_average;}
    public  int getMid(){return id;}
}
