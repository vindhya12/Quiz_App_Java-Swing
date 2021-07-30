import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Quiz extends JFrame implements ActionListener
{
    public static void main(String args[])
    {
        new Quiz("").setVisible(true);;
    }

    JButton next,submit;
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup options;    
    String q[][]=new String[10][5];
    String pans[][]=new String[10][1];
    String answers[][]=new String[10][2];
    public  int count=0;
    public static int timer=20;
    public static int ans_given=0;
    public static int score=0;
    String username;
    Quiz(String username)
    {
        this.username=username;
        setBounds(250,20,1440,1000);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);

        ImageIcon ic=new ImageIcon("icons/quiz2.jpg");
        //code to resize image
        Image i=ic.getImage();
        Image img=i.getScaledInstance(1440,420,Image.SCALE_SMOOTH);
        ic=new ImageIcon(img);
        
        JLabel jl1=new JLabel(ic);
        jl1.setBounds(0,0,1440,420);
        add(jl1);

        qno=new JLabel("");
        qno.setBounds(70,480,40,40);
        qno.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(qno);

        question=new JLabel("");
        question.setBounds(120,480,1020,40);
        question.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(question);

        q[0][0] = "Which is used to find and fix bugs in the Java programs?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";

        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which keyword is used for accessing the features of a package?";
        q[6][1] = "import";
        q[6][2] = "package";
        q[6][3] = "extends";
        q[6][4] = "export";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following option leads to the portability and security of Java?";
        q[9][1] = "Bytecode is executed by JVM";
        q[9][2] = "The applet makes the Java code secure and portable";
        q[9][3] = "Use of exception handling";
        q[9][4] = "Dynamic binding between objects";

        //Correct Answers
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1=new JRadioButton("");
        opt1.setBounds(120,580,350,40);
        opt1.setBackground(Color.ORANGE);
        //rb1.setForeground(Color.BLACK);
        opt1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(opt1);

        opt2=new JRadioButton("");
        opt2.setBounds(120,620,510,40);
        opt2.setBackground(Color.ORANGE);
        //rb1.setForeground(Color.BLACK);
        opt2.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(opt2);

        opt3=new JRadioButton("");
        opt3.setBounds(120,660,350,40);
        opt3.setBackground(Color.ORANGE);
        //rb1.setForeground(Color.BLACK);
        opt3.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(opt3);

        opt4=new JRadioButton("");
        opt4.setBounds(120,700,350,40);
        opt4.setBackground(Color.ORANGE);
        //rb1.setForeground(Color.BLACK);
        opt4.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(opt4);

        options=new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        

        next=new JButton("Next");
        next.setBounds(1150,600,170,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);
        next.addActionListener(this);


        submit=new JButton("Submit");
        submit.setBounds(1150,700,170,40);
        submit.setEnabled(false);
        submit.setFont(new Font("Tahoma",Font.PLAIN,20));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);

        start(0);

        
    
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            //calling paint method
            repaint();
            ans_given=1;
            if(options.getSelection()==null)
            {
                pans[count][0]="";
            }
            else
            {
               pans[count][0]=options.getSelection().getActionCommand(); 
            }
            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);

        }
        else if(ae.getSource()==submit)
        {
            ans_given=1;
            if(options.getSelection()==null)
                {
                    pans[count][0]="";
                }
            else
                {
                pans[count][0]=options.getSelection().getActionCommand(); 
                }

            for(int i=0;i<pans.length;i++)
                {
                    if(pans[i][0].equals(answers[i][1]))
                    {
                        score+=10;
                    }
                    else
                    {
                        score+=0;
                    }
                }
            this.setVisible(false);
            new Score(username,score).setVisible(true);
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        String time="Time left - "+timer;
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,22));
        

        if(timer>0)
        {
            g.drawString(time,1168,550);
        }
        else
        {
            g.drawString("Time Up!!",1168,550);
        }
        timer--;
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(ans_given==1)
            {
                ans_given=0;
                timer=20;
            }
        else if(timer<0)
        {
            timer=20;
            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            else if(count==9)
            {
                if(options.getSelection()==null)
                {
                    pans[count][0]="";
                }
                else
                {
                pans[count][0]=options.getSelection().getActionCommand(); 
                }

                for(int i=0;i<pans.length;i++)
                {
                    if(pans[i][0].equals(answers[i][1]))
                    {
                        score+=10;
                    }
                    else
                    {
                        score+=0;
                    }
                }
                this.setVisible(false);
                new Score(username,score).setVisible(true);
            }
            else
            {
                if(options.getSelection()==null)
                {
                    pans[count][0]="";
                }
                else
                {
                pans[count][0]=options.getSelection().getActionCommand(); 
                }
                count++;
                start(count);

            }
        }
    }

    public void start(int count)
    {
        qno.setText(""+(count+1)+".");
        question.setText(q[count][0]);
        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        options.clearSelection();


    }

}