import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JPanel implements ActionListener {
    JButton reset;
    JButton button[] = new JButton[9];
    boolean myTurn;

    public Buttons()
    {
        myTurn=true;
        setLayout(new GridLayout(4,3));

        for(int i=0;i<button.length;i++)
        {
            
            button[i] = new JButton("");
            add(button[i]);
            button[i].setBackground(Color.WHITE);
            button[i].addActionListener(this);
        }

        reset = new JButton("RESET");
        reset.setBackground(Color.WHITE);
        reset.addActionListener(this);
        add(reset);
    

    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //  System.out.println("aaa");
        Object source = e.getSource();

        for(int i=0;i<button.length;i++)
        {
            
            if(source == button[i]){
                if(myTurn)
                {
                    button[i].setText("O");
                }
                else{
                    button[i].setText("X");
                }
                button[i].setEnabled(false);
                
            }
            
        }

        if(source==reset)
        {
            for(int i=0;i<button.length;i++)
            {
                button[i].setText("");
                button[i].setEnabled(true);
                button[i].setBackground(Color.WHITE);
            }
        }

        checkResult();


        myTurn = !myTurn;
    }

    public void setEnabledButtons(boolean setEnable)
    {
        for(int i=0;i<button.length;i++)
        {
            button[i].setEnabled(setEnable);
        }
    }

    public void checkResult()
    {
        String[] ch = new String[9];
        int[] id = new int[9];
        for(int i = 0; i < 9; i++)
        {
            ch[i] = button[i].getText();
            id[i] = i;
        }

        if(ch[0].equals(ch[1]) && ch[1].equals(ch[2]) && ch[0] != "")
        {
            button[id[0]].setBackground(Color.GREEN);
            button[id[1]].setBackground(Color.GREEN);
            button[id[2]].setBackground(Color.GREEN);
            setEnabledButtons(false);
        }

       
        if(ch[3].equals(ch[4]) && ch[4].equals(ch[5]) && ch[3] != "")
        {
            button[id[3]].setBackground(Color.GREEN);
            button[id[4]].setBackground(Color.GREEN);
            button[id[5]].setBackground(Color.GREEN);
            setEnabledButtons(false);
        }

       
        if(ch[6].equals(ch[7]) && ch[7].equals(ch[8]) && ch[6] != "")
        {
            button[id[6]].setBackground(Color.GREEN);
            button[id[7]].setBackground(Color.GREEN);
            button[id[8]].setBackground(Color.GREEN);
            setEnabledButtons(false);
        }
        
        if(ch[0].equals(ch[4]) && ch[4].equals(ch[8]) && ch[0] != "")
        {
            button[id[0]].setBackground(Color.GREEN);
            button[id[4]].setBackground(Color.GREEN);
            button[id[8]].setBackground(Color.GREEN);
            setEnabledButtons(false);
        }

        if(ch[2].equals(ch[4]) && ch[4].equals(ch[6]) && ch[2] != "")
        {
            button[id[2]].setBackground(Color.GREEN);
            button[id[4]].setBackground(Color.GREEN);
            button[id[6]].setBackground(Color.GREEN);
            setEnabledButtons(false);
        }

        if(ch[0].equals(ch[3]) && ch[3].equals(ch[6]) && ch[0] != "")
        {
            button[id[0]].setBackground(Color.GREEN);
            button[id[3]].setBackground(Color.GREEN);
            button[id[6]].setBackground(Color.GREEN);
            setEnabledButtons(false);
        }

        if(ch[1].equals(ch[4]) && ch[4].equals(ch[7]) && ch[1] != "")
        {
            button[id[1]].setBackground(Color.GREEN);
            button[id[4]].setBackground(Color.GREEN);
            button[id[7]].setBackground(Color.GREEN);
            setEnabledButtons(false);
        }

        if(ch[2].equals(ch[5]) && ch[5].equals(ch[8]) && ch[2] != "")
        {
            button[id[2]].setBackground(Color.GREEN);
            button[id[5]].setBackground(Color.GREEN);
            button[id[8]].setBackground(Color.GREEN);
            setEnabledButtons(false);
        }

    }
}
