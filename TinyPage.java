
import java.awt.Panel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;


public class TinyPage extends Panel{     
      
    JButton bt_tinylevel[];
    
    int mid;
	
    void AfterLevelIsCalled(){
        
        ArrayList list = getTinyID(Bollywood.passyear(),Bollywood.passlevel());
        
            int index = list.size();
        
               bt_tinylevel = new JButton[index];
        
                  for(int i=0; i<index; i++){
           
                        bt_tinylevel[i] = new JButton(""+list.get(i));
			
                           add(bt_tinylevel[i]);
                  }
        
        
        
 }
    
    
    ArrayList getTinyID(String year,String level){
        
        ArrayList al = new ArrayList();
     
             try{
                  Connection con = DBconnect.getConnection();
                     Statement stm = con.createStatement();
                       ResultSet rs = stm.executeQuery("SELECT slno from BCLASS"+Bollywood.passyear()+" WHERE level="+Bollywood.passlevel());
					   
                          while(rs.next()){
                                       
                                      al.add(rs.getString("slno"));
                                      
                                       
                                  }
             }
             catch(SQLException ex){}
        
        
       
        return al;
    }
    
    
    String getMovieName(){
        
        String moviename=null;
		
              try{
                  Connection con = DBconnect.getConnection();
                     Statement stm = con.createStatement();
					 //fetching the name of movie when user clicks on the year and level button
                       ResultSet rs = stm.executeQuery("SELECT mname from BCLASS"+Bollywood.passyear()+" WHERE level="+Bollywood.passlevel()+" AND slno="+Bollywood.passmid());
                          while(rs.next()){
                                       
                                      moviename = rs.getString("mname");
                                      
                                       
                                  }
             }
             catch(SQLException ex){}
                
        
        
        return moviename;
    }

    
}
