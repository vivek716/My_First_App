package com.mycompany.myfirstapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MyActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    /*
     * Declaring Class Members
     * searchResultView - List GUI that appears on the Activity / Window
     * @NOTE: from here on we will use the term activity rather than window
     * listAdapter - Required by searchResultView
     */
    private ListView searchResultView;
    private ArrayAdapter<String> listAdapter;

    /*
     * This function is called when the Activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // Fetch the required ListView from the Activity and save it into
        // class memeber (declared above) searchResultView
        //
        // The following line of code can be broken down into the following steps
        // 1. findViewbyId retrieves the ListView from the Activity (the list view we are interested in has the id - search_list_view)
        // 2. Cast whatever is returned by findviewById into ListView (we don't need to understand this step right now)
        // 2.1 Incase you're too curious about casting - https://howtoprogramwithjava.com/java-cast/
        // 3. Finally save what is returned by findViewById (after casting) into searchResultView
        searchResultView = (ListView) findViewById(R.id.search_list_view);

        // The following line of code creates some dummy data for the ListView
        // Was supposed to be our names initally :(
        //
        // An ArrayList<string> is nothing but a list / array of String.
        // Here we create an ArrayList called players and add three String into it.
        //
        // You'll understand better if you read on ArrayLists (although its not that important) -
        // http://examples.javacodegeeks.com/core-java/util/arraylist/arraylist-in-java-example-how-to-use-arraylist/
        ArrayList<String> players = new ArrayList<String>(Arrays.asList("Keith", "Abhishek", "Baba"));

        // The following line of code creates a ArrayAdapter, all we know is that the ListView needs this.
        //
        // The ArrayAdapter takes 3 arguments over here.
        // 1. this - we can skip the explanation for this right now.
        // 2. R.layout.simplerow - A GUI layout of some sort (in this case a simplerow, which is nothing but a TextView)
        // 3. players - Data (that needs to be seen in the list)
        //
        // What does the adapter do?
        //
        // GUI Layout + Data = GUI with data embeded in it
        // Example:
        // TextView + [Keith, Vivek] = TextView(with text set to Keith), TextView(with text set to Vivek)
        //
        // If you want to read more on ArrayAdaptar
        // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, players);

        //We finally pass the adaptar to ListView and the Data is seen in the List.
        searchResultView.setAdapter(listAdapter);

        // If you're still confused about how this works, take some time and think how would you implement this.
        //
        // Keep the following things in mind:
        // 1. Forget programming languages while thinking about this problem, think of this as a normal problem
        // 2. You have 33 jobless guys. (each team has 11 right?)
        // 3. Create a kit for each team. (jersey color, etc)
        // 4. You have a jobless tailor.
        //
        // @TODO: explain the steps involved in create 3 soccer teams

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_frnds:
            sendMessage(this.getCurrentFocus());
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void sendMessage(View view){
        //Toast.makeText(getApplicationContext(), "Test Test....", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
 }