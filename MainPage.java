
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainPage extends JPanel{
    
    JLabel lb_welcome;
    JButton bt_start;
    
    public MainPage(){
        
        lb_welcome = new JLabel("WELCOME TO BOLLYWOOD CLASSROOM");
        bt_start   = new JButton("START");
        
        
        setLayout(null);
        lb_welcome.setBounds(140, 100, 300, 50);
        bt_start.setBounds(200, 200, 100, 50);
        add(lb_welcome);
        add(bt_start);
        
    }
    
}
