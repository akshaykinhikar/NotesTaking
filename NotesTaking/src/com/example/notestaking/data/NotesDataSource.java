package com.example.notestaking.data;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;

public class NotesDataSource {
	private static final String PREFKEY = "notes";
	private SharedPreferences notePrefs;
	
	public NotesDataSource(Context context){
		notePrefs = context.getSharedPreferences(PREFKEY, context.MODE_PRIVATE);
		
	}
	
	public List<NoteItem> findAll(){
		
		List<NoteItem> notelist = new ArrayList<NoteItem>();
		NoteItem note = NoteItem.getNew();
		notelist.add(note);
		return notelist;
	}
	
	public boolean update(NoteItem note){
		return true;
	}


	public boolean remove(NoteItem note){
		return true;
	}

}
