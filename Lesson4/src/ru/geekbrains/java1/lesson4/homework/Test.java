package ru.geekbrains.java1.lesson4.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test
{
    public static void main(String[] args)
    {
//        test_getIntFromStdin();

//        test_humanTurn();

        test_aiTurnBlockHuman();

//        test_isWin(3, 3);

//        test_isWin(3, 2);

//        test_isWin(4, 2);

//        test_isWin(5, 4);
    }

    static void test_getIntFromStdin()
    {
        int inputInt = App.getIntFromStdin("Введите целое число:", 2, 4);

        System.out.println(inputInt);
    }

    static void test_humanTurn()
    {
        System.out.println("Test humanTurn");

        App.mapSize = 3;

        App.initMap();

        App.map[1][1] = App.DOT_HUMAN;
        App.map[1][2] = App.DOT_AI;

        App.printMap();

        App.humanTurn();

        App.printMap();
    }

    static void test_aiTurnBlockHuman()
    {
        System.out.println("Test aiTurnBlockHuman");

        App.mapSize = 5;
        App.aiLevel = 1;

        List<char[][]> maps = getAiTurnBlockHumanTestMaps(App.mapSize);

        for (int i = 0; i < maps.size(); i++)
        {
            App.map = maps.get(i);

            App.printMap();

            int[][] weights = App.getMapWeights(App.DOT_HUMAN);

            for (int k = 0; k < App.mapSize; k++)
                System.out.println(Arrays.toString(weights[k]));

            App.aiTurn();

            App.printMap();
        }
    }

    static void test_isWin(int mapSize, int winLength)
    {
        System.out.println("\nTest isWin, mapSize = " + mapSize + ", winLength = " + winLength);

        App.mapSize = mapSize;

        App.winLength = winLength;

        List<char[][]> maps = getIsWinTestMaps(mapSize, winLength);

        for (int i = 0; i < maps.size(); i++)
        {
            App.map = maps.get(i);

            System.out.println("\nmap #" + (i + 1));

            App.printMap();

            System.out.println("App.isWin(" + App.DOT_HUMAN + "): " + App.isWin(App.DOT_HUMAN));
        }
    }

    static List<char[][]> getIsWinTestMaps(int mapSize, int winLength)
    {
        ArrayList<char[][]> maps = new ArrayList<>();

        App.mapSize = mapSize;

        for (int i = 0; i < mapSize; i++)
        {
            for (int shift = 0; shift < mapSize - winLength + 1; shift++)
            {
                App.initMap();

                for (int j = 0; j < winLength; j++)
                {
                    App.map[i][j + shift] = App.DOT_HUMAN;
                }

                maps.add(App.map);
            }
        }

        for (int i = 0; i < mapSize; i++)
        {
            for (int shift = 0; shift < mapSize - winLength + 1; shift++)
            {
                App.initMap();

                for (int j = 0; j < winLength; j++)
                {
                    App.map[j + shift][i] = App.DOT_HUMAN;
                }

                maps.add(App.map);
            }
        }

        for (int shiftX = 0; shiftX < mapSize - winLength + 1; shiftX++)
        {
            for (int shiftY = 0; shiftY < mapSize - winLength + 1; shiftY++)
            {
                App.initMap();

                for (int i = 0; i < winLength; i++)
                {
                    App.map[i + shiftX][i + shiftY] = App.DOT_HUMAN;
                }

                maps.add(App.map);
            }
        }

        for (int shiftX = 0; shiftX < mapSize - winLength + 1; shiftX++)
        {
            for (int shiftY = 0; shiftY < mapSize - winLength + 1; shiftY++)
            {
                App.initMap();

                for (int i = 0; i < winLength; i++)
                {
                    App.map[i + shiftX][mapSize - 1 - i - shiftY] = App.DOT_HUMAN;
                }

                maps.add(App.map);
            }
        }

        return maps;
    }

    static List<char[][]> getAiTurnBlockHumanTestMaps(int mapSize)
    {
        ArrayList<char[][]> maps = new ArrayList<>();

        App.mapSize = mapSize;

        App.initMap();

        App.map[2][0] = App.DOT_HUMAN;
        App.map[2][2] = App.DOT_HUMAN;
        App.map[2][3] = App.DOT_HUMAN;

        maps.add(App.map);

        App.initMap();

        App.map[1][1] = App.DOT_HUMAN;
        App.map[2][1] = App.DOT_HUMAN;
        App.map[4][4] = App.DOT_HUMAN;

        maps.add(App.map);

        return maps;
    }
}
