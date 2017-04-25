package com.psu.SWENG500.Powerlifting;

import java.util.List;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.models.ConfigReader;
import com.psu.SWENG500.Powerlifting.models.NewsArticleModel;
import com.psu.SWENG500.Powerlifting.models.ui.NewsArticle;

public class NewsArticleModelTest extends TestCase {
	
	private NewsArticleModel articleModel = new NewsArticleModel();

	public void testRetrieveArticlesFromListSuccess() {
		ConfigReader reader = ConfigReader.getInstance();
		reader.readSiteListFile(getClass().getClassLoader().getResource("scripts/sitelist.xml").getFile());
		List<String> siteUrls = reader.getSiteList();
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromSiteUrls(siteUrls);
		assertNotNull(articleList);
	}
	
	public void testNullSiteList(){
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromSiteUrls(null);
		assertNull(articleList);
	}
}