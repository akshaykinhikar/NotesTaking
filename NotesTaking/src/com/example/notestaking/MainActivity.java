package com.example.notestaking;

import java.util.List;

import com.example.notestaking.data.NoteItem;
import com.example.notestaking.data.NotesDataSource;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
	private NotesDataSource datasource;
	List<NoteItem> notesList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		datasource = new NotesDataSource(this);	
		
		refreshDisplay();
		
	
	}

	private void refreshDisplay() {
		
		notesList = datasource.findAll();
		ArrayAdapter<NoteItem> adapter =
				new ArrayAdapter<NoteItem>(this, R.layout.list_item_layout,notesList);
		setListAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.action_create) {
			createNote();
		}
		return super.onOptionsItemSelected(item);
	}

	private void createNote() {						//Creates the new note

		NoteItem note =NoteItem.getNew();		//new obj declared
		Intent intent = new Intent(this,NoteEditorActivity.class);  //navigate between Screen
		intent.putExtra("key", note.getKey());	//passed string
		intent.putExtra("text", note.getText());
		startActivityForResult(intent, 1001); //start Activity
	
	
	}
}
