package com.psu.SWENG500.Powerlifting;

import com.psu.SWENG500.Powerlifting.models.ui.NewsArticle;

import junit.framework.TestCase;

public class NewsArticleTest extends TestCase {

	private NewsArticle article;
	private String date = "Feb 28 2017";
	
	public void setUp() throws Exception {
		article = new NewsArticle("Title", "muscles.com", date, "Short description", "Article contents.");
	}

	public void testArticleTitleSuccess() {
		assertEquals("Title", article.getArticleTitle());
	}

	public void testSiteOriginSuccess() {
		assertEquals("muscles.com", article.getSiteOrigin());
	}
	
	public void testArticleDateSuccess() {
		assertEquals(date, article.getArticleDate());
	}
	
	public void testArticleShortDescriptionSuccess() {
		assertEquals("Short description", article.getArticleShortDescription());
	}
	
	public void testArticleContentsSuccess() {
		assertEquals("Article contents.", article.getBodyContents());
	}
}
