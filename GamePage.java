import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GamePage extends JPanel{
    
    
    String moviename;
    StringBuilder s;
    int counter=0;
    static int lk=0;   
    
    TinyPage tp;
    
    JButton bt_const[];
    JLabel lbshow,lbcount;
    
    
    
    public GamePage(){
        tp = new TinyPage();
        lbcount = new JLabel("...");
        lbshow = new JLabel();
        setLayout(null);
        
        lbshow.setBounds(190, 300, 200, 25);
        lbcount.setBounds(215, 350, 150, 20);
        add(lbshow);
        add(lbcount);
    }
    
    
    
    
   
    StringBuilder Matching(){
        
        moviename = tp.getMovieName().toUpperCase();
       
        int k=0;
        char c[] = moviename.toCharArray();
        s = new StringBuilder();
        
        for(int i=0; i<moviename.length(); i+=1){
           //second insert is for spacing
            switch(c[i]){
                
                case 'A':
                    s.insert(i,'A');
                                    
                    break;
                    
                case 'E':
                    s.insert(i,'E');
                                    
                    break;
                    
                case 'I':
                    s.insert(i,'I');
                                     
                    break;
                    
                case 'O':
                    s.insert(i,'O');
               
                    break;
                    
                case 'U':
                    s.insert(i,'U');
                  
                    break;
                    
                case ' ':
                    s.insert(i,' ');
                 
                    break;
                    
                default:
                    s.insert(i,'_');
                 
                    break;
                    
                    
            }
            
           
        }
       
        return s;
        
    }
    
    
    void Option(){
		
        int x=20,y=50,h=0,p=0,q=0,r=0;
        
        String consonants = "QWRTYPSDFGHJKLZXCVBNM1234567";
        char c[] = consonants.toCharArray();
                bt_const = new JButton[28];
				
                  for(int i=0; i<28; i++){
					  
                      final int m=i;//for coloring the button
                        bt_const[i] = new JButton(""+c[i]);
                          add(bt_const[i]);          
                            int k=x+h;    
                       
               if(i<=6){
				   
                  y=50;
                  h = h+50;
                  bt_const[i].setBounds(x+h, y, 48, 50);
				  
              }else if(i>6&&i<=13){
				  
                  p = p+50;
                  y=110;
                  bt_const[i].setBounds(x+p, y, 48, 50);
                  
              }else if(i>13&&i<=20){
				  
                  q = q+50;
                  y=170;
                  bt_const[i].setBounds(x+q, y, 48, 50); 
				  
              }else{
				  
                  r = r+50;
                  y=230;
                  bt_const[i].setBounds(x+r, y, 48, 50);
              }
			  
              bt_const[i].addActionListener(new ActionListener() {

                  @Override
                  public void actionPerformed(ActionEvent e){                 
                              
                    String movieName = tp.getMovieName().toUpperCase();
                             
                    counter++;
					
                      lbcount.setText(""+counter);
					  
                       if(counter>=10){
                  
                        int c = JOptionPane.showConfirmDialog(new GamePage(), "MAXIMUM ATTEMPT REACHED, SHOW ANSWER??");
						
                          if(c==0){
							  
                              int cp = JOptionPane.showConfirmDialog(new GamePage(), movieName+", Continue??");
                                        //goto list page
                              if(cp==0){  
							  
                                  //clearing previous click count.
                                  counter=0;
                                 //take user to level/or selection page
								 
                              }else{
								  
                                  System.exit(0);
                              }
                          }else{
							  
                              JOptionPane.showMessageDialog(new GamePage(),"THANK YOU, FOR STOPPING BY (* *)");
							  
                              System.exit(0);
                          }
                  
                  
                      }else{      //counter if
                  
                      for(int i=0; i < movieName.length(); i++){
                
                        if(e.getActionCommand().charAt(0)==movieName.charAt(i)){
							
                             --counter;
							 
                              s.replace(i, i+1,e.getActionCommand());
                             
                                  lbshow.setText(""+s);
                             
                                    char c[] = movieName.toCharArray();
									
                                    for(int k=0; k<c.length; k++){
										
                                        if(c[k]==' '){
											
                                            c[k]=' ';
                                        }
                                    }
                                    
                                    String name = new String(c);
									
                                    if((s.toString()).equals(name)){
										
                                        counter=0;
                                        lbcount.setText(""+counter);
                                        JOptionPane.showMessageDialog(new GamePage(), "YOU GOT IT RIGHT !!!");
										 
                                         new Bollywood().setVisible(true);  
                                         
                                    }
                   }
                    
                   bt_const[m].setBackground(Color.red);
               }
              }//counter if
            
            }
               });             
            } 
                  
             lbshow.setText(""+s);
               
    }

  
   
}
