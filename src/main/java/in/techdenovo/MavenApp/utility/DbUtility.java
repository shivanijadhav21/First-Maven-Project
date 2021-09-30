package in.techdenovo.MavenApp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {
    public Connection getConnection(){
        String url="jdbc:mariadb://localhost:3306/customerdatabase";
        String dbUsername="root";
        String password="root";
        Connection conn=null;

        try{
            conn= DriverManager.getConnection(url,dbUsername,password);

        }
        catch (SQLException e){
            System.out.println(e);
        }
        return conn;
    }
}
