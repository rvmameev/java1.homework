package ru.geekbrains.java1.lesson6.homework;

abstract class Animal
{
    protected final String name;
    private final double maxRunDistance;
    private final double maxSwimDistance;
    private final double maxJumpHeight;

    private static int countObject = 0;

    Animal(String name, double maxRunDistance, double maxSwimDistance, double maxJumpHeight)
    {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;

        countObject++;
    }

    boolean run(double distance)
    {
        boolean canRun = distance < maxRunDistance;

        System.out.printf("%s.maxRunDistance : %.2f%n", name, maxRunDistance);
        System.out.printf("%s.run(%.2f): %s%n", name, distance, canRun);

        return canRun;
    }

    boolean swim(double distance)
    {
        boolean canSwim = distance < maxSwimDistance;

        System.out.printf("%s.maxSwimDistance : %.2f%n", name, maxSwimDistance);
        System.out.printf("%s.swim(%.2f): %s%n", name, distance, canSwim);

        return canSwim;
    }

    boolean jump(double height)
    {
        boolean canJump = height < maxJumpHeight;

        System.out.printf("%s.maxJumpHeight : %.2f%n", name, maxJumpHeight);
        System.out.printf("%s.jump(%.2f): %s%n", name, height, canJump);

        return canJump;
    }

    String getName()
    {
        return name;
    }

    static int getCountObject()
    {
        return countObject;
    }

    protected static double getRangeValue(double expectation, double range)
    {
        double value = expectation - range + 2*range*Math.random();

        return value < 0 ? 0 : value;
    }
}
