package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true){
            printMenu();

            if (scanner.hasNextInt()) {
                int command = scanner.nextInt();

                switch (command){
                    case 1:
                        stepTracker.addNewNumberStepsPerDay();
                        break;

                    case 2:
                        stepTracker.changeStepGoal();
                        break;

                    case 3:
                        stepTracker.printStatistic();
                        break;

                    case 4:
                        System.out.println("Выход из приложения. До свидания!");
                        return;

                    default:
                        System.out.println("Такой команды не существует! Попробуйте снова.");
                }
            } else {
                System.out.println("Некорректный ввод, введите число от 1 до 4.");
                scanner.next();
            }
        }



    }

    public static void printMenu() {

            System.out.println("---- StepTracker ----");
            System.out.println("1 - ввести количество шагов за определённый день");
            System.out.println("2 - изменить цель по количеству шагов в день");
            System.out.println("3 - напечатать статистику за определённый месяц");
            System.out.println("4 - выйти из приложения");
    }

}