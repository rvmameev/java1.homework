package ru.geekbrains.java1.lesson8.homework;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame
{
    public MainWindow() throws HeadlessException
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(new MainPanel());

//        setLayout(new FlowLayout(FlowLayout.LEFT));

        Dimension dimWindow = new Dimension(500, 400);
        setSize(dimWindow);
        Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dimScreen.width - dimWindow.width)/2, (dimScreen.height - dimWindow.height)/2);
//
//        JPanel mainPanel = new JPanel(new GridBagLayout());
//
//        JTextField textField = new JTextField(20);
////        textField.addActionListener(this);
//
//        JTextArea textArea = new JTextArea(5, 20);
//        textArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(textArea);
//
//        //Add Components to this panel.
//        GridBagConstraints c = new GridBagConstraints();
//        c.gridwidth = GridBagConstraints.REMAINDER;
//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        mainPanel.add(textField, c);

//        c.fill = GridBagConstraints.BOTH;
//        c.weightx = 1.0;
//        c.weighty = 1.0;
//        mainPanel.add(scrollPane, c);

//        JPanel componentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        JPanel logPanel = new JPanel(new FlowLayout());
//
//        JTextArea logTextArea = new JTextArea();
//        logTextArea.setMinimumSize(new Dimension(300, 400));
//
//        JButton btn = new JButton("button");
//        btn.addActionListener(e -> {
//            logTextArea.append(e.toString() + "\n");
//        });
//
//
//        componentPanel.add(btn);
//
//        logTextArea.setPreferredSize(new Dimension(300, 500));
//
//        logPanel.add(logTextArea);
//
//        mainPanel.add(componentPanel);
//        mainPanel.add(logPanel);

//        add(mainPanel);

        setVisible(true);
    }
}
