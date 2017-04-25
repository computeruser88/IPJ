package com.psu.SWENG500.Powerlifting.models.ui;

import javafx.beans.property.SimpleStringProperty;

public class NewsArticle {
	private SimpleStringProperty articleTitle = new SimpleStringProperty();
	
	private SimpleStringProperty siteOrigin = new SimpleStringProperty();
	
	private SimpleStringProperty articleDate = new SimpleStringProperty();
	
	private SimpleStringProperty articleShortDescription = new SimpleStringProperty();
	
	private SimpleStringProperty bodyContents = new SimpleStringProperty();
	
	public NewsArticle(String articleTitle, String siteOrigin, String articleDate, String articleShortDescription, String bodyContents)
	{
		this.articleTitle.setValue(articleTitle);
		this.siteOrigin.setValue(siteOrigin);
		this.articleDate.setValue(articleDate);
		this.articleShortDescription.setValue(articleShortDescription);
		this.bodyContents.setValue(bodyContents);
	}

	public String getArticleTitle() {
		return articleTitle.getValue();
	}

	public String getSiteOrigin() {
		return siteOrigin.getValue();
	}

	public String getArticleDate() {
		return articleDate.getValue();
	}

	public String getArticleShortDescription() {
		return articleShortDescription.getValue();
	}

	public String getBodyContents() {
		return bodyContents.getValue();
	}
	
	public String toString() {
		return "SiteUrl: " + siteOrigin + "\nTitle: " + articleTitle + 
				"\nShort Description: " + articleShortDescription + 
				"\nBody: " + bodyContents + "\nDate: " + articleDate;
	}
}
