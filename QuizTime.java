import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class QuizTime extends JFrame implements ActionListener
{  
    public static void main(String args[])
    {
        new QuizTime();
    }
    
    JButton b1,b2;
    JTextField tx1;
    
    QuizTime()
    {
        setBounds(300,200,1200,500);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);

        ImageIcon ic=new ImageIcon("icons/quiz.jpg");
        //code to resize image
        Image i=ic.getImage();
        Image img=i.getScaledInstance(600,470,Image.SCALE_SMOOTH);
        ic=new ImageIcon(img);
        


        JLabel jl1=new JLabel(ic);
        jl1.setBounds(0,0,600,470);
        add(jl1);
        

        JLabel jl2=new JLabel("Quiz Time");
        jl2.setFont(new Font("Gill Sans Nova Ultra Bold",Font.BOLD,40));
        jl2.setForeground(Color.BLACK);
        jl2.setBounds(770,50,300,45);
        add(jl2);

        JLabel jl3=new JLabel("Enter user Name");
        jl3.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        jl3.setForeground(Color.BLACK);
        jl3.setBounds(830,148,300,20);
        add(jl3);

        tx1=new JTextField(); 
        tx1.setBounds(745,200,300,25);
        tx1.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tx1);
        tx1.addActionListener(this);

        b1=new JButton("Rules");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(745,250,100,25);
        add(b1);
        b1.addActionListener(this);
        

        b2=new JButton("Exit");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(942,250,100,25);
        add(b2);
        b2.addActionListener(this);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String name=tx1.getText();
            //to close the index frame
            this.setVisible(false);
            //call another java file class constructor 
            new Rules(name);
        }
        else
        {
            System.exit(0);

        }
    }    
    

}

    
