package ru.geekbrains.java1.lesson2.homework;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // 1. задать целочисленный массив, состоящий из элементов 0 и 1. например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // с помощью цикла и условия заменить 0 на 1, 1 на 0
        invertArray();

        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями
        // 0 3 6 9 12 15 18 21
        fillArrayMult3();

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
        // умножить на 2
        changeArrayMult6();

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        fillDiag();

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
        int[][] test5 = {
                {23, 64, 1, -6, -3, 0, 35, 100, 124, -4},
                {1},
                {}
        };

        for (int i = 0; i < test5.length; i++) {
            findMinMax(test5[i]);
        }

        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        System.out.println("\nПроверка на равенство левой и правой суммы:");

        int[][] test6 = {
                {1},
                {1, 1},
                {1, 2},
                {1, 2, 3},
                {3, 2, 1},
                {1, 1, 1, 1},
                {1, 1, 1},
                {2, 2, 2, 1, 2, 2, 10, 1},
                {1, 1, 1, 2, 1}
        };

        for (int i = 0; i < test6.length; i++) {
            System.out.println(Arrays.toString(test6[i]) + " => " + checkBalance(test6[i]));
        }

        // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        int[][] shift = {
                {0, 2, 6, -5, -23},
                {2, 3, -8, 6, -17},
                {1, 3, -1, 8, -10}
        };
        int[][] test7 = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4},
                {1, 2, 3}
        };

        System.out.println("\nСдвиг массива на n, сложность О(NxN)");

        for (int i = 0; i < shift.length; i++) {
            for (int j = 0; j < shift[i].length; j++) {

                int[] test = Arrays.copyOf(test7[i], test7[i].length);

                System.out.print(Arrays.toString(test) + " n = " + shift[i][j] + " -> ");

                shiftArrayNxN(test, shift[i][j]);

                System.out.println(Arrays.toString(test));
            }
        }

        System.out.println("\nСдвиг массива на n, сложность О(N)");

        for (int i = 0; i < shift.length; i++) {
            for (int j = 0; j < shift[i].length; j++) {

                int[] test = Arrays.copyOf(test7[i], test7[i].length);

                System.out.print(Arrays.toString(test) + " n = " + shift[i][j] + " -> ");

                shiftArrayN(test, shift[i][j]);

                System.out.println(Arrays.toString(test));
            }
        }
    }

    static void invertArray() {
        System.out.println("\nИнвертировать массив:");

        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] == 1 ? 0 : 1;
        }

        System.out.println(Arrays.toString(a));
    }

    static void fillArrayMult3() {
        System.out.println("\nЗаполнить массив с мультипликатором 3:");

        int[] a = new int[8];

        for (int i = 0; i < a.length; i++) {
            a[i] = i * 3;
        }

        System.out.println(Arrays.toString(a));
    }

    static void changeArrayMult6() {
        System.out.println("\nЧисла меньшие 6 умножить на 2:");

        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6)
                a[i] *= 2;
        }

        System.out.println(Arrays.toString(a));
    }

    static void fillDiag() {
        System.out.println("\nЗаполнить диагональ таблицы единицами:");

        int n = 5;

        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            a[i][i] = 1;
            a[i][n-i-1] = 1;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    static void findMinMax(int[] a) {
        System.out.println("\nНайти минимальный и максимальный элемент массива:");

        System.out.println(Arrays.toString(a));

        int min, max;

        if (a.length > 0) {
            min = a[0];
            max = a[0];
        } else {
            min = 0;
            max = 0;
        }

        for (int i = 1; i < a.length; i++) {
            if (min > a[i])
                min = a[i];

            if (max < a[i])
                max = a[i];
        }

        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    static boolean checkBalance(int[] a) {
        if (a.length <= 1)
            return false;

        int[] leftSum = new int[a.length];
        int[] rightSum = new int[a.length];

        leftSum[0] = a[0];
        rightSum[a.length - 1] = a[a.length - 1];

        for (int i = 1, j = a.length - 2; i < a.length; i++, j--) {
            leftSum[i] = leftSum[i - 1] + a[i];
            rightSum[j] = rightSum[j + 1] + a[j];
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (leftSum[i] == rightSum[i + 1])
                return true;
        }

        return false;
    }

    // Сдвиг массива на n, если n > 0 - вправо, иначе влево
    // Вычислительная cложность O(NxN)
    static void shiftArrayNxN(int[] a, int n)
    {
        if (a.length <= 1)
            return;

        n = n % a.length;

        if (n == 0)
            return;

        if (n < 0)
            n += a.length;

        if (n > a.length / 2)
            for (int i = 0; i < a.length - n; i++) {
                shiftArrayLeft(a);
            }
        else
            for (int i = 0; i < n; i++) {
                shiftArrayRight(a);
            }
    }

    static void shiftArrayRight(int[] a)
    {
        int tmp = a[a.length-1];

        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i-1];
        }

        a[0] = tmp;
    }

    static void  shiftArrayLeft(int[] a)
    {
        int tmp = a[0];

        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i+1];
        }

        a[a.length-1] = tmp;
    }

    // Сдвиг массива на n, если n > 0 - вправо, иначе влево
    // Вычислительная cложность O(N)
    // Я не могу формально доказать, что функция корректна для всех n и a.length
    static void shiftArrayN(int[] a, int n)
    {
        if (a.length <= 1)
            return;

        n = n % a.length;

        if (n == 0)
            return;

        if (n < 0)
            n += a.length;

        int start = 0, i1 = 0, i2, count = 0;
        int tmp1 = a[i1], tmp2;

        while (count < a.length) {
            i2 = (i1 + n) % a.length;

            tmp2 = a[i2];

            a[i2] = tmp1;

            tmp1 = tmp2;
            i1 = i2;

            if (i1 == start) {
                start++;
                i1++;
                tmp1 = a[i1];
            }

            count++;
        }
    }
}
