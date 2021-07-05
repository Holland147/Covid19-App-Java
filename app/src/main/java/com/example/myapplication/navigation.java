package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;

//creates a public class and extends AppCompatActivity to get libary updates
public class navigation extends AppCompatActivity {
    //create a Button called button
    private Button button;
    //create a Button called button_favourites
    private Button button_favourites;

    //we create proteced method that inherites Bundle savedInstanceState
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opens the layout activity_navigation
        setContentView(R.layout.activity_navigation);


        //sets the button_favourites to the Image button created
        //runs the onClick function that runs the openNavButton
        //openFav takes the user to the Favourite page
        button_favourites = (Button) findViewById(R.id.button_favourites);
        button_favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFav();
            }
        });

        //sets the nav_home_logo to the Image button created
        //runs the onClick function that runs the openNavButton
        //openData takes the user to the data page
        button = (Button) findViewById(R.id.dataNav_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openData();
            }
        });

        //creates an instance of Calendar called callendar
        Calendar calendar = Calendar.getInstance();
        //sets the current date to a string called current date by calling getDateInstance
        //then calls callndar and getTime gets the current date
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        //sets the date_clock textView to the current date
        TextView textViewDate = findViewById(R.id.date_clock);
        textViewDate.setText(currentDate);

    }
    //creates a method called openFav
    public void openFav() {
        //creates intent instance and pas context and the class we want to open
        Intent intent = new Intent(this, favourites.class);
        //pass intent created
        startActivity(intent);
    }

    //creates a method called openData
    public void openData() {
        //creates intent instance and pas context and the class we want to open
        Intent intent = new Intent(this, data.class);
        //pass intent created
        startActivity(intent);

    }
}