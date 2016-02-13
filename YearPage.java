
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class YearPage extends JPanel{
    
    JLabel lb_year;
    JButton bt_year[];
    int total_years = 0;
    
    
    
    public YearPage(){
        
        int k=150,x=140;
        lb_year = new JLabel("CHOOSE YOUR MOVIE RELEASED YEAR");
        setLayout(null);
        lb_year.setBounds(155, 100, 250, 25);
        String year[] = movieYear();
        bt_year = new JButton[distinctYears()];
        
        for(int i = 0; i < distinctYears(); i++){
            
            bt_year[i] = new JButton(year[i]);
            
            bt_year[i].setBounds(k, 140, 70, 25);
            
            add(bt_year[i]);
            
            k=k+75;
            
        }
         add(lb_year);
    }
    
    public int distinctYears(){
        
        try{
			
        Connection con = DBconnect.getConnection();
              Statement stm  = con.createStatement();
                 ResultSet rs = stm.executeQuery("SELECT DISTINCT YEAR FROM BCLASSROOM");
                 total_years=0;
                   while(rs.next()){
                       total_years++;
                   }
        
        }catch(SQLException ex){}
        
        return total_years;
    }
    
    public String[] movieYear(){
		
        int p=0;
        int index = distinctYears();
        String years[] = new String[index];
		
        try {
              
            Connection con = DBconnect.getConnection();
            Statement stm  = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT DISTINCT YEAR FROM BCLASSROOM");
			
            while(rs.next()){
                
                years[p] = rs.getString("year");
                p++;
            }
            
        }catch (SQLException ex) {}
            
        
         return years;
    }
    
}
