package ru.geekbrains.java1.lesson6.homework;

class Cat extends Animal
{
    private static final double MAX_RUN_DISTANCE = 200;         // максимальное расстояние бега
    private static final double MAX_RUN_DISTANCE_RANGE = 30;    // разброс максимального расстояния бега
    private static final double MAX_JUMP_HEIGHT = 2;            // максимальная высота прыжка
    private static final double MAX_JUMP_HEIGHT_RANGE = 0.3;    // разброс максимальной высоты прыжка

    private static int countObject = 0;

    Cat(String name)
    {
        super(
            name,
            getRangeValue(MAX_RUN_DISTANCE, MAX_RUN_DISTANCE_RANGE),
            getRangeValue(0, 0),
            getRangeValue(MAX_JUMP_HEIGHT, MAX_JUMP_HEIGHT_RANGE)
        );

        countObject++;
    }

    @Override
    boolean swim(double distance)
    {
        System.out.printf("%s не умеет плавать%n", name);

        return false;
    }

    static int getCountObject()
    {
        return countObject;
    }
}
