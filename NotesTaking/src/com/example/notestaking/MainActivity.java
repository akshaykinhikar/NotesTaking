package com.example.notestaking;

import java.util.List;

import com.example.notestaking.data.NoteItem;
import com.example.notestaking.data.NotesDataSource;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	private static final int Editor_Activity_request = 1001;
	private static final int Menu_Delete_Id = 1002;
	private int currentNoteId;
	
	
	
	private NotesDataSource datasource;
	List<NoteItem> notesList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		registerForContextMenu(getListView());
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
		startActivityForResult(intent, Editor_Activity_request); //start Activity

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		NoteItem note = notesList.get(position);
		Intent intent = new Intent(this, NoteEditorActivity.class);
		intent.putExtra("key", note.getKey());
		intent.putExtra("key", note.getText());
		startActivityForResult(intent, Editor_Activity_request);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == Editor_Activity_request && resultCode == RESULT_OK ){
			NoteItem note = new NoteItem();
			note.setKey(data.getStringExtra("key"));
			note.setText(data.getStringExtra("text"));
			datasource.update(note);
			refreshDisplay();
		}
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
		currentNoteId = (int) info.id;
		menu.add(0,Menu_Delete_Id,0,"Delete");
		
	}

		@Override
		public boolean onContextItemSelected(MenuItem item) {
			
			if (item.getItemId() == Menu_Delete_Id) {
				NoteItem note = notesList.get(currentNoteId);
				datasource.remove(note);
				refreshDisplay();
				
			}
			return super.onContextItemSelected(item);
		}
}
