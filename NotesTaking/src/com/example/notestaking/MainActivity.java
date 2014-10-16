package com.example.notestaking;

import java.util.List;

import com.example.notestaking.data.NoteItem;
import com.example.notestaking.data.NotesDataSource;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private NotesDataSource datasource;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		datasource = new NotesDataSource(this);
		List<NoteItem> notes = datasource.findAll();
		NoteItem note = notes.get(0);
		 datasource.update(note);
		Log.i("Notes", note.getKey());
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
