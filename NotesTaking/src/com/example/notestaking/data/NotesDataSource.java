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
	
	public boolean update(NoteItem note){
		return true;
	}


	public boolean remove(NoteItem note){
		return true;
	}

}
