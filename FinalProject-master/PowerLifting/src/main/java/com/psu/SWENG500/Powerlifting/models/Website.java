package com.psu.SWENG500.Powerlifting.models;

import java.net.URL;

public class Website {
	private boolean tagged;
	private URL url;
	
	public Website (URL url, boolean tagged){
		setUrl(url);
		setTagged(tagged);
	}
	
	public boolean isTagged() {
		return tagged;
	}
	public void setTagged(boolean tagged) {
		this.tagged = tagged;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	
}
