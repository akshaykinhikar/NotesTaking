package com.example.notestaking.data;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteItem {

	private String key; 
	private String text;
	
	//Getters And Setters 
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@SuppressLint("SimpleDateFormat") 

	public static NoteItem getNew(){
		Locale locale = new Locale("en_US");
		Locale.setDefault(locale);
		
		String pattern = "yyyy-MM-dd HH:mm:ss Z";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String key = formatter.format(new Date()); //current date is assigned as key
		
		NoteItem note = new NoteItem();
		note.setKey(key);	//set key
		note.setText("");	//Initially  Empty note
		return note;
		
	}
	
	@Override
	public String toString() {
		return this.getText();
	}
}
