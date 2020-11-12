package ru.geekbrains.java1.lesson4.homework;

import java.util.Random;
import java.util.Scanner;

public class App
{
    // символы фишек для поля
    final static char DOT_EMPTY = '•';
    final static char DOT_HUMAN = 'X';
    final static char DOT_AI = 'O';

    // игровое поле
    static char[][] map;

    // размер игрового поля
    static int mapSize;

    // длина цепочки фишек для выигрыша
    static int winLength;

    // уровень ИИ
    static int aiLevel;

    public static void main(String[] args)
    {
//        1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
//
//        2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например,
//        с использованием циклов.
//
//        3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и победного ряда 4
//        (по вертикали/горизонтали/диагонали). Очень желательно не делать это просто набором условий для каждой
//        из возможных ситуаций;
//
//        4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

        playTicTacToe();
    }

    static void playTicTacToe()
    {
        System.out.println("Игра \"Крестики-нолики\"");

        mapSize = getIntFromStdin("Введите размер поля для игры (от 2 до 9):", 2, 9);

        winLength = getIntFromStdin("Введите длину цепочки выигрыша (от 2 до " + mapSize + "):", 2, mapSize);

        aiLevel = getIntFromStdin("Введите уровень игры ИИ (0 - случайные ходы, 1 - блокировка выигрыша игрока):", 0, 1);

        initMap();

        printMap();

        while (true)
        {
            humanTurn();

            printMap();

            if (isWin(DOT_HUMAN))
            {
                System.out.println("Вы выиграли!");

                break;
            }

            if (getEmptyCellsCount() == 0)
            {
                System.out.println("Ничья!");

                break;
            }

            aiTurn();

            printMap();

            if (getEmptyCellsCount() == 0)
            {
                System.out.println("Ничья!");

                break;
            }

            if (isWin(DOT_AI))
            {
                System.out.println("Выиграл ИИ!");

                break;
            }
        }
    }

    static int getIntFromStdin(String message, int min, int max)
    {
        int inputInt = min - 1;

        Scanner scanner = new Scanner(System.in);

        do
        {
            System.out.println(message);

            if (scanner.hasNextInt())
            {
                inputInt = scanner.nextInt();

                if (inputInt < min || inputInt > max)
                    System.out.println("Введите число от " + min + " до " + max + "!");
            }

            scanner.nextLine();

        } while (inputInt < min || inputInt > max);

        return inputInt;
    }

    static void initMap()
    {
        map = new char[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++)
            for (int j = 0; j < mapSize; j++)
                map[i][j] = DOT_EMPTY;
    }

    static void printMap()
    {
        System.out.print("\\");

        for (int i = 0; i < mapSize; i++)
            System.out.print(" " + (i + 1));

        System.out.println();

        for (int i = 0; i < mapSize; i++)
        {
            System.out.print(i + 1);

            for (int j = 0; j < mapSize; j++)
                System.out.print(" " + map[i][j]);

            System.out.println();
        }
    }

    static void humanTurn()
    {
        int x = -1;
        int y = -1;

        Scanner scanner = new Scanner(System.in);

        do
        {
            System.out.print("Введите координаты X Y: ");

            if (scanner.hasNextInt())
                x = scanner.nextInt() - 1;
            else
            {
                scanner.nextLine();

                continue;
            }

            if (scanner.hasNextInt())
                y = scanner.nextInt() - 1;
            else
            {
                scanner.nextLine();

                continue;
            }

            scanner.nextLine();

        } while (!isValidMapCell(x, y));

        map[y][x] = DOT_HUMAN;
    }

    static void aiTurn()
    {
        switch (aiLevel)
        {
            case 0:
                aiTurnRandom();
                break;
            case 1:
                aiTurnBlockHuman();
                break;
            default:
                System.out.println("Уровень игры ИИ не реализован!");
                System.exit(-1);
        }

    }

    // ход ИИ, ход в случайную пустую клетку
    static void aiTurnRandom()
    {
        int emptyCount = getEmptyCellsCount();

        if (emptyCount == 0)
            return;

        Random random = new Random();

        int aiRandom = random.nextInt(emptyCount);

        int counter = -1;

        for (int i = 0; i < mapSize; i++)
            for (int j = 0; j < mapSize; j++)
            {
                if (map[i][j] == DOT_EMPTY)
                    counter++;

                if (counter == aiRandom)
                {
                    map[i][j] = DOT_AI;

                    System.out.println("Ход компьютера X Y: " + (j + 1) + " " + (i + 1));

                    return;
                }
            }

    }

    // ход ИИ, блокирование выигрыша человека
    static void aiTurnBlockHuman()
    {
        int[][] weights = getMapWeights(App.DOT_HUMAN);

        int maxWeight = 0;

        for (int i = 0; i < mapSize; i++)
        {
            for (int j = 0; j < mapSize; j++)
            {
                if (maxWeight < weights[i][j])
                    maxWeight = weights[i][j];
            }
        }

        // ИИ ходит в клетку с наибольшим весом.
        for (int i = 0; i < mapSize; i++)
        {
            for (int j = 0; j < mapSize; j++)
            {
                if (maxWeight == weights[i][j])
                {
                    map[i][j] = DOT_AI;

                    System.out.println("Ход компьютера X Y: " + (j + 1) + " " + (i + 1));

                    return;
                }
            }
        }
    }

    // Таблица весов для типа фишки (игрок или ИИ). Вес клетки - общее сумма расстояний подряд идущих фишек
    // определенного типа во все направления из клетки до.
    static int[][] getMapWeights(char dot)
    {
        int[][] weights = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++)
        {
            for (int j = 0; j < mapSize; j++)
            {
                if (map[i][j] != DOT_EMPTY)
                    continue;

                int weight = 0;

                // влево
                for (int k = j - 1; k >= 0; k--)
                    if (map[i][k] == dot)
                        weight += j - k;
                    else
                        break;

                // вправо
                for (int k = j + 1; k < mapSize; k++)
                    if (map[i][k] == dot)
                        weight += k - j;
                    else
                        break;

                // вверх
                for (int k = i - 1; k >= 0; k--)
                    if (map[k][j] == dot)
                        weight += i - k;
                    else
                        break;

                // вниз
                for (int k = i + 1; k < mapSize; k++)
                    if (map[k][j] == dot)
                        weight += k - i;
                    else
                        break;

                // влево-вверх
                for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--)
                    if (map[k][l] == dot)
                        weight += i - k;
                    else
                        break;

                // вправо-вверх
                for (int k = i - 1, l = j + 1; k >= 0 && l < mapSize; k--, l++)
                    if (map[k][l] == dot)
                        weight += i - k;
                    else
                        break;

                // вправо-вниз
                for (int k = i + 1, l = j + 1; k < mapSize && l < mapSize; k++, l++)
                    if (map[k][l] == dot)
                        weight += k - i;
                    else
                        break;

                // влево-вниз
                for (int k = i + 1, l = j - 1; k < mapSize && l >= 0; k++, l--)
                    if (map[k][l] == dot)
                        weight += k - i;
                    else
                        break;

                weights[i][j] = weight;
            }
        }

        return weights;
    }

    static boolean isValidMapCell(int x, int y)
    {
        if (x < 0 || x >= mapSize)
            return false;

        if (y < 0 || y >= mapSize)
            return false;

        return map[y][x] == DOT_EMPTY;
    }

    static int getEmptyCellsCount()
    {
        int emptyCellsCount = 0;

        for (int i = 0; i < mapSize; i++)
            for (int j = 0; j < mapSize; j++)
                if (map[i][j] == DOT_EMPTY)
                    emptyCellsCount++;

        return emptyCellsCount;
    }

    // проверка победы для 3х3, проверка условий
    static boolean isWin3x3(char dot)
    {
        if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot)
            return true;

        if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot)
            return true;

        if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot)
            return true;

        if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot)
            return true;

        if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot)
            return true;

        if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot)
            return true;

        if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot)
            return true;

        if (map[0][2] == dot && map[1][1] == dot && map[2][0] == dot)
            return true;

        return false;
    }

    // проверка победы, размер и количество фишек для победы равны, в цикле
    static boolean isWinCycle(char dot)
    {
        boolean isWin;

        for (int i = 0; i < mapSize; i++)
        {
            isWin = true;

            for (int j = 0; j < mapSize; j++)
                isWin = isWin && (map[i][j] == dot);

            if (isWin)
                return true;
        }

        for (int i = 0; i < mapSize; i++)
        {
            isWin = true;

            for (int j = 0; j < mapSize; j++)
                isWin = isWin && (map[j][i] == dot);

            if (isWin)
                return true;
        }

        isWin = true;

        for (int i = 0; i < mapSize; i++)
            isWin = isWin && (map[i][i] == dot);

        if (isWin)
            return true;

        isWin = true;

        for (int i = 0; i < mapSize; i++)
            isWin = isWin && (map[i][mapSize - 1 - i] == dot);

        if (isWin)
            return true;

        return false;
    }

    // проверка победы, общая функция для всех размеров и количества фишек для победы
    static boolean isWin(char dot)
    {
        boolean isWin;

        for (int i = 0; i < mapSize; i++)
        {
            for (int shift = 0; shift < mapSize - winLength + 1; shift++)
            {
                isWin = true;

                for (int j = 0; j < winLength; j++)
                    isWin = isWin && (map[i][j + shift] == dot);

                if (isWin)
                    return true;
            }
        }

        for (int i = 0; i < mapSize; i++)
        {
            for (int shift = 0; shift < mapSize - winLength + 1; shift++)
            {
                isWin = true;

                for (int j = 0; j < winLength; j++)
                    isWin = isWin && (map[j + shift][i] == dot);

                if (isWin)
                    return true;
            }
        }

        for (int shiftX = 0; shiftX < mapSize - winLength + 1; shiftX++)
        {
            for (int shiftY = 0; shiftY < mapSize - winLength + 1; shiftY++)
            {
                isWin = true;

                for (int i = 0; i < winLength; i++)
                    isWin = isWin && (map[i + shiftX][i + shiftY] == dot);

                if (isWin)
                    return true;
            }
        }

        for (int shiftX = 0; shiftX < mapSize - winLength + 1; shiftX++)
        {
            for (int shiftY = 0; shiftY < mapSize - winLength + 1; shiftY++)
            {
                isWin = true;

                for (int i = 0; i < winLength; i++)
                    isWin = isWin && (map[i + shiftX][mapSize - 1 - i - shiftY] == dot);

                if (isWin)
                    return true;
            }
        }

        return false;
    }
}
