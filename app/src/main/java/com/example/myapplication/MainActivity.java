package com.example.myapplication;
//imports all the needed packages
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//creates a public class and extends AppCompatActivity to get libary updates
public class MainActivity extends AppCompatActivity {
    //create a private Button called button
    private Button button;

    //create a private TextView called display_user_name
    private TextView display_user_name;

    //create a private EditText called editText_user_name
    private EditText editText_user_name;

    //create a private Button called add_name_button
    private Button add_name_button;

    //create a private button called save_name_button
    private Button save_name_button;

    //create a private Switch called switch_name
    private Switch switch_name;

    //create a public string that cannot be changed as we assigned final, static is used
    //so only one copy can be used. String SHARED_PREFRENCES is set to "sharedPrefrences"
    public static final String SHARED_PREFRENCES = "sharedPrefrences";

    //create a public string that cannot be changed as we assigned final, static is used
    //so only one copy can be used. String TEXT is set to "Text"
    public static final String TEXT = "text";

    //create a public string that cannot be changed as we assigned final, static is used
    //so only one copy can be used. String SWITCH_NAME is set to "switch_name"
    public static final String SWITCH_NAME = "switch_name";

    //create a private string called text
    private String text;

    //create a boolean called switchOnOff
    private boolean switchOnOff;

    //create an ImageButton called nav_home_logo
    private ImageButton nav_home_logo;

    //we create proteced method that inherites Bundle savedInstanceState
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opens the layout activity_main
        setContentView(R.layout.activity_main);

        //sets the nav_home_logo to the Image button created
        //runs the onClick method that runs the openNavButton
        //openNavButton takes the user to the navigation page
        nav_home_logo = (ImageButton) findViewById(R.id.nav_home_logo);
        nav_home_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNavButton();
            }
        });

        //sets the nav_but to the button created
        //runs the onClick method that runs openNav
        //openNav takes the user to the navigation page
        button = (Button) findViewById(R.id.nav_but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNav();
            }
        });

        //sets the private TextView EditText Button and Switch
        //to the ids in the activity_main so we can set them
        display_user_name = (TextView) findViewById(R.id.display_user_name);
        editText_user_name = (EditText) findViewById(R.id.editText_user_name);
        add_name_button = (Button) findViewById(R.id.add_name_button);
        save_name_button = (Button) findViewById(R.id.save_name_button);
        switch_name = (Switch) findViewById(R.id.switch_name);

        //when the user clicks the add button the input in the editText field
        //will set display_user_name
        add_name_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display_user_name.setText(editText_user_name.getText().toString());
            }
        });

        //when the user Clicks on the save_name_button saveData function will be called
        save_name_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        //runs the loadData method
        loadData();
        //runs the updateViews method
        updateViews();

        }

    //creates a method called saveData
    public void saveData() {
        //creates instance of sharedPreferences then getSharedPreferences
        //then pass the name of SHARED_PREFRENCES
        //sets the mode to private means no other app can change sharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFRENCES,MODE_PRIVATE);
        //allows editing of sharedPrefernces
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //gets the constant from TEXT and then the value from display_user_name
        editor.putString(TEXT,display_user_name.getText().toString());
        //will only save if the Switch is turned on or checked
        editor.putBoolean(SWITCH_NAME,switch_name.isChecked());
        //apply changes
        editor.apply();

        //tells the user Name has been saved
        Toast.makeText(this, "Name saved",Toast.LENGTH_SHORT).show();

    }

    //creates method called loadData
    public void loadData() {
        //creates instance of sharedPrefernces
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFRENCES,MODE_PRIVATE);
        //loads the data from TEXT sets default value to empty string
        text = sharedPreferences.getString(TEXT, "");
        //sets the default value of switch to off
        switchOnOff = sharedPreferences.getBoolean(SWITCH_NAME, false);

    }

    //creates method called updateViews
    public void updateViews() {
        //applys the varivbles set in loadData to the views
        display_user_name.setText(text);
        switch_name.setChecked(switchOnOff);
    }

    //creates a method called openNavButton
    public void openNavButton() {
        //creates intent instance and pas context and the class we want to open
        Intent intent = new Intent(this, navigation.class);
        //pass intent created
        startActivity(intent);
    }
    //creates a method called openNav
    public void openNav() {
        //creates intent instance and pas context and the class we want to open
        Intent intent = new Intent(this, navigation.class);
        //pass intent created
        startActivity(intent);

    }
}