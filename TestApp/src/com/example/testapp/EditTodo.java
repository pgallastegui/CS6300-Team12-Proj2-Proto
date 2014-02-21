package com.example.testapp;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class EditTodo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_todo);
		
		final TextView theTextView = (TextView)findViewById(R.id.editText1);
		theTextView.setImeActionLabel("Done", KeyEvent.KEYCODE_ENTER);
		
		final EditTodo container = this;
		
		theTextView.setOnKeyListener(new TextView.OnKeyListener() {

			@Override
			public boolean onKey(View arg0, int keyCode, KeyEvent event) {
				Log.e("RPS", "pressing a button");
				 if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
					Log.e("RPS", "pressing enter button");
					 container.hideSoftKeyBoard();
					 return true;
				 }
				return false;
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_todo, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		finish();
		
		return true;
	}
	
	private void hideSoftKeyBoard() {
		InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		if(imm.isAcceptingText())// verify if the soft keyboard is open                         
			imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
	}
}
