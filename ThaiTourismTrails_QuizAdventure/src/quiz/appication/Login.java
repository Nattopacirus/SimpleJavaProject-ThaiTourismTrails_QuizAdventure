package quiz.appication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    JButton enter,exit;
    JTextField tfname;
    

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //image 1
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,600,480);
        add(image);
        
        //SubHeading
        JLabel Subheading = new JLabel("Thai Tourism Trails :");
        Subheading.setBounds(810,40,400,50);
        Subheading.setFont(new Font("Playfair Display",Font.BOLD,18));
        Subheading.setBackground(Color.decode("#211A14"));//
        add(Subheading);
          
        //label 1
        JLabel heading = new JLabel("Quiz Adventure");
        
        heading.setBounds(705,80,400,50);
        heading.setFont(new Font("Playfair Display",Font.BOLD,50));
        heading.setBackground(Color.decode("#211A14"));
        add(heading);
        
        //Label 2
        JLabel name = new JLabel("Enter your name");
        name.setBounds(810,150,300,20);
        name.setFont(new Font("Forum",Font.BOLD,18));
        name.setBackground(Color.decode("#211A14"));
        add(name);
        
        //Text Field
        tfname = new JTextField();
        tfname.setBounds(735,200,300,25);
        tfname.setFont(new Font("Forum",Font.BOLD,20));
        add(tfname);
        
        //Button 1
        enter = new JButton("Enter");
        enter.setBounds(735, 270, 120, 25);
        enter.setBackground(Color.decode("#644E37"));//#644E37
        enter.setForeground(Color.WHITE);
        enter.addActionListener(this);
        add(enter);
        // Key Bindings(Enter)
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "rulesPressed");
        actionMap.put("rulesPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enter.doClick();
            }
        });
        
        //Button 2
        exit = new JButton("Exit");
        exit.setBounds(915, 270, 120, 25);
        exit.setBackground(Color.decode("#644E37"));
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        //set size
        setSize(1200,500);
        setLocation(200,150);
        setResizable(false); // Lock Resolution
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == enter) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == exit) {
            //Exit app
            System.exit(0);
        }
    }

    
    public static void main(String[] args) {
        new Login();
    }
}
