package com.oib.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginForm extends JFrame implements ActionListener
{
    JButton jB;
    JPanel newPanel;
    JLabel candidateLabel, passwordLabel;
    final JTextField  textField1, textField2;
    LoginForm()
    {
        candidateLabel = new JLabel();
        candidateLabel.setText("    Candidate Name :");
        textField1 = new JTextField(15);
        passwordLabel = new JLabel();
        passwordLabel.setText("    Password :");
        textField2 = new JPasswordField(8);
        jB = new JButton("   Login   ");
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(candidateLabel);
        newPanel.add(textField1);
        newPanel.add(passwordLabel);
        newPanel.add(textField2);
        newPanel.add(jB);
        add(newPanel, BorderLayout.CENTER);
        jB.addActionListener(this);
        setTitle("Exam Login Form ");
    }
    public void actionPerformed(ActionEvent ae)
    {
        String candidateValue = textField1.getText();
        String passwordValue = textField2.getText();
        if(!passwordValue.equals(""))
            new ExamForm(candidateValue);
        else{
            textField2.setText("Enter Password");
            actionPerformed(ae);
        }
    }
}
