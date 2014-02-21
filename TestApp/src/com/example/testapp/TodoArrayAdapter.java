package com.example.testapp;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class TodoArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final ArrayList<String> values;

	public TodoArrayAdapter(Context context, ArrayList<String> your_array_list) {
		super(context, R.layout.todo_item, your_array_list);
		this.context = context;
		this.values = your_array_list;
	}
	 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.todo_item, parent, false);
		CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkBox1);
		checkBox.setText(values.get(position));

		TextView priorityText = (TextView) rowView.findViewById(R.id.prioriryText);

		switch ((int)Math.ceil(Math.random() * 3)) {
		case 1:
			priorityText.setText("Low");
			priorityText.setTextColor(0xFF000099);
			break;
		case 2:
			priorityText.setText("Med");
			priorityText.setTextColor(0xFFFF9933);
			break;
		case 3:
			priorityText.setText("High");
			priorityText.setTextColor(0xFF990000);
			break;
		}
		
		return rowView;
	}

}
