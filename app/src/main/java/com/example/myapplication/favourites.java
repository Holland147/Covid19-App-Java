package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//creates a public class and extends AppCompatActivity to get libary updates
public class favourites extends AppCompatActivity {
    //creates an ImageButton called fav_pic
    ImageButton fav_pic;
    //creates an EditText called editText_fav
    EditText editText_fav;
    //creates a button called add_fav
    Button add_fav;
    //creates a ListView called listView_Fav
    ListView listView_Fav;

    //creates an arraylist that is a list of Strings called arrayList
    ArrayList<String> arrayList;
    //creates an arrayAdapter that is a list of Strings called arrayList
    ArrayAdapter<String> adapter;

    //we create proteced method that inherites Bundle savedInstanceState
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opens the layout activity_favourites
        setContentView(R.layout.activity_favourites);

        //sets the private  EditText Button and ListView
        //to the ids in the activity_main so we can set them
        editText_fav = (EditText) findViewById(R.id.editText_fav);
        add_fav = (Button) findViewById(R.id.add_fav);
        listView_Fav = (ListView) findViewById(R.id.listView_Fav);

        //sets arrayList to new ArrayList that take Strings
        arrayList = new ArrayList<String>();
        //creates adapter with the layout and takes arrayList
        adapter = new ArrayAdapter<String>(favourites.this, android.R.layout.simple_list_item_1, arrayList);
        //sets listView_Fav sets adapter
        listView_Fav.setAdapter(adapter);

        //sets the fav_pic to the button created
        //runs the onClick method that runs openFavPic
        //openFavPic takes the user to the navigation page
        fav_pic = (ImageButton) findViewById(R.id.fav_pic);
        fav_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFavPic();
            }


        });
        //runs the onClick method
        onClick();
    }

    //creates a public method
    //when this method is run the input the user has put into the EditText field is added to the list
    public void  onClick(){
        add_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sets string to result editText_fav is then set to the string
                String result = editText_fav.getText().toString();
                //value added to the list
                arrayList.add(result);
                //changes the adapter
                adapter.notifyDataSetChanged();
            }
        });
    }

    //creates a method called openFavPic
    public void openFavPic() {
        //creates intent instance and pas context and the class we want to open
        Intent intent = new Intent(this, navigation.class);
        //pass intent created
        startActivity(intent);
    }
}