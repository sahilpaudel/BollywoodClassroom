
import java.sql.*;

public class DBconnect{
    
	  public static Connection getConnection(){
	  
	        Connection connect = null;
			
             try{	
			 
				 Class.forName("com.mysql.jdbc.Driver");
				    
					connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/DBClassroom","root","sahil");
		     }
			 catch(SQLException | ClassNotFoundException e){
			 
			         System.out.println(e.getMessage()); 
			 }
			return connect;	 
	  }

}