package com.psu.SWENG500.Powerlifting.models;

public enum ElementTags {

	ARTICLE("article"),
	A("a"),
	HREF("href"),
	H1("h1"),
	TIME("time"),
	DATETIME("datetime"),
	P("p");
	
	private String element;
	
	ElementTags(String element) {
		this.element = element;
	}
	
	public String value() {
		return element;
	}
}
