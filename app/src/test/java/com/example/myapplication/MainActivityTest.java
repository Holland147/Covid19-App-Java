package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;


@RunWith(JUnit4.class)
public class MainActivityTest {

    private MainActivity mainActivity;




    private static final String CheckEditText = "Check";

    private static final String testToast = "bob";






    @Before
    public void setUp() {mainActivity = new MainActivity();}

    @Test
    public void checkEdit() {assertEquals("bob", "bob");}

    private static final String EditText = "Check";

    @Test
    public void checkFalse() {


    }














    }


