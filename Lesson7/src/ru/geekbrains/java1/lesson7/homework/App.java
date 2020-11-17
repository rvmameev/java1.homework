package ru.geekbrains.java1.lesson7.homework;

public class App
{
    public static void main(String[] args)
    {
//        1. Расширить задачу про котов и тарелки с едой
//        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
//        (например, в миске 10 еды, а кот пытается покушать 15-20)
//        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
//        Если коту удалось покушать (хватило еды), сытость = true
//        4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает,
//        то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
//        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
//        и потом вывести информацию о сытости котов в консоль
//        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку

        System.out.println("Кот и тарелка:");

        Cat cat = new Cat("Барсик", 7);
        System.out.println(cat);

        Plate plate = new Plate(10);
        plate.info();

        cat.eat(plate);
        plate.info();

        System.out.println("\nКоты и тарелка:");

        plate = new Plate(4);
        plate.info();

        System.out.println("Добавили в тарелку еды");
        plate.increaseFood(15);
        plate.info();

        Cat[] cats = new Cat[]{
            new Cat("Мурзик", 7),
            new Cat("Пушок", 8),
            new Cat("Рыжик", 8),
        };

        for (int i = 0; i < cats.length; i++)
        {
            System.out.println();

            System.out.println(cats[i]);

            cats[i].eat(plate);

            System.out.println(cats[i]);

            plate.info();
        }
    }
}
