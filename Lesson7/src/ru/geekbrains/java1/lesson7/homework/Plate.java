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

    public void decreaseFood(int value)
    {
        if (hasAvailableFood(value))
        {
            food -= value;
        }
    }

    public boolean hasAvailableFood(int appetite)
    {
        return food >= appetite;
    }

    public void info()
    {
        System.out.println("plate: " + food);
    }
}
