package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//creates a public class that adds the recyclerView Adapter
public class dataCountryAdapter2 extends RecyclerView.Adapter<dataCountryAdapter2.datacountry2ViewHolder> {
    //creates a private context called mContext
    private Context mContext;
    //creates an ArrayList that takes the item dataItem this then displays the data how we created in
    //dataItem
    private ArrayList<dataItem> mDataList;

    //creates a public method that takes context and the dataItem array list
    public dataCountryAdapter2(Context context, ArrayList<dataItem> datalist){
        //sets mContext to mContext
        mContext = context;
        //sets mDataList to dataList
        mDataList = datalist;

    }

    @NonNull
    @Override
    //creates a public method that takes on parent and the int ViewType
    public datacountry2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creates a view called v that fills in the View holder of arraylist
        View v = LayoutInflater.from(mContext).inflate(R.layout.data_item,parent,false);
        //returns datacountry2ViewHolder with the view created
        return new datacountry2ViewHolder(v);
    }

    //creates a method called onBindViewHolder that takes the position
    @Override
    public void onBindViewHolder(@NonNull datacountry2ViewHolder holder, int position) {
        //saves the position as currentItem
        dataItem currentItem = mDataList.get(position);

        //sets the country to the current item and saves country to the variable
        String country = currentItem.getmCountry();
        //sets the numDeaths to the current item and saves numDeaths to the variable
        int numDeaths = currentItem.getmDeaths();
        //sets the numCases to the current item and saves numCases to the variable
        int numCases = currentItem.getmCases();
        //sets the numNewCases to the current item and saves numNewCases to the variable
        int numNewCases = currentItem.getmNewCases();

        //sets the country to the holder that sets the text in the holder to country
        holder.mTextViewCountry.setText(country);
        //sets the numDeaths to the holder that sets the text in the holder to "deaths" then
        //the number of deaths from api
        holder.mTextViewDeaths.setText("Deaths:" + numDeaths);
        //sets the cases to the holder that sets the text in the holder to "Cases" then
        //the amount of cases from api
        holder.mTextViewCases.setText("Cases:" + numCases);
        //sets the numDeaths to the holder that sets the text in the holder to "New cases" then
        //the number of new cases from api
        holder.mTextViewNewCases.setText("New cases:" + numNewCases);

    }


    //sets as many items in adaptroer as in arraylist
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    //allows the user to search
    public void filterList(ArrayList<dataItem> filteredList){
        //set mDataList to filtered list then tell adaptor data has changed
        mDataList = filteredList;
        notifyDataSetChanged();
    }


    //class called datacountry2ViewHolder
    public class datacountry2ViewHolder extends RecyclerView.ViewHolder {

        //creating varibles for the ViewHolder
        public TextView mTextViewCountry;
        public TextView mTextViewDeaths;
        public TextView mTextViewCases;
        public TextView mTextViewNewCases;

        public datacountry2ViewHolder(@NonNull View itemView) {
            super(itemView);
            //finding views from the data_item.xml and sets them as the varibles
            mTextViewCountry = itemView.findViewById(R.id.country_text_view);
            mTextViewDeaths = itemView.findViewById(R.id.deaths_text_view);
            mTextViewCases = itemView.findViewById(R.id.totalCases_text_view);
            mTextViewNewCases = itemView.findViewById(R.id.newCases_text_view);
        }
    }
}
