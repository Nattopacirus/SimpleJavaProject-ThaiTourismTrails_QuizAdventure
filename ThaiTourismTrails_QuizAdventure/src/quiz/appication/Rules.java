package quiz.appication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener {
    
    String name;
    JButton start, back;
    
    
    public Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
      
        //subHeading
        JLabel subHeading = new JLabel("Welcome,"+name+".  Here is a rule:");
        subHeading.setBounds(40, 10, 700, 30);
        subHeading.setFont(new Font("Playfair Display", Font.BOLD, 18));
        subHeading.setBackground(Color.decode("#211A14"));
        add(subHeading);
        //heading 
        JLabel heading = new JLabel("Rules of Thai Tourism Trails: Quiz Adventure");
        heading.setBounds(40, 40, 700, 30);
        heading.setFont(new Font("Playfair Display", Font.BOLD, 28));
        heading.setBackground(Color.decode("#211A14"));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setBackground(Color.decode("#211A14"));
        rules.setText(
            "<html>" + 
                "<b>Answering Questions:</b><br>" +
                "1. Players must answer each question continuously without skipping any.<br>" +
                "2. Each question must be answered with only one choice.<br><br>" +
                
                "<b>Using Lifeline:</b><br>" +
                "1. The \"50-50\" Lifeline can be used only once.<br>" +
                "2. When using the Lifeline, players will receive assistance in reducing the answer choices to only two.<br>" +
                "3. The purpose of using the Lifeline is to assist players in answering questions more easily, rather than providing the correct answer.<br><br>" +
                
                "<b>Ending the Game:</b><br>" +
                "1. When players have answered all the questions, or pressed the \"Submit\" button, the game will end.<br>" +
                "2. Players will receive points for correct answers, and the total score will be counted and displayed on the summary page.<br><br>" +
                
                "<b>Playing Again:</b><br>" +
                "1. After the game ends, players can play again by pressing the \"Play Again\" button.<br><br>" +
                
                "<b>Exiting the Game:</b><br>" +
                "1. Players can exit the game and close the program by pressing the \"Exit\" button.<br><br>" +
                
                "<b>Recommendations:</b><br>" +
                "1. While playing, it is recommended that players use their time wisely to think and answer the questions correctly.<br>" +
                "2. It is recommended that players follow the rules and use the Lifeline correctly and effectively.<br><br>" +
                
                "<b>Note:</b> The administrators reserve the right to change or modify the rules without prior notice.<br><br>" +
                "<b>Good Luck :)</b>"+
            "<html>"
        );
        
        JScrollPane scrollPane = new JScrollPane(rules);
        scrollPane.setBounds(20, 90, 700, 350);
        add(scrollPane);

        // Center JLabel rules
        rules.setVerticalAlignment(SwingConstants.CENTER);
        rules.setHorizontalAlignment(SwingConstants.CENTER);

        // Back button
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(Color.decode("#644E37"));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        // Start button
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(Color.decode("#644E37"));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        setSize(800, 650);
        setLocation(300, 150);
        setResizable(false); // Lock Resolution
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Rules("User");
    }
}
