package com.example.notestaking;

import java.util.List;

import com.example.notestaking.data.NoteItem;
import com.example.notestaking.data.NotesDataSource;

import android.os.Bundle;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
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

}
