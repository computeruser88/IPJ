package com.psu.SWENG500.Powerlifting;

import java.util.List;


import com.psu.SWENG500.Powerlifting.models.ConfigReader;

import junit.framework.TestCase;

public class ConfigReaderTest extends TestCase {
	
	private ConfigReader reader;

	public void setUp() throws Exception {
		reader = ConfigReader.getInstance();
	}

	public void testNullConfigFilename() {
		reader.readSiteListFile(null);
		List<String> nullList = reader.getSiteList();
		assertNull(nullList);
	}
	
//	public void testNonexistentConfigFilename() {
//		reader.readSiteListFile(getClass().getClassLoader().getResource("scripts/prop.xml").getFile());
//		List<String> nullList = reader.getSiteList();
//		assertNull(nullList);
//	}

	public void testReaderFileSuccess() {
		reader.readSiteListFile(getClass().getClassLoader().getResource("scripts/sitelist.xml").getFile());
		List<String> siteNameList = reader.getSiteList();
		assertEquals(1, siteNameList.size());
	}
}
