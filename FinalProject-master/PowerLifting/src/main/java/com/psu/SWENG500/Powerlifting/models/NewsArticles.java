package com.psu.SWENG500.Powerlifting.models;

import java.net.URL;
import java.util.List;

public class NewsArticles {
	private static List<Website> siteList;

	public static void addSiteLink(URL url, boolean tagged) {
		siteList.add(new Website(url, tagged));
	}

	public List<Website> getSiteList() {
		return siteList;
	}
	
	public void changeTagging(URL url){
		for (Website site : siteList){
			if (site.getUrl().toExternalForm().equals(url.toExternalForm())){
				site.setTagged(!site.isTagged());
			}
		}
	}
}
