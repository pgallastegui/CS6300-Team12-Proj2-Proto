package com.example.testapp;

import android.widget.ArrayAdapter;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class EditListArrayAdapter  extends ArrayAdapter<String> {
	private final Context context;
	private final ArrayList<String> values;

	public EditListArrayAdapter(Context context, ArrayList<String> your_array_list) {
		super(context, R.layout.edit_list, your_array_list);
		this.context = context;
		this.values = your_array_list;
	}
	 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.edit_list, parent, false);
		TextView checkBox = (TextView) rowView.findViewById(R.id.checkBox1);
		checkBox.setText(values.get(position));
		
		final Button editButton = (Button) rowView.findViewById(R.id.editButton);
		editButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final AlertDialog.Builder builder=new AlertDialog.Builder(editButton.getContext());
				builder.setTitle("Editing Element");
				builder.setMessage("This will pull the editing interface. Tap on 'Add' on the Action bar at the top to view this interface");
				
				builder.setPositiveButton("Ok", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				builder.show();  
				
			}
			
		});
		
		final Button deleteButton = (Button) rowView.findViewById(R.id.deleteButton);
		deleteButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final AlertDialog.Builder builder=new AlertDialog.Builder(deleteButton.getContext());
				builder.setTitle("Delete Item");
				builder.setMessage("This will Delete this item. Are you sure you want to continue?");
				
				builder.setPositiveButton("Ok", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				builder.setNegativeButton("Cancel", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				builder.show();  
				
			}
			
		});
		
		return rowView;
	}

}
