package ru.geekbrains.java1.lesson7.homework;

public class Plate
{
    private int food;

    public Plate(int food)
    {
        this.food = food;
    }

    public void increaseFood(int value)
    {
        food += value;
    }

    public boolean decreaseFood(int value)
    {
        if (food > value)
        {
            food -= value;

            return true;
        }

        return false;
    }

    public void info()
    {
        System.out.println("plate: " + food);
    }
}
