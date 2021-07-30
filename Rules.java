import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener
{
    

    public static void main(String args[])
    {
        new Rules("");       

    }
    String username;
    JButton back,start;
    public Rules(String username)
    {
        this.username=username;
        setBounds(300,100,800,650);
        getContentPane().setBackground(Color.ORANGE);

        setLayout(null);

        JLabel jl1=new JLabel("Welcome "+username+" to the Quiz");
        jl1.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
        jl1.setBounds(100,1,700,100);
        add(jl1);

        JLabel jl2=new JLabel("");
        jl2.setFont(new Font("Tahoma",Font.PLAIN,20));
        jl2.setBounds(70,100,600,400);
        jl2.setText(
            "<html>"+
                "Rules"+"<br><br>"+
                "1. All the questions in the quiz are compulsory to attend."+"<br><br>"+
                "2. Each question consists of 1 mark."+"<br><br>"+
                "3. Do not try to cheat."+"<br><br>"+
                "4. Please read all the questions carefully"+"<br><br>"+
                "5. Each question will have a time limit of 20 seconds"+"<br><br>"+
                "6. Do not peak on your neighbours answers"+"<br><br>"+
                "   ALL THE BEST"+"<br><br>"+
            "<html>"
        );
        add(jl2);

        back=new JButton("Back");
        back.setBounds(250,500,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);

        start=new JButton("Start");
        start.setBounds(450,500,100,30);
        start.setBackground(Color.BLACK);
        start.setForeground(Color.WHITE);
        add(start);
        start.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            this.setVisible(false);
            new QuizTime().setVisible(true);

        }
        else if(ae.getSource()==start)
        {
            this.setVisible(false);
            new Quiz(username).setVisible(true);

        }
    }
    
}

