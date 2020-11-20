package ru.geekbrains.java1.lesson8.homework;

import javax.swing.*;

public class App
{
    // вывод в консоль информации о компонентах AbstractButton с общим ActionListener
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MainWindow();
            }
        });
    }
}
