package com.example.myapplication;

//creates a public class called dataItem
public class dataItem {
    //crates a string called mCountry
    private String mCountry;
    //creates an int called mDeaths
    private int mDeaths;
    //creates an int called mCases
    private int mCases;
    //creates an int called mNewCases
    private int mNewCases;

    //takes the dataitem class and adds the String and ints
    //constructer
    public dataItem(String country, int deaths, int cases, int newcases) {
        //sets the Strings and ints Country,deaths,cases,newcases
        mCountry = country;
        mDeaths = deaths;
        mCases = cases;
        mNewCases = newcases;
    }

    //creates a public string called mCountry
    public String getmCountry () {
        return mCountry;
    }

    //creates a public int called mDeaths
    public int getmDeaths () {
        return mDeaths;
    }

    //creates a public int called mCases
    public int getmCases () {
        return mCases;
    }

    //creates a public string called mNewCases
    public int getmNewCases () {
        return mNewCases;
    }
}
