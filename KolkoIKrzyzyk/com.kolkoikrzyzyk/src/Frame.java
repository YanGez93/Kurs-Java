import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
   
    public Frame()
    {
        JPanel buttonPanel = new Buttons();
        add(buttonPanel);
        
        setVisible(true);
        super.setTitle("Kółko i krzyżyk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setLocation(300,300);
       
        


    }
    
}
