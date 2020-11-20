package ru.geekbrains.java1.lesson8.homework;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class MainPanel extends JPanel implements ActionListener
{
    public MainPanel()
    {
        super(new FlowLayout(FlowLayout.LEFT));

        JButton btn = new JButton("Кнопка");
        JCheckBox checkBox = new JCheckBox("Флажок");

        JRadioButton radioYesButton = new JRadioButton("Да");
        JRadioButton radioNoButton = new JRadioButton("Нет");
        JRadioButton radioDontNowButton = new JRadioButton("Не знаю");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioYesButton);
        buttonGroup.add(radioNoButton);
        buttonGroup.add(radioDontNowButton);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3, 1));
        radioPanel.add(radioYesButton);
        radioPanel.add(radioNoButton);
        radioPanel.add(radioDontNowButton);
        radioPanel.setBorder(new TitledBorder("Уверен?"));

        add(btn);
        add(checkBox);
        add(radioPanel);

        for (Component component : getAllChildComponents(this))
        {
            if (component instanceof AbstractButton)
                ((AbstractButton)component).addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        String props = "None";

        if (source instanceof JToggleButton)
        {
            JToggleButton toggleButton = (JToggleButton) source;

            props = toggleButton.isSelected() ? "selected" : "not selected";
        }

        System.out.printf("Action : %s : %s : %s%n", source.getClass().getName(), e.getActionCommand(), props);
    }

    // рекурсивная функция получения всех дочерних компонентов контейнера
    protected List<Component> getAllChildComponents(Container container)
    {
        List<Component> result = new LinkedList<>();

        for (Component component : container.getComponents())
        {
            result.add(component);

            if (component instanceof Container)
            {
                result.addAll(getAllChildComponents((Container)component));
            }
        }

        return result;
    }
}
