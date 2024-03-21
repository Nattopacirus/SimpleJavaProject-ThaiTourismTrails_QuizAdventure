
package quiz.appication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener{

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];    
    String useranswers[][] = new String[10][1];
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup groupOpitions;
    JButton next,submit,lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    Quiz(String name) {
        this.name = name;
        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //image 1
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1440,392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450,50,30);
        qno.setFont(new Font("Tohama",Font.PLAIN,22));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450,900,30);
        question.setFont(new Font("Tohama",Font.PLAIN,22));
        add(question);
        
        questions[0][0] = "What is the traditional Thai New Year celebration called?";
        questions[0][1] = "Songkran";
        questions[0][2] = "Loy Krathong";
        questions[0][3] = "Thai Pongal";
        questions[0][4] = "Vesak";

        questions[1][0] = "Which Thai city is famous for its floating markets?";
        questions[1][1] = "Bangkok";
        questions[1][2] = "Pattaya";
        questions[1][3] = "Chiang Mai";
        questions[1][4] = "Damnoen Saduak Market";

        questions[2][0] = "What is the name of the famous Thai dish consisting of stir-fried rice noodles?";
        questions[2][1] = "Pad Thai";
        questions[2][2] = "Green Curry";
        questions[2][3] = "Som Tum";
        questions[2][4] = "Tom Yum";

        questions[3][0] = "Which Thai festival is celebrated during the full moon of the twelfth lunar month?";
        questions[3][1] = "Songkran";
        questions[3][2] = "Loy Krathong";
        questions[3][3] = "Thai Pongal";
        questions[3][4] = "Vesak";

        questions[4][0] = "What is the capital city of Thailand?";
        questions[4][1] = "Bangkok";
        questions[4][2] = "Phuket";
        questions[4][3] = "Chiang Mai";
        questions[4][4] = "Pattaya";

        questions[5][0] = "Which Thai island is known for its vibrant nightlife and full moon parties?";
        questions[5][1] = "Koh Samui";
        questions[5][2] = "Phuket";
        questions[5][3] = "Koh Phi Phi";
        questions[5][4] = "Koh Phangan";

        questions[6][0] = "What is the name of the historical park in Thailand featuring ruins of ancient temples?";
        questions[6][1] = "Ayutthaya Historical Park";
        questions[6][2] = "Sukhothai Historical Park";
        questions[6][3] = "Khao Sok National Park";
        questions[6][4] = "Erawan National Park";

        questions[7][0] = "Which river is considered the lifeline of Bangkok?";
        questions[7][1] = "Chao Phraya River";
        questions[7][2] = "Mekong River";
        questions[7][3] = "Ping River";
        questions[7][4] = "Nan River";

        questions[8][0] = "What is the traditional Thai greeting?";
        questions[8][1] = "Sawatdee";
        questions[8][2] = "Aloha";
        questions[8][3] = "Namaste";
        questions[8][4] = "Konnichiwa";

        questions[9][0] = "Which Thai festival is known for its release of decorated baskets into rivers and lakes?";
        questions[9][1] = "Songkran";
        questions[9][2] = "Loy Krathong";
        questions[9][3] = "Thai Pongal";
        questions[9][4] = "Vesak";

        answers[0][1] = "Songkran";
        answers[1][1] = "Damnoen Saduak Market";
        answers[2][1] = "Pad Thai";
        answers[3][1] = "Loy Krathong";
        answers[4][1] = "Bangkok";
        answers[5][1] = "Koh Phangan";
        answers[6][1] = "Ayutthaya Historical Park";
        answers[7][1] = "Chao Phraya River";
        answers[8][1] = "Sawatdee";
        answers[9][1] = "Loy Krathong";

        
        //Option 1
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);
        //Option 2
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);
        //Option 3
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);
        //Option 4
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);
        
        //Group Option
        groupOpitions = new ButtonGroup();
        groupOpitions.add(opt1);
        groupOpitions.add(opt2);
        groupOpitions.add(opt3);
        groupOpitions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100,550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 LifeLine");
        lifeline.setBounds(1100,630,200,40);
        lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
        lifeline.setBackground(new Color(30,144,255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100,710,200,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        
        
        Start(count);
        
        setResizable(false); // Lock Resolution
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            //repaint
            repaint();
            //reset options
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            //set ans_given
            ans_given = 1;
            if(groupOpitions.getSelection() == null){
                //not select
                useranswers[count][0] = "";
            }else{
                //select option --> get user anwser
                useranswers[count][0] = groupOpitions.getSelection().getActionCommand();
            }
            
            if(count == 8){
                //if count is 8 but question is 9(already pass number now is number 10)
                //close next button
                next.setEnabled(false);
                //open submit button
                submit.setEnabled(true);
            }
            
            count++;
            Start(count);
        }
        else if(ae.getSource() == lifeline){
            if(count == 2 || count == 4 || count == 6 || count == 8 || count == 10){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }else{
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            //use only 1 time
            lifeline.setEnabled(false);
        }
        else if(ae.getSource() == submit){
            ans_given = 1;
            if(groupOpitions.getSelection() == null){
                //not select
                useranswers[count][0] = "";
            }else{
                //select option --> get user anwser
                useranswers[count][0] = groupOpitions.getSelection().getActionCommand();
            }
            
            //Check all Answer
            for(int i = 0;i < useranswers.length;i++){
                if(useranswers[i][0].equals(answers[i][1])){
                    //CORRECT
                    score += 1;
                }
                else{
                    //WRONG
                    score += 0;
                }
            }
            setVisible(false);
            //score
            new Score(name,score);
            //reset count
            count = 0;
            System.out.println("reset count");
            System.out.println("now count = "+count);
        }
       
    }
    
    public void paint(Graphics g){
        super.paint(g);
        //timer
        String time = "Time left "+ timer + " seconds";// 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,25));
        
        if(timer > 0){
            g.drawString(time, 1100, 500);
        }else{
            g.drawString("Times up!!!", 1100, 500);
        }
        
        timer--;
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(ans_given == 1){
            //when already pass next or submit button 
            //reset options and start new timer
            ans_given = 0;
            timer = 15;
        }else if(timer < 0){
            //time up
            //set new timer
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if(count == 8){
                //Pass Question number 9 (now display question number 10)
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){//submit button
                if(groupOpitions.getSelection() == null){
                    useranswers[count][0] = "";
                }else{
                    useranswers[count][0] = groupOpitions.getSelection().getActionCommand();
                }
                
                //check anwser
                for(int i = 0;i < useranswers.length;i++){
                    if(useranswers[i][0].equals(answers[i][1])){
                        score += 1;
                    } else{
                        score += 0;
                    }
                }
                setVisible(false);
                //Score
                new Score(name,score);
                
                
            }
            else{
                //next button
                if(groupOpitions.getSelection() == null){
                    //dont select anwser
                    useranswers[count][0] = "";
                }else{
                    //select answer
                    useranswers[count][0] = groupOpitions.getSelection().getActionCommand();
                }
            count++;
            
            //start new number question
            Start(count);
            }
        }
    }
    
    public void Start(int count){
        System.err.println("Now Count = "+count);
        
        qno.setText(""+ (count + 1) +". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupOpitions.clearSelection();
        
    }
    
    
    public static void main(String[] args){
        new Quiz("User");
    }
}
