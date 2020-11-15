package ru.geekbrains.java1.lesson5.homework;

public class App
{
    public static void main(String[] args)
    {
//      Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
//      Конструктор класса должен заполнять эти поля при создании объекта;
//      Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
//      Создать массив из 5 сотрудников
//
//      Пример:
//      Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//      persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//      persArray[1] = new Person(...);
//      ...
//      persArray[4] = new Person(...);
//      С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

        Employee employee = new Employee("Иван Иванов", 28,"Менеджер", "ivan@mail.com", "+79835834567", 10000);

        Employee[] employees = new Employee[] {
            new Employee("Иван Иванов", 28,"Менеджер", "ivan@mail.com", "+79835834567", 10000),
            new Employee("Петр Петров", 45,"Менеджер", "petrovp@gmail.com", "+79837240865", 11000),
            new Employee("Блинов Юрий", 41,"Бухгалтер", "yura1974@mail.ru", "+79048345634", 12000),
            new Employee("Максимов Антон", 34,"Программист", "maks.ant.241@gmail.com", "+79127630629", 13000),
            new Employee("Андреев Антон", 50,"Директор", "andryha1974@mail.ru", "+79033452397", 20000),
        };

        System.out.println("Сотрудники старше 40 лет:");

        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i].getAge() > 40)
            {
                employees[i].printStdout();
            }
        }
    }
}
