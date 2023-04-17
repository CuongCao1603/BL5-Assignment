package context;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
    
//    private Connection conn;
//    public Connection getConn(){
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-95MSJKL:1433/kitchenware","sa","123");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
    
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    
    /*Insert your other code right after this comment*/
   
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "DESKTOP-95MSJKL";
    private final String dbName = "kitchenware";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123";
   
}