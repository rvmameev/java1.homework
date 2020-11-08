package ru.geekbrains.java1.lesson3.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
/*
        Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
        "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
        "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
        компьютер показывает буквы которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно, можно пользоваться:
        String str = "apple";
        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово
        Используем только маленькие буквы
*/

        String[] words =
            {
                "apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"
            };

        playGuessWord(words);
    }

    static void playGuessWord(String[] words)
    {
        System.out.println("Игра \"Отгадай слово\". \nКомпьютер загадывает слово (подсказка: овощи и фрукты на английском языке)" +
            ", необходимо его отгадать. \nВ процессе игры выводятся подсказки по буквам. " +
            "\nЗагаданное слово состоит только из маленьких букв.");

        char[] unknownChars = getUnknownChars(words, '#', 15);

        String guessWord = getGuessWord(words);

        while (true)
        {
            System.out.println("\nВведите загаданное слово:");

            String inputWord = getInputWord();

            System.out.println("Ответ:");

            if (inputWord.equals(guessWord))
            {
                System.out.println(inputWord);

                System.out.println("\nВы выиграли!");

                break;
            } else
            {
                System.out.println(getMixedWord(guessWord, inputWord, unknownChars));
            }
        }
    }

    static char[] getUnknownChars(String[] words, char unknownChar, int maxLength)
    {
        for (int i = 0; i < words.length; i++)
        {
            int wordLength = words[i].length();

            if (maxLength < wordLength)
            {
                maxLength = wordLength;
            }
        }

        char[] unknownChars = new char[maxLength];

        for (int i = 0; i < unknownChars.length; i++)
        {
            unknownChars[i] = unknownChar;
        }

        return unknownChars;
    }

    static String getGuessWord(String[] words)
    {
        Random random = new Random();

        return words[random.nextInt(words.length)];
    }

    static String getMixedWord(String guessWord, String inputWord, char[] unknownChars)
    {
        char[] mixedChars = Arrays.copyOf(unknownChars, unknownChars.length);

        for (int i = 0; i < inputWord.length(); i++)
        {
            char currentInputChar = inputWord.charAt(i);

            if (guessWord.charAt(i) == currentInputChar)
                mixedChars[i] = currentInputChar;
        }

        return new String(mixedChars);
    }

    static String getInputWord()
    {
        Scanner scanner = new Scanner(System.in);

        return scanner.next();
    }
}
