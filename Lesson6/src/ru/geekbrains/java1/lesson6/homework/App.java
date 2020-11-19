package ru.geekbrains.java1.lesson6.homework;

public class App
{
    public static void main(String[] args)
    {
        // 1. Создать классы Собака и Кот с наследованием от класса Животное.
        // 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
        //    В качестве параметра каждому методу передается величина, означающая или длину препятствия
        //    (для бега и плавания), или высоту (для прыжков).
        // 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м.,
        //    собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
        // 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
        //    (Например, dog1.run(150); -> результат: run: true)
        // 5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег
        //    может быть 400 м., у другой 600 м.

        Dog dog = new Dog("Шарик");
        dog.run(400);
        dog.swim(10);
        dog.jump(0.5);

        Cat cat = new Cat("Мурзик");
        cat.run(200);
        cat.swim(0.1);
        cat.jump(2);

        Animal[] animals = new Animal[]{
            new Cat("Пушок"),
            new Dog("Тузик"),
            new Dog("Барбос")
        };

        for (int i = 0; i < animals.length; i++)
        {
            animals[i].run(300);
            animals[i].swim(5);
            animals[i].jump(1);
        }

        System.out.println("\nКоличество животных");
        System.out.println("Создано животных: " + Animal.getCountObject());
        System.out.println("Создано собак: " + Dog.getCountObject());
        System.out.println("Создано кошек: " + Cat.getCountObject());
    }
}
