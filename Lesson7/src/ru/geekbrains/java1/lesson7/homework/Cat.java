package ru.geekbrains.java1.lesson7.homework;

public class Cat
{
    private String name;

    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite)
    {
        this.name = name;
        this.appetite = appetite;

        isFull = false;
    }

    public void eat(Plate plate)
    {
        isFull = plate.decreaseFood(appetite);

        if (isFull)
        {
            System.out.println(name + " поел");
        }
        else
        {
            System.out.println(name + " не смог поесть");
        }
    }

    @Override
    public String toString()
    {
        return String.format("Кот: %s, аппетит: %d, сытость: %s", name, appetite, isFull);
    }
}
