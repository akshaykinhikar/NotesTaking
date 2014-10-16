package com.example.notestaking;

import java.util.List;

import com.example.notestaking.data.NoteItem;
import com.example.notestaking.data.NotesDataSource;

import android.os.Bundle;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends ListActivity {
	private NotesDataSource datasource;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		datasource = new NotesDataSource(this);	
		List<NoteItem> notes = datasource.findAll();//find all notes in preferences
		NoteItem note = notes.get(0);	//get first note
		note.setText("Updated");		//update note
		datasource.update(note);	
		
	    notes =datasource.findAll();  
		note = notes.get(0);
				 
		Log.i("Notes", note.getKey()+ " : " + note.getText());
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
