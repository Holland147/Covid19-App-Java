package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//creates a public class and extends AppCompatActivity to get libary updates
public class data extends AppCompatActivity {
    //creates a private RecyclerView called mRecyclerView
    private RecyclerView mRecyclerView;
    //creates private dataCountryAdapter2 called mDataAdapter
    private dataCountryAdapter2 mDataAdapter;
    //creates a private ArrayList with dataItem called mDataList
    private ArrayList<dataItem> mDataList;
    //creates a private RequestQueue called mRequestQue
    private RequestQueue mRequestQue;

    //creates an ImageButton called imageButton
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opens the layout activity_data
        setContentView(R.layout.activity_data);

        //sets the EditText to the EditText field in the layout
        EditText editText = findViewById(R.id.Search_Edit_Text);
        //checks changes in editText
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //filters the editText Valie
                filter(editable.toString());
            }
        });

        //sets the navagation_data_logo to the button created
        //runs the onClick method that runs openNavPic
        //navagation_data_logo takes the user to the navigation page
        imageButton = (ImageButton) findViewById(R.id.navagation_data_logo);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNavPic();
            }
        });

        //assigns recyclerview to the recycler view in layout
        mRecyclerView = findViewById(R.id.data_recycle);
        //creates a fixed size and wont change width and height
        mRecyclerView.setHasFixedSize(true);
        //creates layout manager wants the items to be displayed in a linear way
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //creates an arrayList
        mDataList = new ArrayList<>();
        //Json request
        mRequestQue = Volley.newRequestQueue(this);
        //calls method
        parseJson();

    }
    //creates method called filter with a string called text
    private void filter(String text) {
        //creates a new Array list
        ArrayList<dataItem> filteredList = new ArrayList<>();
        //for each dataItem in mData list
        for (dataItem item : mDataList) {
            //turns the value into lowercase so it doesnt matter about capital letters
            //checks the country
            if (item.getmCountry().toLowerCase().contains(text.toLowerCase())){
                //displays the item if they match the item.getCountry
                filteredList.add(item);
            }
        }
        //passes filteredList to adaptor
        mDataAdapter.filterList(filteredList);
    }
    //creaths a method called parseJson
    public void parseJson() {
        //link to data to get Json data
        String url = "https://api.covid19api.com/summary";

        //requests the Json object(Json is a big object)
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                //onResponse used to get data from objet
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //the name of the Json array is Countries that has the data want
                            JSONArray jsonArray = response.getJSONArray("Countries");
                            //creates a for loop to check all data from object
                            for (int i = 0; i < jsonArray.length(); i++) {
                                //creats a new object and gets data for every item in object
                                JSONObject Countries = jsonArray.getJSONObject(i);
                                //gets the country in the object filtering by the name "Country"
                                String countryName = Countries.getString("Country");
                                //gets the deathCount in the object by filtering by the name "TotalDeaths"
                                int deathCount = Countries.getInt("TotalDeaths");
                                //gets the caseCount in the object filtering by the name "TotalConfirmed"
                                int casesCount = Countries.getInt("TotalConfirmed");
                                //gets the newCaseCount in the object filtering by the name "NewConfirmed"
                                int newCasesCount = Countries.getInt("NewConfirmed");

                                //now we fill the mDataList and pass dataItem then pass the data
                                mDataList.add(new dataItem(countryName,deathCount,casesCount,newCasesCount));
                            }

                            //creates a new apator with data from mDataList
                            mDataAdapter = new dataCountryAdapter2(data.this, mDataList);
                            //now adds the data to the recyclerView
                            mRecyclerView.setAdapter(mDataAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    //checks if there was an error when getting Json
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        //adds request to request que
        mRequestQue.add(request);

    }


    //creats a method called openNavPic
    public void openNavPic() {
        //creates intent instance and pas context and the class we want to open
        Intent intent = new Intent(this, navigation.class);
        //pass intent created
        startActivity(intent);

    }
}
