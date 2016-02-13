
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



 //@author Sahil Paudel
 
public class Bollywood extends JFrame implements ActionListener{

    CardLayout card;
    
    JPanel jcard;
    
    MainPage mp;
    YearPage yp;
    LevelPage lp;
    TinyPage tp;
    GamePage gp;
    
   static String yearpass,levelpass,midpass;
   
   int index=0;
   
    public Bollywood(){
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jcard = new JPanel();
        
        //starting page;
        mp = new MainPage(); 
		
        //year Page
        yp = new YearPage();
		
        //level page
        lp = new LevelPage();
        //Mini Level
        tp = new TinyPage();
		
        //the final game page
        gp = new GamePage();
        
        card = new CardLayout();
        jcard.setLayout(card);
        
        jcard.add(mp,"MainPage");
        jcard.add(yp,"YearPage");
        jcard.add(lp,"LevelPage");
        jcard.add(tp,"TinyPage");
        jcard.add(gp,"GamePage");
        
        
        //Main Page
        mp.bt_start.addActionListener((ActionListener) this);
        //System.out.println(yp.bt_year.length);
		
        for(int i=0; i < yp.bt_year.length; i++){
			
            yp.bt_year[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
					
                    yearpass = e.getActionCommand();
                    card.next(jcard);
                }
            });
        }
        
        
        for(int i=0; i < lp.bt_level.length; i++){
			
            lp.bt_level[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
					
                    levelpass = e.getActionCommand();
                    card.next(jcard);
                    tp.AfterLevelIsCalled();
                    CallThisAfterLevel();
                }
            });
        }
        
        
       
        
        
        
        
        
       // tp.getTinyID(yearpass, levelpass);
       
        add("Center",jcard);
        
        setVisible(true);
        setSize(500,500);
        setAlwaysOnTop(false);
        setResizable(false);
        setLocation(450, 50);
        setName("BCLASSROOM");
        
        
    }
    
    
    //IT SHOULD BE CALLED ONLY AFTER LEVEL ACTION IS PERFORMED
     void CallThisAfterLevel(){
		 
        ArrayList list = tp.getTinyID(yearpass,levelpass);
        index = list.size();
        System.out.println(index);
		
        for(int j=0; j<index; j++){
            
            tp.bt_tinylevel[j].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
					
                    midpass = e.getActionCommand();
                    card.next(jcard);
                    gp.Matching();
                    gp.Option();
                }
            });
        }
      }
    
    
   
     @Override
    public void actionPerformed(ActionEvent e){
		
        if(e.getSource()==mp.bt_start)
            card.next(jcard);
    }
 
   
   //PASSING THE variables only after it is set
    static String passyear(){
		
       return yearpass;
    }
	
    static String passlevel(){ 
	
       return levelpass;
    } 
	
    static String passmid(){
	   
     return midpass;
    }
   
   
    public static void main(String[] args) {
		
        Bollywood b = new Bollywood();    
    }
}
