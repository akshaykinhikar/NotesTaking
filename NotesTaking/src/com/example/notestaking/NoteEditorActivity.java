package com.example.notestaking;

import com.example.notestaking.data.NoteItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class NoteEditorActivity extends Activity {

	private NoteItem note;		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_editor);
	
		Intent intent = this.getIntent(); //get reference to intent in main Activity
		note = new NoteItem(); 	//instantiate note item
		note.setKey(intent.getStringExtra("key")); //get the value of key and set
		note.setText(intent.getStringExtra("text"));
		
		EditText et =(EditText) findViewById(R.id.noteText); 	//ref to edit text
		et.setText(note.getText());
		et.setSelection(note.getText().length());
		
	}

	private void saveAndFinish(){
		EditText et =(EditText) findViewById(R.id.noteText); //for back button, to get text
		String noteText = et.getText().toString(); //to get valid String
		
		//Send the data back to main Activity
		Intent intent = new Intent();
		intent.putExtra("key", note.getKey());
		intent.putExtra("text", noteText); //User data
		setResult(RESULT_OK, intent); //feedback for mainActivity
		finish();
		
		
		
	}


}
