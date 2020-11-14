package ru.geekbrains.java1.lesson6.homework;

class Dog extends Animal
{
    private static final double MAX_RUN_DISTANCE = 400;         // максимальное расстояние бега
    private static final double MAX_RUN_DISTANCE_RANGE = 100;   // разброс максимального расстояния бега
    private static final double MAX_SWIM_DISTANCE = 10;         // максимальное расстояние плавания
    private static final double MAX_SWIM_DISTANCE_RANGE = 2;    // разброс максимального расстояния плавания
    private static final double MAX_JUMP_HEIGHT = 0.5;          // максимальная высота прыжка
    private static final double MAX_JUMP_HEIGHT_RANGE = 0.1;    // разброс максимальной высоты прыжка

    private static int countObject = 0;

    Dog(String name)
    {
        super(
            name,
            getRangeValue(MAX_RUN_DISTANCE, MAX_RUN_DISTANCE_RANGE),
            getRangeValue(MAX_SWIM_DISTANCE, MAX_SWIM_DISTANCE_RANGE),
            getRangeValue(MAX_JUMP_HEIGHT, MAX_JUMP_HEIGHT_RANGE)
        );

        countObject++;
    }

    static int getCountObject()
    {
        return countObject;
    }
}
