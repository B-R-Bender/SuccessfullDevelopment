package first_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by bender on 13.01.16.
 *  Предлагаю начать с легкого задания.
 1. Тестовое задание: Написать приложение зоопарк.
 1.1 Базовым классом назначить класс Animal.
 1.2 Создать 10 классов животных, которые наследуют базовый класс.
 1.3 Каждый класс должен содержать метод say(), который переопределяет метод say() из базового класса.
 1.4 Метод say() выводит сообщение в консоль, соответствующее звуку, который издает животное.
 1.5 Создать класс first_test.Zoo, в конструктор которого можно передеть количество животных, которое необходимо создать в зоопарке(классы животным должны назначаться в случайном порядке).
 1.6 Так же first_test.Zoo должен содержать метод, который возвращает коллекцию животных.
 1.7 В методе main пройтись циклом по коллекции животных и вывести результат работы метода say() для каждого животного.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hey dude!\nWanna play in zoo owner?!\nPlease enter number of animals in your private zoo :)\n");

        Zoo myZoo = new Zoo(getUserInput());

        if (myZoo.getMyZoo().isEmpty()) {
            System.out.println("Your zoo is empty, obviously you don't like animals ((( Goodbye.");
        }
        else {
            System.out.println("Do you wanna know how do they scream together?\n");
            for (Animals animal :
                    myZoo.getMyZoo()) {
                animal.say();
                Thread.sleep(1000);
            }
            System.out.println("\nThank you for playing ;)");
        }
    }

    private static int getUserInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfAnimals = 0;
        try {
            numOfAnimals = Integer.parseInt(reader.readLine());
            System.out.printf("Your zoo will count %d animals:", numOfAnimals);
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getLocalizedMessage() + " so please try again (remember to enter digits only)");
            numOfAnimals = getUserInput();
        }
        return numOfAnimals;
    }
}
