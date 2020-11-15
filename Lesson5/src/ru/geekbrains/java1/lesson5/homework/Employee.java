package ru.geekbrains.java1.lesson5.homework;

public class Employee
{
    private String name;
    private int age;
    private String position;
    private String email;
    private String phone;
    private double salary;

    public Employee(String name, int age, String position, String email, String phone, double salary)
    {
        this.name = name;
        this.age = age;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getPosition()
    {
        return position;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhone()
    {
        return phone;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        if (salary < 0)
        {
            System.out.println("Некорректная зарплата");

            return;
        }

        this.salary = salary;
    }

    public void printStdout()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("ФИО: " + name);
        sb.append(", Возраст: " + age);
        sb.append(", Должность: " + position);
        sb.append(", E-mail: " + email);
        sb.append(", Телефон: " + phone);
        sb.append(", Зарплата: " + salary);

        System.out.println(sb);
    }
}
