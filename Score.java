import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Score extends JFrame implements ActionListener{
    public static void main(String args[]){
        new Score("",0).setVisible(true);

    }

    String username;
    int score;
    Score(String username,int score){
        this.username=username;
        setBounds(250,150,1500,650);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);

        ImageIcon ic=new ImageIcon("icons/score.jpg");
        //to resize the image
        Image i=ic.getImage();
        Image img=i.getScaledInstance(530,625,Image.SCALE_SMOOTH);
        ic=new ImageIcon(img);

        //set image in lebel
        JLabel jl1=new JLabel(ic);
        jl1.setBounds(0,0,530,625);
        add(jl1);

        JLabel jl2=new JLabel("Thank You "+username);
        jl2.setFont(new Font("Gill Sans Nova Ultra Bold",Font.PLAIN,40));
        jl2.setForeground(Color.BLACK);
        jl2.setBounds(650,100,780,50);
        add(jl2);

        JLabel jl3=new JLabel("Your Score - "+score);
        jl3.setFont(new Font("Jokerman",Font.BOLD,30));
        jl3.setForeground(Color.RED);
        jl3.setBounds(910,230,380,40);
        add(jl3);

        JButton replay=new JButton("Home");
        //replay.setFont(new Font("Times New Roman",Font.BOLD,25));
        replay.setBackground(Color.BLACK);
        replay.setForeground(Color.WHITE);
        replay.setBounds(950,350,150,30);
        add(replay);
        replay.addActionListener(this);


    }

    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new QuizTime().setVisible(true);

    }


}