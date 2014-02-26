package com.example.testapp;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
    private ListView 				lv;
    private boolean  				isEditing;
    private ArrayList<String> 		usersArrayList;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		isEditing = false;
		
        lv = (ListView) findViewById(R.id.list);

        // Instanciating an array list (you don't need to do this, 
        // you already have yours).
        usersArrayList = new ArrayList<String>();
        usersArrayList.add("Vlad");
        usersArrayList.add("Mike");
        usersArrayList.add("Rafael");
        usersArrayList.add("Pablo");

        // This is the array adapter, it takes the context of the activity as a 
        // first parameter, the type of list view as a second parameter and your 
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, 
                android.R.layout.simple_list_item_1,
                usersArrayList );

        lv.setAdapter(arrayAdapter); 
        
        lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent intent = new Intent(arg0.getContext(), TodoList.class);
				startActivityForResult(intent, 0);
			}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

	    switch (item.getItemId()) {
	    case R.id.action_add:	 
			final AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setTitle("Add User");
			builder.setMessage("User Name");
			builder.setIcon(android.R.drawable.ic_dialog_alert);

            // Set an EditText view to get user input 
            final EditText input = new EditText(getApplicationContext());
            input.setTextColor(0xFF000000);
            input.setCursorVisible(true);
            builder.setView(input);
			
			builder.setNegativeButton("Cancel", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			
			builder.setPositiveButton("Create", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			builder.show();   	
	    	break;
	    case R.id.action_edit:

	    	if (isEditing) {
	    		item.setTitle("Edit");
	    		
	            lv = (ListView) findViewById(R.id.list);

	            // This is the array adapter, it takes the context of the activity as a 
	            // first parameter, the type of list view as a second parameter and your 
	            // array as a third parameter.
	            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
	                    this, 
	                    android.R.layout.simple_list_item_1,
	                    usersArrayList );

	            lv.setAdapter(arrayAdapter); 
	            
	            lv.setOnItemClickListener(new OnItemClickListener() {
	    			@Override
	    			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	    				Intent intent = new Intent(arg0.getContext(), TodoList.class);
	    				startActivityForResult(intent, 0);
	    			}
	            });
	    	} else {
	    		item.setTitle("Done");
		        lv = (ListView) findViewById(R.id.list);
		        
		        EditListArrayAdapter arrayAdapter = new EditListArrayAdapter(
		                this,
		                usersArrayList );
		        
		        lv.setAdapter(arrayAdapter); 
		        
		        lv.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
						Intent intent = new Intent(arg0.getContext(), EditTodo.class);
						startActivityForResult(intent, 0);
					}
		        });
	    	}
	    	
	    	isEditing = !isEditing;
	    	
	    	break;
	    }
		
		return false;
	}
	

}
