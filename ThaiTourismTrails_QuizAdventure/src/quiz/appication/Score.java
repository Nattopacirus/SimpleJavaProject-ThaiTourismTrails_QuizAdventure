
package quiz.appication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Score extends JFrame implements ActionListener{
    JButton playAgain,exitButton;
    
    public Score(String name,int score) {
        setBounds(400,150,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        //image 1
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,5,360,500);
        add(image);
        
        //Score
        JLabel lblscore = new JLabel("Your score is "+score);
        lblscore.setBounds(425, 200,700,40);
        lblscore.setFont(new Font("Playfair Display",Font.BOLD,32));
        add(lblscore);
        
        //Play again button
        playAgain = new JButton("Play Again");
        playAgain.setBounds(470,270,120,30);
        playAgain.setBackground(Color.decode("#644E37"));
        playAgain.setForeground(Color.WHITE);
        playAgain.addActionListener(this);
        add(playAgain);
        
        //Exit button
        exitButton = new JButton("Exit");
        exitButton.setBounds(640,450,80,30);
        exitButton.setBackground(Color.red);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(this);
        add(exitButton);
        
        setVisible(true);
        setResizable(false); // Lock Resolution
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == playAgain){
            setVisible(false);
            new Login();
        }
        else if(ae.getSource() == exitButton){
            //Exit app
            System.exit(0);
        }
        
    }
    
    public static void main(String[] args) {
        new Score("User",0);
    }
}
