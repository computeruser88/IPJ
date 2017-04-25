package com.psu.SWENG500.Powerlifting.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigReader {
	private static ConfigReader reader;
	private List<String> siteList;
	private static final String SITE_TAG = "Site";
	
	private ConfigReader()
	{
	}
	
	public static synchronized ConfigReader getInstance()
	{
		if(reader == null)
		{
			reader = new ConfigReader();
		}
		return reader;
	}
	
	public synchronized void readSiteListFile(String siteFile)
	{
		try {
			siteList = null;
//			File file = new File(siteFile);
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			Document document = builderFactory.newDocumentBuilder().parse(siteFile); 
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName(SITE_TAG);
			siteList = new ArrayList<String>();
			
			for(int i=0; i < nodeList.getLength(); i++)
			{
				siteList.add(((Element) nodeList.item(i)).getTextContent());
			}
		} catch (FileNotFoundException e){
//			e.printStackTrace();
			System.out.println("We have a FileNotFoundException");
		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
			System.out.println("We have a ParserConfigurationException");
		} catch (SAXException e) {
//			e.printStackTrace();
			System.out.println("We have a SAXException");
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("We have a IOException");
		} catch (Exception e) {
//			e.printStackTrace();	
			System.out.println("We have a Exception");
		}
	}
	
	public List<String> getSiteList()
	{
		return siteList;
	}
}
