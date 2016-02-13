
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LevelPage extends JPanel {
    
    JButton bt_level[];
    
    
    JLabel lb_select;
    
    public LevelPage(){
        
        int k=175,x=140;
        bt_level = new JButton[3];
        
        
        lb_select = new JLabel("LEVELS");
        
        setLayout(null);
        lb_select.setBounds(225, 100, 50, 25);
        for(int i=0;i<3;i++){
            
            bt_level[i] = new JButton(""+(i+1));
            
            bt_level[i].setBounds(k, x, 45, 25);
            
            add(bt_level[i]);
            
            k=k+50;
            x+=50;
        }
        
        add(lb_select);
    }
}
