package com.psu.SWENG500.Powerlifting.dal;

import java.net.URI;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.RunScript;

public class H2ConnectionFactory
{
	private static final String DB_DRIVER = "org.h2.Driver";
    private static String DB_CONNECTION;
    private static final String DB_USER = "IPL_APP";
    private static final String DB_PASSWORD = "SWENG_500";
    
    public static Connection GetConnection()
    {
    	return H2ConnectionFactory.GetConnection("C:\\temp");
    }
    
    public static void InitializeDatabase()
    {
    	Connection dbConn = GetConnection("C:\\temp");
    	String filename = H2ConnectionFactory.class.getClassLoader().getResource("scripts/SWENG_500_DB.sql").getPath();
    	CallableStatement initCall;
		try
		{
			initCall = dbConn.prepareCall("RUNSCRIPT FROM '" + filename.substring(1, filename.length()) + "'");
			initCall.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//try {
		//	RunScript.execute("jdbc:h2:file:C:\\temp\\IplDb.mv", "sa", "", filename, null, false);
		//} catch (SQLException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
    }
    
    public static Connection GetConnection(String dbPath)
    {
    	//Class currentClass = new Object() { }.getClass().getEnclosingClass();
    	//String temp = "jdbc:h2:file:" + H2ConnectionFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "h2/" + dbName + ".mv;AUTO_SERVER=TRUE";
    	//String temp = currentClass.getClassLoader().getResource("src/main/resources/h2/" + dbName + ".mv").toString();
    	//String temp = "jdbc:h2:file:" + H2ConnectionFactory.class.getClassLoader().getResource("src/main/resources/h2/" + dbName + ".mv").toString() + ";AUTO_SERVER=TRUE";
    	//DB_CONNECTION = "jdbc:h2:file:" + Paths.get("src/main/resources/h2/" + dbName).toAbsolutePath() + ".mv;AUTO_SERVER=TRUE"; //SCHEMA=SWENG_500";
    	DB_CONNECTION = "jdbc:h2:file:" + dbPath + "/IplDb";
    	Connection h2Connection = null;
        try
        {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try 
        {
        	h2Connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return h2Connection;
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return h2Connection;
    }
}