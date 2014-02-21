package com.example.testapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class TodoList extends Activity {
    private ListView 		lv;
    private boolean  		isEditing;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo_list);

        lv = (ListView) findViewById(R.id.list);

        // Instanciating an array list (you don't need to do this, 
        // you already have yours).
        ArrayList<String> your_array_list = new ArrayList<String>();
        your_array_list.add("This is a very long Todo and might span many lines of code, but what can you do?");
        your_array_list.add("Vlad's Home");
        your_array_list.add("Mike");
        your_array_list.add("Rafael's to-dos");
        your_array_list.add("Pablo");
        
        TodoArrayAdapter arrayAdapter = new TodoArrayAdapter(
                this,
                your_array_list );
        
        lv.setAdapter(arrayAdapter); 
        
        lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent intent = new Intent(arg0.getContext(), EditTodo.class);
				startActivityForResult(intent, 0);
			}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.todo_list, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_add:
				Intent intent = new Intent(getBaseContext(), EditTodo.class);
				startActivityForResult(intent, 0);
	            return true;
	        case R.id.action_show_hide_checked:
				final AlertDialog.Builder builder=new AlertDialog.Builder(this);
				builder.setTitle("Checked Toggle");
				builder.setMessage("This will toggle between showing and hiding checked items");
				builder.setIcon(android.R.drawable.ic_dialog_alert);
				
				builder.setPositiveButton("Ok", new OnClickListener() {

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
		            ArrayList<String> your_array_list = new ArrayList<String>();
		            your_array_list.add("This is a very long Todo and might span many lines of code, but what can you do?");
		            your_array_list.add("Vlad's Home");
		            your_array_list.add("Mike");
		            your_array_list.add("Rafael's to-dos");
		            your_array_list.add("Pablo");
		            
		            TodoArrayAdapter arrayAdapter = new TodoArrayAdapter(
		                    this,
		                    your_array_list );
		            
		            lv.setAdapter(arrayAdapter); 
		            
		            lv.setOnItemClickListener(new OnItemClickListener() {
		    			@Override
		    			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		    				Intent intent = new Intent(arg0.getContext(), EditTodo.class);
		    				startActivityForResult(intent, 0);
		    			}
		            });
		    	} else {
		    		item.setTitle("Done");
			        lv = (ListView) findViewById(R.id.list);

			        // Instanciating an array list (you don't need to do this, 
			        // you already have yours).
			        ArrayList<String> your_array_list = new ArrayList<String>();
			        your_array_list.add("This is a very long Todo and might span many lines of code, but what can you do?");
			        your_array_list.add("Vlad's Home");
			        your_array_list.add("Mike");
			        your_array_list.add("Rafael's to-dos");
			        your_array_list.add("Pablo");
			        
			        EditListArrayAdapter arrayAdapter = new EditListArrayAdapter(
			                this,
			                your_array_list );
			        
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
	        default:
	            return super.onOptionsItemSelected(item);
		    }
	    	
	    return false;
	    }
	}
