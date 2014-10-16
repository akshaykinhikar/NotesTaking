package com.example.notestaking.data;

import java.util.ArrayList;
import java.util.List;

public class NotesDataSource {
	
	public List<NoteItem> findAll(){
		
		List<NoteItem> notelist = new ArrayList<NoteItem>();
		NoteItem note = NoteItem.getNew();
		notelist.add(note);
		return notelist;
	}
	
	
}
