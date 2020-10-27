package ru.geekbrains.java1.lesson1.homework;

import javax.sound.midi.Soundbank;

public class App
{
    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args)
    {
        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte b = 1;
        short s = 12;
        int i = 0;
        long l;
        l = 1234;

        float f = 29.5f;
        double d;
        d = 23.7;

        char ch = 'A';

        boolean flag = true;

        // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        // где a, b, c, d – входные параметры этого метода;
        System.out.println("Вычисление a*(b + c/d):");
        System.out.println(evalABCD(1, 2, 3, 4));
        System.out.println(evalABCD(10, 11, 12.4, 34.2));
        System.out.println(evalABCD(1, 2, 3, 0d));
        System.out.println(evalABCD(1, 2, 3, -0d));

        // 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
        // от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        System.out.println("\nПроверка суммы на диапазон [10, 20]:");
        System.out.println(sumInRange(5, 5));
        System.out.println(sumInRange(5.0, 5.0));
        System.out.println(sumInRange(-10, 10));
        System.out.println(sumInRange(10, 10));
        System.out.println(sumInRange(10, 10.01));

        // 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
        // в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
        System.out.println("\nВывод знака числа:");
        printNumberSign(0);
        printNumberSign(-1);
        printNumberSign(10);

        // 6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
        // если число отрицательное;
        System.out.println("\nПроверка отрицательных чисел:");
        System.out.println(isNegative(1));
        System.out.println(isNegative(-1));
        System.out.println(isNegative(0));

        // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        System.out.println("\nПриветствия:");
        printHello("Петя");
        printHello("Ваня");

        // 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        System.out.println("\nПроверка на високосный год:");
        yearIsLeap(2019);
        yearIsLeap(2020);
        yearIsLeap(2000);
        yearIsLeap(1900);
        yearIsLeap(1600);
    }

    static double evalABCD(double a, double b, double c, double d)
    {
        return a*(b + c/d);
    }

    static boolean sumInRange(double a, double b)
    {
        double c = a + b;

        return c >= 10 && c <= 20;
    }

    static void printNumberSign(int number)
    {
        if (number >= 0)
            System.out.println(number + " - положительное число");
        else
            System.out.println(number + " - отрицательное число");
    }

    static boolean isNegative(int number)
    {
        return number < 0;
    }

    static void printHello(String name)
    {
        System.out.println("Привет, " + name + "!");
    }

    static void yearIsLeap(int year)
    {
        boolean isLeap;

        if (year % 100 == 0)
            isLeap = year % 400 == 0;
        else
            isLeap = year % 4 == 0;

        System.out.println(year + " - " + (isLeap ? "" : "не ") + "високосный год");
    }
}
